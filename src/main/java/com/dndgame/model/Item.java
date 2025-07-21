package com.dndgame.model;

import java.util.UUID;

/**
 * 物品实体类
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private ItemType type;
    private int value;
    private boolean isEquipped;
    
    // 装备属性
    private int attackBonus;
    private int defenseBonus;
    private int healthBonus;
    
    public Item() {
        this.id = UUID.randomUUID().toString();
        this.isEquipped = false;
    }
    
    public Item(String name, String description, ItemType type, int value) {
        this();
        this.name = name;
        this.description = description;
        this.type = type;
        this.value = value;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }
    
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    
    public boolean isEquipped() { return isEquipped; }
    public void setEquipped(boolean equipped) { isEquipped = equipped; }
    
    public int getAttackBonus() { return attackBonus; }
    public void setAttackBonus(int attackBonus) { this.attackBonus = attackBonus; }
    
    public int getDefenseBonus() { return defenseBonus; }
    public void setDefenseBonus(int defenseBonus) { this.defenseBonus = defenseBonus; }
    
    public int getHealthBonus() { return healthBonus; }
    public void setHealthBonus(int healthBonus) { this.healthBonus = healthBonus; }
} 