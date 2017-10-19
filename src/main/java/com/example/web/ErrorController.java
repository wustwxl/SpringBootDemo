package com.example.web;

import com.example.utils.MyException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * @author: F7687967
 * Date: 2017/10/14
 * Time: 上午 09:10
 * Description: @RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了
 */
@RestController
public class ErrorController {

    @ApiOperation(value = "异常处理", notes = "测试统一异常处理")
    @RequestMapping(value = "/error", produces="text/plain;charset=UTF-8",method = RequestMethod.GET)
    public String index() throws Exception {

        throw new MyException("110", "报警啦——");

    }
}
