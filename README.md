# D&D文字冒险游戏

一个基于Java Spring Boot的龙与地下城文字冒险游戏，包含简单的前端界面。

## 项目特色

- 🎮 **经典D&D机制**: 包含六大属性、职业系统、装备系统
- 🎨 **现代化UI**: 使用Bootstrap和Font Awesome构建美观界面
- 💾 **简单持久化**: 使用JSON文件存储游戏数据，无需数据库
- 🚀 **快速开发**: 基于Spring Boot，开箱即用

## 技术栈

- **后端**: Spring Boot 3.2.0 + Java 17
- **前端**: Thymeleaf + Bootstrap 5 + Font Awesome
- **数据存储**: JSON文件 (Jackson)
- **构建工具**: Maven

## 快速开始

### 环境要求

- Java 17 或更高版本
- Maven 3.6 或更高版本

### 运行步骤

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd dnd-game
   ```

2. **编译项目**
   ```bash
   mvn clean compile
   ```

3. **运行应用**
   ```bash
   mvn spring-boot:run
   ```

4. **访问应用**
   打开浏览器访问: http://localhost:8080

## 游戏功能

### 角色系统
- **四大职业**: 战士、法师、盗贼、牧师
- **六大属性**: 力量、敏捷、体质、智力、感知、魅力
- **等级系统**: 经验值积累和等级提升
- **生命值系统**: 战斗和恢复机制

### 装备系统
- **武器**: 提供攻击加成
- **护甲**: 提供防御加成
- **药水**: 恢复生命值
- **卷轴**: 魔法物品

### 数据持久化
- 游戏数据自动保存到 `data/game_save.json`
- 服务器重启后数据不丢失
- 支持多角色管理

## 项目结构

```
src/
├── main/
│   ├── java/com/dndgame/
│   │   ├── controller/     # 控制器层
│   │   ├── model/         # 实体类
│   │   ├── service/       # 业务逻辑层
│   │   └── DndAdventureApplication.java
│   └── resources/
│       ├── templates/     # Thymeleaf模板
│       └── application.properties
└── test/                  # 测试代码
```

## 开发计划

- [x] 基础项目架构
- [x] 角色创建系统
- [x] 角色管理界面
- [ ] 战斗系统
- [ ] 冒险探索
- [ ] 任务系统
- [ ] 商店系统
- [ ] 多人游戏支持

## 贡献

欢迎提交Issue和Pull Request来改进这个项目！

## 许可证

MIT License 