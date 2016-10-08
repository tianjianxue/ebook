package com.hexian.web;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/6.
 */
@SpringBootApplication
@ComponentScan({"com.fc","com.hexian.web.controller", "com.hexian.web.service"})
@MapperScan("com.hzit.mapper")
@Repository
@Component
@Service
@Controller
public class QiDong extends SpringBootServletInitializer {

}
