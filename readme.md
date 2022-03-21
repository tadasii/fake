# 本项目为com.github.javafaker的springboot测试项目

javafaker可以生成假数据，工作中，有时候需要制造假数据。一个个的set太费劲，用javafaker可以很好的解决问题。

jar包引入

```
<dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
 </dependency>
```

代码详情

```
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
```

