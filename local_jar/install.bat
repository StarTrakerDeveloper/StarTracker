@echo off
echo ��ӱ���JAR�������زֿ�
set /p Dfile=����дjar����·��:
set /p DgroupId=����дgroupId:
set /p DartifactId=����дartifactId:
set /p Dversion=����дversion:
call mvn install:install-file -Dfile=%cd%\libs\%Dfile% -DgroupId=%DgroupId% -DartifactId=%DartifactId% -Dversion=%Dversion% -Dpackaging=jar
pause
