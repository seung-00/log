#!/bin/bash

REPO_PATH="/Users/holden/workspace/log/infrastructure"

NGINX_CONF_DIR="/opt/homebrew/etc/nginx"

sudo cp "$REPO_PATH/nginx.conf" "$NGINX_CONF_DIR/nginx.conf"

# Stop Nginx if it's running
echo "Stopping Nginx if it's running..."
sudo brew services stop nginx

# Start Nginx
echo "Starting Nginx..."
sudo brew services start nginx

echo "Nginx configuration has been updated and Nginx has been restarted."

