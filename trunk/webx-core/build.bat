setlocal
set JAVA_HOME=%java.1.6.0%
set ANT_HOME=%ant.1.7.0%
set PATH=%JAVA_HOME%\bin;%ANT_HOME%\bin;

ant jar

IF %ERRORLEVEL% NEQ 0 GOTO ERROR
echo Succeeded!
endlocal
exit 0

:ERROR
ECHO Failed!
endlocal
exit 1
