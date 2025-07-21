package com.dndgame.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 角色实体类
 */
public class Character {
    private String id;
    private String name;
    private CharacterClass characterClass;
    private int level;
    private int experience;
    
    // 六大属性
    private int strength;      // 力量
    private int dexterity;     // 敏捷
    private int constitution;  // 体质
    private int intelligence;  // 智力
    private int wisdom;        // 感知
    private int charisma;      // 魅力
    
    // 战斗属性
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    
    // 物品栏
    private Map<String, Item> inventory;
    
    public Character() {
        this.id = UUID.randomUUID().toString();
        this.level = 1;
        this.experience = 0;
        this.inventory = new HashMap<>();
    }
    
    public Character(String name, CharacterClass characterClass) {
        this();
        this.name = name;
        this.characterClass = characterClass;
        initializeStats();
    }
    
    private void initializeStats() {
        // 根据职业初始化属性
        switch (characterClass) {
            case WARRIOR:
                this.strength = 16;
                this.dexterity = 12;
                this.constitution = 14;
                this.intelligence = 10;
                this.wisdom = 8;
                this.charisma = 10;
                this.maxHealth = 12;
                this.armorClass = 16;
                break;
            case MAGE:
                this.strength = 8;
                this.dexterity = 12;
                this.constitution = 10;
                this.intelligence = 16;
                this.wisdom = 14;
                this.charisma = 12;
                this.maxHealth = 6;
                this.armorClass = 12;
                break;
            case ROGUE:
                this.strength = 10;
                this.dexterity = 16;
                this.constitution = 12;
                this.intelligence = 12;
                this.wisdom = 10;
                this.charisma = 14;
                this.maxHealth = 8;
                this.armorClass = 14;
                break;
            case CLERIC:
                this.strength = 12;
                this.dexterity = 10;
                this.constitution = 14;
                this.intelligence = 10;
                this.wisdom = 16;
                this.charisma = 12;
                this.maxHealth = 10;
                this.armorClass = 15;
                break;
        }
        this.currentHealth = this.maxHealth;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public CharacterClass getCharacterClass() { return characterClass; }
    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }
    
    public int getDexterity() { return dexterity; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }
    
    public int getConstitution() { return constitution; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    
    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    
    public int getCharisma() { return charisma; }
    public void setCharisma(int charisma) { this.charisma = charisma; }
    
    public int getMaxHealth() { return maxHealth; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    
    public int getCurrentHealth() { return currentHealth; }
    public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }
    
    public int getArmorClass() { return armorClass; }
    public void setArmorClass(int armorClass) { this.armorClass = armorClass; }
    
    public Map<String, Item> getInventory() { return inventory; }
    public void setInventory(Map<String, Item> inventory) { this.inventory = inventory; }
    
    // 业务方法
    public void addExperience(int exp) {
        this.experience += exp;
        checkLevelUp();
    }
    
    private void checkLevelUp() {
        int expNeeded = level * 1000; // 简单的升级经验计算
        if (experience >= expNeeded) {
            level++;
            maxHealth += 5;
            currentHealth = maxHealth; // 升级时回满血
        }
    }
    
    public void takeDamage(int damage) {
        currentHealth = Math.max(0, currentHealth - damage);
    }
    
    public void heal(int amount) {
        currentHealth = Math.min(maxHealth, currentHealth + amount);
    }
    
    public boolean isAlive() {
        return currentHealth > 0;
    }
    
    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }
    
    public void removeItem(String itemId) {
        inventory.remove(itemId);
    }
} 