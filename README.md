# LibraryManagementSystem
- This project is Library Management System. I used to Spring Boot, JPA, Thymeleaf, PostgreSQL.

# Library Management System

## Projenin Kurulum aşaması

 - Intelij Idea açıldıktan sonra **File->New->Project From Version Control** adımları takip edilmelidir.
 - Ardından açılan sayfada **Repository URL** yazan kısma https://github.com/omrryldrrm/SpringBootLibrary.git linki yapıştırılmalı ve **Clone** butonuna tıklanmalıdır.
 - İde gerekli işlemleri yaptıktan sonra proje çalıştırılır hale gelmiş olmaktadır.

# Veri tabanı düzenlemeleri

  - Library Management System projesinde PostgreSQL veritabanı kullanılmıştır.
  - https://www.enterprisedb.com/postgresql-tutorial-resources-training?cid=55 adresinden PostgreSQL indirilebilir.
  - PostgreSQL' de ister arayüz kısmından istenilirse de cmd ekranından **library**adında bir veritabanı alanı açılmalıdır.
  - Cmd ekranından işlem yapmak için cmd komut işlem penceresi açıldıktan sonra **psql** kodu yazılmalıdır.
  - Ardından ekranda da görüleceği üzere database in şifresi girilmelidir.
  - **create database library** yazarak *library* adında bir veritabanı alanı oluşturmuş olacağız.
  
# Library Management System application.properties ayarları
  Aşağıda verilen kod parçacığında veritabanı ayarlama işlemleri yapılmıştır.
  
  ```## PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/library -> database in adının bulunduğu kısım
spring.datasource.username=postgres                            -> database kullanıcı adı
spring.datasource.password=123456                              -> database şifresi
#hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL92Dialect  ->PostgreSQL için JDBC 
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
server.error.whitelabel.enabled=false
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration

```
# Uygulamanın çalıştırılması
  - Intelij idea açıldıktan sonra **\main\java\net\omrryldrm\library** dosyasının içinde bulunan **LibraryCrudApplication.java** dosyasında sağ tıklayıp **Run** sekmesine tıklandıktan 
    sonra proje ayağa kalkmış olur.
  - Projenin ayağa kalkmasının ardından web tarayıcımızın url kısmında **http://localhost:8080/** yazıp Enter'a tıklanması gerekmektedir.
  

