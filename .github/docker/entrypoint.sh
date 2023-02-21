#!/bin/bash
#./builder
java -XX:+UseContainerSupport -XX:InitialRAMPercentage=70.0 -XX:MaxRAMPercentage=70.0 -jar server/target/server-exec.jar