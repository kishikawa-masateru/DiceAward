@echo off

pushd %CD%
cd /d %~dp0
cd bin
java app.Main %*
popd