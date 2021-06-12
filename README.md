# Redis-with-spring-boot

introduction to Spring Data Redis, which provides the abstractions of the Spring Data platform to Redis – the popular in-memory data structure store.

Redis is driven by a keystore-based data structure to persist data and can be used as a database, cache, message broker, etc.

We'll be able to use the common patterns of Spring Data (templates, etc.), while also having the traditional simplicity of all Spring Data projects.


## Maven Dependencies
Let's start by declaring the Spring Data Redis dependencies in the pom.xml:

```javascript
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-redis</artifactId>
    <version>2.3.3.RELEASE</version>
 </dependency>
 ```
```javascript
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.3.0</version>
    <type>jar</type>
</dependency>
```
The latest versions of spring-data-redis and jedis can be downloaded from Maven Central.

Alternatively, we can use the Spring Boot starter for Redis, which will eliminate the need for separate spring-data and jedis dependencies:

```javascript
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>2.3.3.RELEASE</version>
</dependency>
```
Again, Maven central offers the latest version information.

## The Redis Configuration
To define the connection settings between the application client and the Redis server instance, we need to use a Redis client.

There is a number of Redis client implementations available for Java. In this tutorial, we'll use Jedis – a simple and powerful Redis client implementation.

There is good support for both XML and Java configuration in the framework; for this tutorial, we'll use Java-based configuration.

3.1. Java Configuration
Let's start with the configuration bean definitions:
```javascript
@Bean
JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
}

@Bean
public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
}
```
The configuration is quite simple. First, using the Jedis client, we're defining a connectionFactory.

Then, we defined a RedisTemplate using the jedisConnectionFactory. This can be used for querying data with a custom repository.
