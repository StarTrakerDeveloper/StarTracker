@echo off
echo ----------------------------------------------------------------
echo groupId:项目或者组织的唯一标志，并且配置时生成路径也是由此生成
echo 如org.myproject.mojo生成的相对路径为：/org/myproject/mojo     
echo artifactId:项目的通用名称					    
echo version:项目的版本				            
echo packaging:打包机制，如pom,jar,maven-plugin,ejb,war,ear,rar,par
echo ----------------------------------------------------------------
echo 添加本地JAR包到本地仓库
set /p Dfile=请填写jar所在路径:
set /p isDefault=是否使用默认groupId(y or n):

if "%isDefault%"=="y" (
   set DgroupId=com.star

   echo 默认groupid为：%DgroupId%
)else set /p DgroupId=请填写groupId:

set /p DartifactId=请填写artifactId:
set /p Dversion=请填写version:

call mvn install:install-file -Dfile=%cd%\libs\%Dfile% -DgroupId=%DgroupId% -DartifactId=%DartifactId% -Dversion=%Dversion% -Dpackaging=jar
pause
