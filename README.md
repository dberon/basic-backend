# basic-backend

**Contains:**

- codenarcs 
- openclover 
- gorm database migration 
- swagger

**Login example**

POST http://localhost:8080/api/login

```json
{
    "username": "client",
    "password": "client"
}
```

**Swagger endpoint (not secured)**

GET http://localhost:8080/swagger/endpoint

**Openclover command**

```cmd
./gradlew cloverGenerateReport --rerun-tasks
```

**Codenarcs command**

```cmd
./gradlew app:check
```

