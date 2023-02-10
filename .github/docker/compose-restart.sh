#!/usr/bin/env bash

function check_docker_network() {
  # shellcheck disable=SC2162
  while read line; do
    # shellcheck disable=SC2154
    if [[ $link == "uni-network" ]]; then
      return 1
    fi
    echo $line
  done <tmp.txt
  return 0
}

# 网络检查
ls -al
echo "--------------> 检查docker网络中ing ---------------"
docker network ls | awk '{print $2}' >tmp.txt
if check_docker_network "$1"; then
  echo "--------------> 检查docker网络已存在 ---------------"
else
  echo "--------------> 检查docker网络不存在 ---------------"
  echo "--------------> docker网络创建中 ---------------"
  docker network create uni-network
  echo "--------------> docker网络创建完成 ---------------"
fi

# 关闭服务
echo "--------------> docker compose down中 ---------------"
docker compose down

echo "--------------> docker 删除所有停止的容器中 ---------------"
# 删除所有停止的容器
docker container prune -f

echo "--------------> docker 删除所有不使用的镜像中 ---------------"
# 删除所有不使用的镜像
docker image prune --force --all

echo "--------------> docker compose up中 ---------------"
docker compose up -d
