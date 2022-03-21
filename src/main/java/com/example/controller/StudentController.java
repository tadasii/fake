package com.example.controller;

import com.example.utils.StudentUtils;
import com.example.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    Student student;

    /**
     * 返回固定的student
     * @return
     */
    @GetMapping("/getStudent")
    public Student getStudent(){
        System.out.println("========");
        return student;
    }

    /**
     * 返回一个随机的student
     * @return
     */
    @GetMapping("/random")
    public Student randomStudent(){
       return StudentUtils.getRandomStudent();
    }

    /**
     * 返回十个随机的student
     * @return
     */
    @GetMapping("/getTenRandomStudent")
    public List<Student> getTenRandomStudent(){
        return Stream.generate(()->StudentUtils.getRandomStudent()).limit(10).collect(Collectors.toList());
    }


}
