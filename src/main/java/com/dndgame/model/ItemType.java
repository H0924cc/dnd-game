package com.dndgame.model;

/**
 * 物品类型枚举
 */
public enum ItemType {
    WEAPON("武器", "用于攻击的武器"),
    ARMOR("护甲", "提供防御的护甲"),
    POTION("药水", "可以恢复生命值或提供增益效果"),
    SCROLL("卷轴", "记载着魔法的卷轴"),
    GOLD("金币", "通用货币"),
    MISC("杂物", "其他物品");
    
    private final String displayName;
    private final String description;
    
    ItemType(String displayName, String description) {
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