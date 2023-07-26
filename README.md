## MongoDB Demo With Spring Boot & Swagger

### Purpose

這是一個簡單的 **CRUD** 範例,

這裡面包含了兩種 Swagger,

一開始使用 **Spring Boot 3.1.1** 與 **Swagger3**,

後來改成與大多企業向容的 **Spring Boot 2.3.1.RELEASE** 與 **Swagger2**(詳情請看 commit 紀錄).

### Upcoming features

- [x] ~~BasicDBObject~~ 過時方法
- [x] ~~BasicDBList~~ 過時方法
- [x] Criteria
- [ ] 需要確定是否可以達成在 runtime 時才決定 endpoint

### Change History

- V1.0.1: 使用 Spring Boot 3.1.1 & Swagger3
- V2.0.1: 改為使用 Spring Boot 2.3.1.RELEASE & Swagger2
- v2.0.2: 新增使用 MongoTemplate 的進階查詢方法