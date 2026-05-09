
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

