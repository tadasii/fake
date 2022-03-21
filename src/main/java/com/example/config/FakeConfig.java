package com.example.config;

import com.example.vo.Student;
import com.github.javafaker.Faker;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Locale;

@Configuration
public class FakeConfig implements ApplicationContextAware {
    ApplicationContext applicationContext ;

    @Bean("faker")
    public Faker getFaker(){
        Faker faker = new Faker(Locale.CHINA);
        return faker;
    }

    @Bean
    @DependsOn("faker")
    public Student getFakeStudent(){
        Faker faker = (Faker) applicationContext.getBean("faker");
        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setId(faker.idNumber().valid());
        student.setAddress(faker.address().fullAddress());
        student.setIdCardNo(faker.idNumber().valid());
        return student;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
