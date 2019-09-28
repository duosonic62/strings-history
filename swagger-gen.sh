#!/bin/sh

# validate swagger
docker run --rm -v ${PWD}/swagger-gen:/local openapitools/openapi-generator-cli validate -i local/swagger.yml

# generate
docker run --rm -v ${PWD}/swagger-gen:/local openapitools/openapi-generator-cli generate -i /local/swagger.yml -g kotlin-spring --additional-properties useBeanValidation=true --enable-post-process-file -o /local/out -c /local/kotlin-server-config.json

rm -rf src/main/kotlin/com/littlefeet/stringshistory/api/models
mv -f swagger-gen/out/src/main/kotlin/com/littlefeet/stringshistory/api/models src/main/kotlin/com/littlefeet/stringshistory/api/models
rm -rf swagger-gen/out
