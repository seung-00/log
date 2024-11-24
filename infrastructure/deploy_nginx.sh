#!/bin/bash

REPO_PATH="/Users/holden/workspace/log/infrastructure"
NGINX_CONF_DIR="/opt/homebrew/etc/nginx"
NGINX_BIN="/opt/homebrew/bin/nginx"

# Nginx 설정 파일 복사
sudo cp "$REPO_PATH/nginx.conf" "$NGINX_CONF_DIR/nginx.conf"
echo "Nginx configuration file has been updated."

# Nginx 설정 문법 검사
if ! sudo $NGINX_BIN -t; then
    echo "Nginx configuration test failed. Please check the configuration file."
    exit 1
fi

# Nginx 실행 여부 확인 및 처리
if ps aux | grep -q '[n]ginx: master process'; then
    echo "Nginx is running. Reloading Nginx..."
    sudo $NGINX_BIN -s reload
    echo "Nginx has been reloaded."
else
    echo "Nginx is not running. Starting Nginx..."
    sudo brew services start nginx
    echo "Nginx has been started."
fi

