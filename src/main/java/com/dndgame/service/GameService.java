package com.dndgame.service;

import com.dndgame.model.Character;
import com.dndgame.model.CharacterClass;
import com.dndgame.model.Item;
import com.dndgame.model.ItemType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 游戏服务类 - 核心业务逻辑
 */
@Service
public class GameService {
    
    private final Map<String, Character> characters = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String SAVE_FILE = "data/game_save.json";
    
    public GameService() {
        loadGameData();
    }
    
    /**
     * 创建新角色
     */
    public Character createCharacter(String name, CharacterClass characterClass) {
        Character character = new Character(name, characterClass);
        characters.put(character.getId(), character);
        
        // 给新角色一些基础装备
        giveStartingEquipment(character);
        
        saveGameData();
        return character;
    }
    
    /**
     * 根据ID获取角色
     */
    public Character getCharacter(String characterId) {
        return characters.get(characterId);
    }
    
    /**
     * 获取所有角色
     */
    public Map<String, Character> getAllCharacters() {
        return characters;
    }
    
    /**
     * 删除角色
     */
    public boolean deleteCharacter(String characterId) {
        Character removed = characters.remove(characterId);
        if (removed != null) {
            saveGameData();
            return true;
        }
        return false;
    }
    
    /**
     * 给角色起始装备
     */
    private void giveStartingEquipment(Character character) {
        switch (character.getCharacterClass()) {
            case WARRIOR:
                character.addItem(new Item("铁剑", "一把普通的铁剑", ItemType.WEAPON, 10));
                character.addItem(new Item("皮甲", "轻便的皮甲", ItemType.ARMOR, 5));
                character.addItem(new Item("治疗药水", "恢复生命值的药水", ItemType.POTION, 2));
                break;
            case MAGE:
                character.addItem(new Item("法杖", "魔法师的法杖", ItemType.WEAPON, 8));
                character.addItem(new Item("法师袍", "魔法师的袍子", ItemType.ARMOR, 3));
                character.addItem(new Item("魔法药水", "恢复魔力的药水", ItemType.POTION, 2));
                break;
            case ROGUE:
                character.addItem(new Item("匕首", "锋利的匕首", ItemType.WEAPON, 6));
                character.addItem(new Item("皮甲", "轻便的皮甲", ItemType.ARMOR, 4));
                character.addItem(new Item("隐身药水", "可以隐身的药水", ItemType.POTION, 1));
                break;
            case CLERIC:
                character.addItem(new Item("钉头锤", "神圣的武器", ItemType.WEAPON, 8));
                character.addItem(new Item("链甲", "金属链甲", ItemType.ARMOR, 6));
                character.addItem(new Item("治疗药水", "恢复生命值的药水", ItemType.POTION, 3));
                break;
        }
    }
    
    /**
     * 保存游戏数据到JSON文件
     */
    private void saveGameData() {
        try {
            File file = new File(SAVE_FILE);
            file.getParentFile().mkdirs(); // 确保目录存在
            objectMapper.writeValue(file, characters);
        } catch (IOException e) {
            System.err.println("保存游戏数据失败: " + e.getMessage());
        }
    }
    
    /**
     * 从JSON文件加载游戏数据
     */
    private void loadGameData() {
        try {
            File file = new File(SAVE_FILE);
            if (file.exists()) {
                Map<String, Character> loadedCharacters = objectMapper.readValue(file, 
                    objectMapper.getTypeFactory().constructMapType(
                        Map.class, String.class, Character.class));
                characters.putAll(loadedCharacters);
            }
        } catch (IOException e) {
            System.err.println("加载游戏数据失败: " + e.getMessage());
        }
    }
} 