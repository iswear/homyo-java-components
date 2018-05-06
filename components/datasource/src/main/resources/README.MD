```
homyo:
  dataSource:
    type: druid
    config:
      driverClassName: com.mysql.cj.jdbc.Driver
      url: localhost:20881
      username: root
      password: 123456
      
  dataSourceGroup:
    type: druid
    config:
      dataSources:
        bean1:
          driverClassName: com.mysql.cj.jdbc.Driver
          url: localhost:20881
          username: root
          password: 123456
        bean2:
          driverClassName: com.mysql.cj.jdbc.Driver
          url: localhost:20881
          username: root
          password: 123456
```