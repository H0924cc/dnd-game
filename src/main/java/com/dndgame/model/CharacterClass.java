package com.dndgame.model;

/**
 * 角色职业枚举
 */
public enum CharacterClass {
    WARRIOR("战士", "强大的战士，擅长近战武器和重甲"),
    MAGE("法师", "神秘的法师，掌握强大的魔法"),
    ROGUE("盗贼", "敏捷的盗贼，擅长潜行和偷袭"),
    CLERIC("牧师", "神圣的牧师，能够治疗和驱散邪恶");
    
    private final String displayName;
    private final String description;
    
    CharacterClass(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getDescription() {
        return description;
    }
} 