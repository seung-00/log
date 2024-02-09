IMAGE_NAME="your-docker-image"

PORT_MAPPING="-p 80:8080"

#VOLUME_MOUNT="-v /path/to/host:/path/to/container"

#ENV_VARIABLES="-e VARIABLE_NAME=value"

#docker build \
#          --build-arg PHASE=PROD \
#          --build-arg ENV_FILES_PATH=/Users/seungyoungoh/Library/Mobile Documents/com~apple~CloudDocs/home/workspace/log/public \
#          -t app .s

docker build \
  --build-arg PHASE=PROD \
  --build-arg ENV_FILES_PATH=/Users/seungyoungoh/Library/Mobile\ Documents/c/home/workspace/log/public \
  --platform linux/amd64 \
  -t app .

docker tag app $IMAGE_NAME

docker run -d $PORT_MAPPING $IMAGE_NAME
