package com.dndgame.controller;

import com.dndgame.model.Character;
import com.dndgame.model.CharacterClass;
import com.dndgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 游戏控制器 - 处理Web请求
 */
@Controller
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    /**
     * 首页 - 角色列表
     */
    @GetMapping("/")
    public String index(Model model) {
        Map<String, Character> characters = gameService.getAllCharacters();
        model.addAttribute("characters", characters);
        return "index";
    }
    
    /**
     * 角色创建页面
     */
    @GetMapping("/create")
    public String createCharacterPage(Model model) {
        model.addAttribute("characterClasses", CharacterClass.values());
        return "create";
    }
    
    /**
     * 处理角色创建
     */
    @PostMapping("/create")
    public String createCharacter(@RequestParam String name, 
                                 @RequestParam CharacterClass characterClass) {
        gameService.createCharacter(name, characterClass);
        return "redirect:/";
    }
    
    /**
     * 角色详情页面
     */
    @GetMapping("/character/{id}")
    public String characterDetail(@PathVariable String id, Model model) {
        Character character = gameService.getCharacter(id);
        if (character == null) {
            return "redirect:/";
        }
        model.addAttribute("character", character);
        return "character";
    }
    
    /**
     * 删除角色
     */
    @PostMapping("/character/{id}/delete")
    public String deleteCharacter(@PathVariable String id) {
        gameService.deleteCharacter(id);
        return "redirect:/";
    }
    
    /**
     * 游戏主界面
     */
    @GetMapping("/game/{id}")
    public String gamePage(@PathVariable String id, Model model) {
        Character character = gameService.getCharacter(id);
        if (character == null) {
            return "redirect:/";
        }
        model.addAttribute("character", character);
        return "game";
    }
} 