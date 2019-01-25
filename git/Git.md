
# 常用Git命令清单。


> Workspace：工作区  
> Stage：暂存区  
> Repository：仓库区（或本地仓库）  
> Remote：远程仓库

  

## **一、新建代码库**

_# 在当前目录新建一个Git代码库_

_$ git init_

  

_# 新建一个目录，将其初始化为Git代码库_

_$ git init [project-name]_

_# 下载一个项目和它的整个代码历史_

_$ git clone [url]_

  

## **二、配置**

Git的设置文件为 .gitconfig ，它可以在用户主目录下（全局配置），也可以在项目目录下（项目配置）。

  

_# 显示当前的Git配置_

_$ git config --list_

_# 编辑Git配置文件_

_$ git config -e [--global]_

_# 设置提交代码时的用户信息_

_$ git config [--global] user.name "[name]"_

_$ git config [--global] user.email "[email address]"_

  

## **三、增加/删除文件**

_# 添加指定文件到暂存区_

_$ git add [file1] [file2] ..._

_# 添加指定目录到暂存区，包括子目录_

_$ git add [dir]_

_# 添加当前目录的所有文件到暂存区_

_$ git add ._


_# 删除工作区文件，并且将这次删除放入暂存区_

_$ git rm [file1] [file2] ..._

_# 停止追踪指定文件，但该文件会保留在工作区_

_$ git rm --cached [file]_

_# 改名文件，并且将这个改名放入暂存区_

_$ git mv [file-original] [file-renamed]_

  

## **四、代码提交**

_# 提交暂存区到仓库区_

_$ git commit -m [message]_

_# 提交暂存区的指定文件到仓库区_

_$ git commit [file1] [file2] ... -m [message]_

_# 提交工作区自上次commit之后的变化，直接到仓库区_

_$ git commit -a_

_# 提交时显示所有diff信息_

_$ git commit -v_

_# 使用一次新的commit，替代上一次提交_

_# 如果代码没有任何新变化，则用来改写上一次commit的提交信息_

_$ git commit --amend -m [message]_


  

## **五、分支**

_# 列出所有本地分支_

_$ git branch_

_# 列出所有远程分支_

_$ git branch -r_

_# 列出所有本地分支和远程分支_

_$ git branch -a_

_# 新建一个分支，但依然停留在当前分支_

_$ git branch [branch-name]_

_# 新建一个分支，并切换到该分支_

_$ git checkout -b [branch]_

_# 新建一个分支，指向指定commit_

_$ git branch [branch] [commit]_

_# 新建一个分支，与指定的远程分支建立追踪关系_

_$ git branch --track [branch] [remote-branch]_

_# 切换到指定分支，并更新工作区_

_$ git checkout [branch-name]_

_# 切换到上一个分支_

_$ git checkout -_

_# 建立追踪关系，在现有分支与指定的远程分支之间_

_$ git branch --set-upstream [branch] [remote-branch]_

_# 合并指定分支到当前分支_

_$ git merge [branch]_

_# 选择一个commit，合并进当前分支_

_$ git cherry-pick [commit]_

_# 删除分支_

_$ git branch -d [branch-name]_

_# 删除远程分支_

_$ git push origin --delete [branch-name]_

_$ git branch -dr [remote/branch]_

## **六、标签**

_# 列出所有tag_

_$ git tag_

_# 新建一个tag在当前commit_

_$ git tag [tag]_

_# 新建一个tag在指定commit_

_$ git tag [tag] [commit]_

_# 删除本地tag_

_$ git tag -d [tag]_

_# 删除远程tag_

_$ git push origin :refs/tags/[tagName]_

_# 查看tag信息_

_$ git show [tag]_

_# 提交指定tag_

_$ git push [remote] [tag]_

_# 提交所有tag_

_$ git push [remote] --tags_

_# 新建一个分支，指向某个tag_

_$ git checkout -b [branch] [tag]_

  

## **七、查看信息**

_# 显示有变更的文件_

_$ git status_

_# 显示当前分支的版本历史_

_$ git log_

_# 显示commit历史，以及每次commit发生变更的文件_

_$ git log --stat_

_# 搜索提交历史，根据关键词_

_$ git log -S [keyword]_

_# 显示某个commit之后的所有变动，每个commit占据一行_

_$ git log [tag] HEAD --pretty=format:%s_

_# 显示某个commit之后的所有变动，其"提交说明"必须符合搜索条件_

_$ git log [tag] HEAD --grep feature_

_# 显示某个文件的版本历史，包括文件改名_

_$ git log --follow [file]_

_$ git whatchanged [file]_

_# 显示指定文件相关的每一次diff_

_$ git log -p [file]_

_# 显示过去5次提交_

_$ git log -5 --pretty --oneline_

_# 显示所有提交过的用户，按提交次数排序_

_$ git shortlog -sn_

_# 显示指定文件是什么人在什么时间修改过_

_$ git blame [file]_

_# 显示暂存区和工作区的差异_

_$ git diff_

_# 显示暂存区和上一个commit的差异_

_$ git diff --cached [file]_

_# 显示工作区与当前分支最新commit之间的差异_

_$ git diff HEAD_

_# 显示两次提交之间的差异_

_$ git diff [first-branch]...[second-branch]_

_# 显示今天你写了多少行代码_

_$ git diff --shortstat "@{0 day ago}"_

_# 显示某次提交的元数据和内容变化_

_$ git show [commit]_

_# 显示某次提交发生变化的文件_

_$ git show --name-only [commit]_

_# 显示某次提交时，某个文件的内容_

_$ git show [commit]:[filename]_

_# 显示当前分支的最近几次提交_

_$ git reflog_

  

## **八、远程同步**

_# 下载远程仓库的所有变动_

_$ git fetch [remote]_

_# 显示所有远程仓库_

_$ git remote -v_

_# 显示某个远程仓库的信息_

_$ git remote show [remote]_

_# 增加一个新的远程仓库，并命名_

_$ git remote add [shortname] [url]_

_# 取回远程仓库的变化，并与本地分支合并_

_$ git pull [remote] [branch]_

_# 上传本地指定分支到远程仓库_

_$ git push [remote] [branch]_

_# 强行推送当前分支到远程仓库，即使有冲突_

_$ git push [remote] --force_

_# 推送所有分支到远程仓库_

_$ git push [remote] --all_

  

## **九、撤销**

_# 恢复暂存区的指定文件到工作区_

_$ git checkout [file]_

_# 恢复某个commit的指定文件到暂存区和工作区_

_$ git checkout [commit] [file]_

_# 恢复暂存区的所有文件到工作区_

_$ git checkout ._

_# 重置暂存区的指定文件，与上一次commit保持一致，但工作区不变_

_$ git reset [file]_

_# 重置暂存区与工作区，与上一次commit保持一致_

_$ git reset --hard_


## **其他** 
.gitignore 文件

忽略以下文件：

- 操作系统自动生成的文件，比如缩略图；
- 编译生成的中间文件，比如 Java 编译产生的 .class 文件；
- 自己的敏感信息，比如存放口令的配置文件。
- 某个文件夹 

不需要全部自己编写，可以到 [https://github.com/github/gitignore](https://github.com/github/gitignore) 中进行查询。

# Git 命令一览

<div align="center"> <img src="pics/7a29acce-f243-4914-9f00-f2988c528412.jpg"/> </div><br>

比较详细的地址：http://www.cheat-sheets.org/saved-copy/git-cheat-sheet.pdf

# 参考资料

- [Git - 简明指南](http://rogerdudler.github.io/git-guide/index.zh.html)
- [廖雪峰 : Git 教程](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)
> Written with [StackEdit](https://stackedit.io/).
