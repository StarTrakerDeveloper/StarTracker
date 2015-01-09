@echo off
echo 添加本地JAR包到本地仓库
set /p Dfile=请填写jar所在路径:
set /p DgroupId=请填写groupId:
set /p DartifactId=请填写artifactId:
set /p Dversion=请填写version:
call mvn install:install-file -Dfile=%cd%\libs\%Dfile% -DgroupId=%DgroupId% -DartifactId=%DartifactId% -Dversion=%Dversion% -Dpackaging=jar
pause
