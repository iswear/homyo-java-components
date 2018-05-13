# 数据源配置说明
## 1.druid数据库配置
```java
    /**
     * 数据源驱动类
     */
    private String driverClassName = "com.mysql.jdbc.Driver";

    /**
     * 数据库地址url
     */
    private String url = "jdbc:mysql://vm-docker:3306/test?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";

    /**
     * 数据库用户名
     */
    private String username = "root";

    /**
     * 数据库用户密码
     */
    private String password = "123456";

    /**
     * 名称，不设置自动生成{@link com.alibaba.druid.pool.DruidAbstractDataSource}
     */
    private String name;

    /**
     * 初始化时链接个数
     */
    private int initialSize = 0;

    /**
     * 最大连接池数量
     */
    private int maxActive = 8;

    /**
     * 最小空闲连接数量
     */
    private int minIdle = 0;

    /**
     * 最大空闲连接数量
     */
    private int maxIdle = 8;

    /**
     * 获取连接最大等待时间
     */
    private long maxWait = -1L;

    /**
     * 是否缓存preparedStatement
     */
    private boolean poolPreparedStatements = false;

    /**
     * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
     */
    private int maxOpenPreparedStatements = -1;

    /**
     * 检测连接的SQL
     */
    private String validationQuery = "select 1";

    /**
     * 检测链接超时时间
     */
    private long validationQueryTimeout = 1;

    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    private boolean testOnBorrow = false;

    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    private boolean testOnReturn = false;

    /**
     * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，
     * 如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle = true;

    /**
     * 有两个含义：
     * 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接
     * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
     */
    private long timeBetweenEvictionRunsMillis = 60 * 1000L;

    /**
     * 连接保持空闲而不被驱逐的最长时间
     */
    private long minEvictableIdleTimeMillis = 1000L * 60L * 30L;

    /**
     * 物理连接初始化的时候执行的sql
     */
    private List<String> connectionInitSqls;
```

## 2. Example

### 2.1. application.properties

```java
homyo:
  dataSource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: localhost:20881
    username: root
    password: 123456
```

### 2.2. DataSourceConfiguration

```java
package com.homyo.components;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfigurationTest {


    @Bean
    @ConfigurationProperties(prefix = "homyo.dataSource")
    public DataSource injectDataSource() {
        return new DruidDataSource();
    }

}
```