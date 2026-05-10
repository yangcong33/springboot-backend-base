
## git 使用
1. `git init`
2. `git config user.name`
3. `git config user.email `
4. `git config user.name "name"`
5. `git config user.email "email" `
6. `git status`
>位于分支 master
>
>尚无提交
>
>未跟踪的文件:
>  （使用 "git add <文件>..." 以包含要提交的内容）
>        README.md
>        day01-learning-review.md
>
>提交为空，但是存在尚未跟踪的文件（使用 "git add" 建立跟踪）
7. `git log`
> fatal: 您的当前分支 'master' 尚无任何提交

8. 新增`.gitignore`文件 `touch .gitignore`

并添加 临时版本：
```bash
# Java / Maven
target/
*.class

# Gradle
.gradle/
build/

# IDE
.idea/
*.iml
.vscode/

# Logs
logs/
*.log

# Env / secrets
.env
.env.*
!.env.example

# OS
.DS_Store
Thumbs.db

# Runtime / crash
hs_err_pid*
replay_pid*

```
若使用命令添加：`cat `
```bash
$ cat << 'EOF' > .gitignore
> # Java / Maven
> target/
> *.class
> 
> # Gradle
> .gradle/
> build/
> 
> # IDE
> .idea/
> *.iml
> .vscode/
> 
> # Logs
> logs/
> *.log
> 
> # Env / secrets
> .env
> .env.*
> !.env.example
> 
> # OS
> .DS_Store
> Thumbs.db
> 
> # Runtime / crash
> hs_err_pid*
> replay_pid*
> EOF
```
或  `echo`
```bash
echo "content" > filename

```
8.1 `git log` 在第一次提交前报: fatal: 您的当前分支 'master' 尚无任何提交

9. `git add .`

10.  `git commit -m "docs: 初始化项目骨架与本地文档结构"`

11. 确认仓库根目录：`git rev-parse --show-toplevel`



###  粗心 | 误操作 | 修复
错误记录：
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base/docs$ git init
已初始化空的 Git 仓库于 /home/wj/Jacob_private_space/hello/agent/springboot-backend-base/docs/.git/

(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base/docs$ ls -la
总用量 20
drwxrwxr-x 3 wj wj 4096 5月   9 18:47 .
drwxrwxr-x 3 wj wj 4096 5月   9 18:42 ..
-rw-rw-r-- 1 wj wj  519 5月   9 18:57 day01-learning-review.md
drwxrwxr-x 7 wj wj 4096 5月   9 18:50 .git
-rw-rw-r-- 1 wj wj  732 5月   9 18:50 README.md

错误二：
如果你的 README.md 也被误放进了 docs 目录，把它移回项目根目录：
mv docs/README.md ./README.md

修复：
删除误创建的 docs/.git：rm -rf docs/.git
重写：git init


## spring boot 项目测试
### HelloController和SorryController
使用    `/api/`路径
简单测试。

## application.yaml 配置文文件第一版
```yaml
server:
  port: 8080

spring:
  application:
    name: springboot-backend-base

management:
  endpoints:
    web:
      exposure:
        include: health,info
  endpoint:
    health:
      show-details: always
```

##  git 查看状态，日志，暂存区，提交本地仓库
1. `git status`
2. `git log`
3. `git add .`
4. `git status`
5. 检查用户信息 `git config user.name` , ` git config user.email`
6. `git commit -m "init spring boot project skeleton."`
7. `git status`,`git log`
8. 提交本地仓库并检查over


## todo push到远程仓库

### 安装GitHub CLI
1. [GitHub CLI 快速入门](https://docs.github.com/zh/github-cli/github-cli/quickstart)
2. [GitHub CLI install](https://github.com/cli/cli?ref_product=cli&ref_type=engagement&ref_style=text#installation)

> gh 就是 GitHub CLI（Command Line Interface，命令行界面）这个软件在终端里执行时的“命令名称”。
> (就像你敲 java 是为了运行 Java 程序，敲 gh 就是在唤起 GitHub CLI 这个专属工具。
> )
> gh 是 GitHub 官方专门为了自家平台量身定制的工具。它的底层代码里写死了只和 api.github.com（GitHub 的服务器）进行通信。 

- git 是通用的基础设施.
- gh 是高度定制的VIP客户端：它建立在 git 的基础之上，专门用来处理那些 Git 管不了的、只有 GitHub 网页上才有的特有功能（比如创建远端空仓库、提 Pull Request、回复 Issue、跑 GitHub Actions 流水线等）。

### installation
```bash
(type -p wget >/dev/null || (sudo apt update && sudo apt install wget -y)) \
	&& sudo mkdir -p -m 755 /etc/apt/keyrings \
	&& out=$(mktemp) && wget -nv -O$out https://cli.github.com/packages/githubcli-archive-keyring.gpg \
	&& cat $out | sudo tee /etc/apt/keyrings/githubcli-archive-keyring.gpg > /dev/null \
	&& sudo chmod go+r /etc/apt/keyrings/githubcli-archive-keyring.gpg \
	&& sudo mkdir -p -m 755 /etc/apt/sources.list.d \
	&& echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null \
	&& sudo apt update \
	&& sudo apt install gh -y
```

### validation
`gh -v`

### new repo
1. [gh repo new reference docs](https://cli.github.com/manual/gh_repo_create)
`gh repo create `

#### [tips]我在使用gh的时候，分析gh出现了冲突
使用`which gh`，我发现它的目录路径是`/home/wj/.local/bin/gh`.
而我们安装的GitHub CLI是在系统管理员户级别的 ： ` /usr/bin/gh`.

**但是，我们不敢轻易敲下 rm 删除，这绝对是一个极其优秀的开发和运维习惯！我们采用设置小脚表运行我们指定的github cli的gh，也就是设置别名**
别名（Alias）
`nano ~/.bashrc`
`source ~/.bashrc`

#### 创建前需要先授权
`gh auth login`
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ gh auth login
? Where do you use GitHub? GitHub.com
? What is your preferred protocol for Git operations on this host? HTTPS
? How would you like to authenticate GitHub CLI? Paste an authentication token
Tip: you can generate a Personal Access Token here https://github.com/settings/tokens
The minimum required scopes are 'repo', 'read:org', 'workflow'.
? Paste your authentication token: ****************************************
- gh config set -h github.com git_protocol https
✓ Configured git protocol
✓ Logged in as Jacob000-0
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ 
```
**创建远程仓库**
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ gh repo create
? What would you like to do? Create a new repository on github.com from scratch
? Repository name springboot-backend-base
? Repository owner yangcong33
? Description init spring boot project skeleton.
? Visibility Public
? Would you like to add a README file? Yes
? Would you like to add a .gitignore? No
? Would you like to add a license? No
? This will create "yangcong33/springboot-backend-base" as a public repository on github.com. Continue? Yes
✓ Created repository yangcong33/springboot-backend-base on github.com
  https://github.com/yangcong33/springboot-backend-base
? Clone the new repository locally? No
```

### 检擦仓库
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ gh repo view gh repo view yangcong33/springboot-backend-base --web
accepts at most 1 arg(s), received 4
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ gh repo view yangcong33/springboot-backend-base --w
eb
Opening https://github.com/yangcong33/springboot-backend-base in your browser.
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ gh repo view yangcong33/springboot-backend-base
yangcong33/springboot-backend-base
init spring boot project skeleton.


   springboot-backend-base                                                                                            
                                                                                                                      
  init spring boot project skeleton.                                                                                  



View this repository on GitHub: https://github.com/yangcong33/springboot-backend-base
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ 
```

##  本地仓库连接远程仓库
`git remote add origin https://github.com/yangcong33/springboot-backend-base.git`
## 修改 本地仓库分支名称-统一分支名称
`git branch -M main` 
GitHub 现在默认主分支叫 main，而本地旧版 Git 默认叫 master。为了避免一会儿推送错乱，先把本地分支改名叫 main：git branch -M main
>  (base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git status 位于分支 main

##  [细节]修复细节-解决 README 冲突并推送
解决 README 冲突并推送。
(注意：因为你刚才建库时手快选了生成 README，导致远程仓库里已经有了一个提交记录。如果现在直接 Push 会被拒绝。我们需要先把远程的 README “拉”下来融到本地，然后再“推”上去)
操作：
```bash
# 把远程的 README 强行拉取并合并到本地代码中
git pull origin main --allow-unrelated-histories

# 把所有代码正式推送到 GitHub
git push -u origin main
```
解决结果：
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git config --global https.proxy http://127.0.0.1:78
97
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git pull origin main --allow-unrelated-histories -v
POST git-upload-pack (265 bytes)
warning: 没有共同的提交
remote: Enumerating objects: 3, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
展开对象中: 100% (3/3), 906 字节 | 906.00 KiB/s, 完成.
来自 https://github.com/yangcong33/springboot-backend-base
 * branch            main       -> FETCH_HEAD
 * [新分支]          main       -> origin/main
error: 您对下列文件的本地修改将被合并操作覆盖：
        README.md
请在合并前提交或贮藏您的修改。
正在终止
```



## 网络问题-GitHub
问题：
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git pull origin main --allow-unrelated-histories

error: RPC 失败。curl 28 Failed to connect to github.com port 443: 连接超时
fatal: 远端意外挂断了

---

(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git push -u origin main
fatal: 无法访问 'https://github.com/yangcong33/springboot-backend-base.git/'：Failed to connect to github.com port 443: 连接超时

```
解决：
1. 镜像
2. 代理[参考链接](https://blog.csdn.net/Hodors/article/details/103226958)
3. ssh

使用代理解决:
1. 类似的配置 代理IP地址
`git config --global http.proxy http://127.0.0.1:1080`
`git config --global https.proxy http://127.0.0.1:1080`

本地我们使用：(因为我们使用的是clash) Clash 系列（包括 Verge 等）：通常是 7890
我用的是7897
`git config --global http.proxy http://127.0.0.1:7890`
`git config --global https.proxy http://127.0.0.1:7890`
如果你以后想取消代理，执行 git config --global --unset http.proxy 和 https.proxy 即可。


## 网络问题解决
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git config --global https.proxy http://127.0.0.1:78
97
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git pull origin main --allow-unrelated-histories -v
POST git-upload-pack (265 bytes)
warning: 没有共同的提交
remote: Enumerating objects: 3, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
展开对象中: 100% (3/3), 906 字节 | 906.00 KiB/s, 完成.
来自 https://github.com/yangcong33/springboot-backend-base
 * branch            main       -> FETCH_HEAD
 * [新分支]          main       -> origin/main
error: 您对下列文件的本地修改将被合并操作覆盖：
        README.md
请在合并前提交或贮藏您的修改。
正在终止
```

##  执行` git push -u origin main` wenti问题出现
```bash
(base) wj@dqgc-HP-Z4-G4-Workstation:~/Jacob_private_space/hello/agent/springboot-backend-base$ git push -u origin main
To https://github.com/yangcong33/springboot-backend-base.git
 ! [rejected]        main -> main (non-fast-forward)
error: 无法推送一些引用到 'https://github.com/yangcong33/springboot-backend-base.git'
提示：更新被拒绝，因为您当前分支的最新提交落后于其对应的远程分支。
提示：再次推送前，先与远程变更合并（如 'git pull ...'）。详见
提示：'git push --help' 中的 'Note about fast-forwards' 小节。
```
**解决与分析**：本地文件夹里，目前已经有一个 README.md 文件了，但是做了修改忘记添加并提交到本地仓库。（还没有把它 commit（提交）保存下来。）
1. `git status`
2. `git add .` && `git commit -m "commit reame.md && day01-notes"`
>[main 3688511] commit reame.md && day01-notes
>2 files changed, 288 insertions(+), 2 deletions(-)

3. `git log`
4. 再次尝试，拉取远程并合并：`git pull origin main --allow-unrelated-histories -v`
5. 成功后可以，push上传了 `git push -u origin main` -u 是 --set-upstream（设置上游）的缩写.
---

README 是后面作品集包装的起点，从第一天就开始维护会很加分。

---

### 8.13 今日不要做的事情

今天先不要做：

- 不要接 Spring AI。
- 不要接 LangChain。
- 不要做 RAG。
- 不要设计复杂数据库表。
- 不要写用户登录权限。
- 不要做前端页面。
- 不要纠结最终项目名。
- 不要一次性加太多依赖。

今天只做一件事：把 Spring Boot 后端基础框架跑稳。



---

### 8.14 今日常见问题与排查

#### 端口 8080 被占用

可以临时修改端口：

```yaml
server:
  port: 8081