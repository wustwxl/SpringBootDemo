package com.example.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * @author: F7687967
 * Date: 2017/10/14
 * Time: 上午 09:10
 * Description:
 */
@Controller
public class HelloController {

    @ApiOperation(value = "首页", notes = "Just do it!")
    @RequestMapping(value = "/", produces="text/plain;charset=UTF-8",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ApiOperation(value = "首次测试", notes = "Just do it!")
    @RequestMapping(value = "/hello", produces="text/plain;charset=UTF-8",method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
