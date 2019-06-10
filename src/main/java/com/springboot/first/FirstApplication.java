package com.springboot.first;

import com.springboot.modal.Cust;
import com.springboot.service.CustService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
@EnableTransactionManagement   //开启事务管理
@ComponentScan("com.springboot") // 启动类 加载器扫描 controller
@MapperScan("com.springboot.mapper")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
public class FirstApplication {

    @Autowired
    private CustService custService;

    @RequestMapping("/")
    String index() {
        return  "hello spring boot";
    }

    @ResponseBody
    @RequestMapping("/getAllCust")
    public List<Cust> getAllCust() {
        List<Cust> users =  custService.getAllCust();

        return users;
    }

/*    @ResponseBody
    @RequestMapping("/find")
    public Cust find() {
        Cust cust =  custService.find();

        return cust;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

}
