package com.example.utils;

import com.example.vo.Student;
import com.github.javafaker.Faker;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class StudentUtils implements ApplicationContextAware {

   public  static Faker faker;
    /**
     * 随机获取一个学生类
     * @return
     */
    public static Student getRandomStudent(){
        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setId(faker.idNumber().valid());
        student.setAddress(faker.address().fullAddress());
        student.setIdCardNo(faker.idNumber().valid());
        return student;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        faker= (Faker) applicationContext.getBean("faker");
    }
}
