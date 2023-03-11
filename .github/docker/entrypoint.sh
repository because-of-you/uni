#!/bin/bash
#./builder
java \
  -XX:+UseContainerSupport \
  -XX:InitialRAMPercentage=30.0 \
  -XX:MaxRAMPercentage=30.0 \
  -Xshareclasses:cacheDir=.cache/javasharedresources \
  -Xtune:virtualized \
  -Xquickstart \
  -jar server/target/server-exec.jar