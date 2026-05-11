# todo
[ ]controller / service / domain / common 基础分层 

[ ]统一响应结构 ApiResponse

[ ] 全局异常处理 GlobalExceptionHandler

## 统一响应结构：ApiResponse
目标响应格式:
```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```
- 用 Java 17 `record`，代码简洁。
- 成功统一返回 `code=0`。
- 失败统一返回错误码和错误信息。
- 暂不设计复杂错误码枚举。


## 全局异常处理类（GlobalExceptionHandler ）
> GlobalExceptionHandler 就是 Controller 的全局兜底捕手：谁在请求处理过程中抛异常，它负责接住、翻译成统一 JSON，再返回给客户端。
1. 用 @RestControllerAdvice 声明全局异常处理类
2. 用 @ExceptionHandler(具体异常.class) 捕获某类异常
3. 从异常对象里提取错误信息
4. 返回统一 ApiResponse
5. 最后用 Exception.class 做兜底


## 最后流程-git提交
> 深度学习git，保证commit颗粒度
> 
> 
分析：
1. 本次工作，我不能再在main分支上进行操作添加提交了，需要更换为子分支；
2. 那么，现在重要的工作就是我要分析怎么创建子分子？怎么选择子分支的名称？是不是在业界有一定的相关规范和规定呢？
这一思考，我应该怎么下手，是不是首先动手去Google查询相关内容，再通过AI 辅助我全面的查询相关想法和资料。
个人检索：（我的提问在Google搜索上）git commit颗粒度怎么提交分支？
   >  **我觉得找到答案重要的是我写/表达的问题是不是跟我内心想要的疑问一致，我的表达能否高效准确地从Google搜索中找到呢?{这个环节很重要，但我总觉得我的表述有些问题，所以又会去更倾向选择AI问答相关疑问}**
   
    - [细粒度的力量：精炼Git Commit如何驱动高质量软件迭代与维护](https://zhuanlan.zhihu.com/p/688218059)---并没有找到我想要的答案
    - [Git-rebase 黑魔法之打磨 commit 颗粒度](https://drprincess.github.io/2018/02/27/Git-rebase%E6%89%93%E9%80%A0%E5%96%9C%E6%AC%A2%E7%9A%84commit%E9%A2%97%E7%B2%92%E6%84%9F/)---似乎还是没我要的答案
    - [Git 团队协作流程规范](https://juejin.cn/post/7052534060123422751)  ---  **e嗯嗯嗯，这份文章不错是我想要的学习的内容！，内含：[todo | A successful Git branching model](https://nvie.com/posts/a-successful-git-branching-model/)**
    - [todo | git合并指定commit——git合并某个特定的提交commit到指定的分支上](https://blog.csdn.net/weixin_44867717/article/details/120885717)
    - [todo | Git Commit Message 规范| 云原生AI实战星球](https://konglingfei.com/onex/convention/commit.html#header)
    
    
### 实操-分支
1. 发现pom.xml有疑问 git diff发现也没有什么改动，就是用`git resort -- pom.xml`恢复了
2. 检查分支 `git status ` ,发现在 main
3. 创建分支 `unified-infrastrcture`并切换`git checkout -b feature/unified-infrastructure `
4. 检查 `git status`,确保在`unified-infrastrcture`
5. 提交基建 `git add src/main/java/com/jacob/backend/common/
   git commit -m "feat: 增加 ApiResponse 与全局异常处理"`
6. Ⅰ`git add src/main/java/com/jacob/backend/controller/HealthController.java
   git commit -m "feat: 增加健康检查接口"`

Ⅱ`git add src/main/java/com/jacob/backend/domain/ \
src/main/java/com/jacob/backend/service/ \
src/main/java/com/jacob/backend/controller/DemoController.java
git commit -m "feat: 实现 Demo 业务逻辑及 DTO/VO 分层流转"`

Ⅲ`git add docs/day02-learning-note.md
git commit -m "docs: 新增 Day02 全局异常与分层架构复盘笔记"`

7. 检查的时候 `git status`，`git  log --oneline --decorate -5`,发现我的笔记还没更新完。但我已经add commit了，我怎么操作呢？
8. 修复救急： git status  
```bash
位于分支 feature/unified-infrastructure
尚未暂存以备提交的变更：
  （使用 "git add <文件>..." 更新要提交的内容）
  （使用 "git restore <文件>..." 丢弃工作区的改动）
        修改：     docs/day02-learning-note.md

修改尚未加入提交（使用 "git add" 和/或 "git commit -a"）
```
9. `git add docs/day02-learning-note.md`
10. `git commit --amend --no-edit`
11.`git status`
`git log --oneline -5`
12. `git push -u origin feature/unified-infrastructure`

# day02 over!
