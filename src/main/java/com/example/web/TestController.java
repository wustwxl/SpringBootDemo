package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: F7687967
 * @date: 2017/10/19
 * @time: 下午 02:19
 * @description: 用于单元测试
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String index() {

        return "Test Success";

    }
}
