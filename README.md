# Spring Boot Backend Base

## 项目介绍

这是一个用于后续学习 Spring AI、RAG、Agent 工程的 Spring Boot 后端基础框架。

当前阶段先完成通用后端工程底座，后续会逐步接入：

- Spring AI
- 企业知识库 RAG
- Tool Calling
- Agent
- Python 模型服务
- Docker Compose 部署

## 技术栈

- Java 17/21
- Spring Boot 3.x
- Spring Web
- Spring Validation
- Spring Boot Actuator
- Maven

## 本地启动

```bash
mvn spring-boot:run

##  项目骨架搭建
`# 创建层级目录 mkdir -p ~/hello/agent/springboot-backend-base `
`# 进入项目根目录cd ~/hello/agent/springboot-backend-base  `
## 文档工作流
`# 创建文档专用目录  mkdir docs`

`# 创建项目的主说明说明文件  touch README.md`

`# 创建你今天的第一篇复盘笔记文件 touch docs/day01-learning-review.md `

## 初始化仓库
1. `git init  # 初始化 Git 仓库`
2. 记得配置当前项目用户信息 `git config user.name "name"` ; `git config user.email "email@eamil.xx"`
3. `# 先把我们刚刚建好的文档提交到暂存区 git add README.md docs/`
4. 规范的第一次提交 (Commit) `git commit -m "docs: 初始化项目骨架与本地文档结构"`



