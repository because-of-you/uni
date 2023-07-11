#!/bin/bash
java \
  -XX:+UseContainerSupport \
  -XX:InitialRAMPercentage=30.0 \
  -XX:MaxRAMPercentage=30.0 \
  -Xshareclasses \
  -Xtune:virtualized \
  -Xquickstart \
  -jar server-exec.jar