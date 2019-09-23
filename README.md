# Strings History App

## mysql
```
docker run --name strings-mysql \
 -e MYSQL_ROOT_PASSWORD=pass \
 -e MYSQL_DATABASE=strings_history \
 -e MYSQL_ROOT_HOST='%' -e TZ='Asia/Tokyo' \
 -p 3306:3306 \
 mysql/mysql-server:5.7 \
 --character-set-server=utf8mb4\ 
 --collation-server=utf8mb4_general_ci
```

## swagger
### code gen
* usage
```shell
$ sh swagger-gen.sh
```

* swagger generate
use docker openapi-generator image
```
docker run --rm -v $PWD:/local \
  openapitools/openapi-generator-cli generate \
  -i /local/swagger.yml \
  -g kotlin-spring \
  --additional-properties useBeanValidation=true \
  --enable-post-process-file \
  -o /local \
  -c /local/kotlin-server-config.json
```

* swagger validate
```
docker run --rm -v $PWD:/local \
  openapitools/openapi-generator-cli validate \
  -i local/swagger.yml
```