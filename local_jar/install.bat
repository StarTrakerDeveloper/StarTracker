@echo off
echo ----------------------------------------------------------------
echo groupId:��Ŀ������֯��Ψһ��־����������ʱ����·��Ҳ���ɴ�����
echo ��org.myproject.mojo���ɵ����·��Ϊ��/org/myproject/mojo     
echo artifactId:��Ŀ��ͨ������					    
echo version:��Ŀ�İ汾				            
echo packaging:������ƣ���pom,jar,maven-plugin,ejb,war,ear,rar,par
echo ----------------------------------------------------------------
echo ��ӱ���JAR�������زֿ�
set /p Dfile=����дjar����·��:
set /p isDefault=�Ƿ�ʹ��Ĭ��groupId(y or n):

if "%isDefault%"=="y" (
   set DgroupId=com.star

   echo Ĭ��groupidΪ��%DgroupId%
)else set /p DgroupId=����дgroupId:

set /p DartifactId=����дartifactId:
set /p Dversion=����дversion:

call mvn install:install-file -Dfile=%cd%\libs\%Dfile% -DgroupId=%DgroupId% -DartifactId=%DartifactId% -Dversion=%Dversion% -Dpackaging=jar
pause
