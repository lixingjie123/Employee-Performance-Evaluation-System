package com.epes.demo.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2017-12-25
 * Time: 11:15
 */

/**
 * 使用@ConfigurationProperties
 * 需要添加@Component
 * */
@Component
@ConfigurationProperties(prefix = "client")
public class ClientProperties {

    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
