# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


```shell
#connect to docker mysql
mysql --host=localhost --user=my_user --password=my_password my_database

#backup DB data
docker exec <CONTAINER> /usr/bin/mysqldump -u root --password=root  -r <DATABASE> | Set-Content backup.sql
docker exec <CONTAINER> /usr/bin/mysqldump -u root --password=root  -r <DATABASE> > backup.sql

#restore DB data
cat backup.sql | docker exec -i <CONTAINER> /usr/bin/mysql -u root  
--password=root <DATABASE>
```