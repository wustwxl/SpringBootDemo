package com.example.web;

import com.example.entity.User;
import com.example.service.UserMapper;
import com.example.utils.MessageVo;
import com.example.utils.TypeConversionUtil;
import com.example.utils.WebLogAspect;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * @author: F7687967
 * Date: 2017/10/16
 * Time: 上午 08:10
 * Description:
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    /**
     * @Description: 创建线程安全的Map
    */
    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public MessageVo postUser(@RequestBody User user) {

        MessageVo mesVo = new MessageVo();
        User myUser = new User();
        TypeConversionUtil.VoConvertToEntity(user,myUser);
        userMapper.create(user);
        mesVo.setCode("1");
        mesVo.setData(user);
        mesVo.setInfo("创建用户成功");
        return mesVo;
    }

    @ApiOperation(value = "获取用户数目", notes = "获取用户数目")
    @RequestMapping(value = "/userNum", method = RequestMethod.GET)
    public MessageVo getUserList() {

        MessageVo mesVo = new MessageVo();
        int num = userMapper.getAllUsersNum();
        mesVo.setCode("1");
        mesVo.setData(num);
        mesVo.setInfo("获取用户数目成功");
        return mesVo;
    }

    @ApiOperation(value = "获取指定用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MessageVo getUser(@PathVariable("id") int id) {

        MessageVo mesVo = new MessageVo();
        User currUser = userMapper.getUserById(id);
        mesVo.setCode("1");
        mesVo.setData(currUser);
        mesVo.setInfo("获取指定用户详细信息成功");
        return mesVo;
    }

    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public MessageVo findAllUsers() {
        MessageVo mesVo = new MessageVo();
        List<User> allUsers = userMapper.findAllUsers();
        mesVo.setCode("1");
        mesVo.setData(allUsers);
        mesVo.setInfo("获取所有用户的信息成功");
        return mesVo;
    }

    @ApiOperation(value = "更新指定用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MessageVo putUser(@PathVariable("id") int id, @RequestBody User user) {

        MessageVo mesVo = new MessageVo();
        user.setId(Integer.toUnsignedLong(id));
        userMapper.updateUserById(user);
        mesVo.setCode("1");
        mesVo.setData(user);
        mesVo.setInfo("修改指定用户详细信息成功");
        return mesVo;
    }

    @ApiOperation(value = "删除所有用户", notes = "删除所有用户")
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public MessageVo deleteAllUsers() {
        MessageVo mesVo = new MessageVo();
        userMapper.deleteAllUsers();
        mesVo.setCode("1");
        mesVo.setData("删除所有用户");
        mesVo.setInfo("删除所有用户成功");
        return mesVo;
    }

    @ApiOperation(value = "删除指定用户", notes = "根据url的name来指定删除对象")
    @ApiImplicitParam(name = "name", value = "用户Name", required = true, dataType = "String")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public MessageVo deleteUser(@PathVariable("name") String name) {
        MessageVo mesVo = new MessageVo();
        userMapper.deleteByName(name);
        mesVo.setCode("1");
        mesVo.setData(name);
        mesVo.setInfo("删除指定用户成功");
        return mesVo;
    }


}
