package com.example.dailylearning.web;

import com.example.dailylearning.web.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Controller
public class BasicController {

    @Resource
    private UserDao userDao;

    // http://127.0.0.1:8080/hello?name=lisi
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "Hello " + name;
    }


    // http://127.0.0.1:8080/hello?name=lisi
    @RequestMapping("/Cs")
    @ResponseBody
    public void Cs() {
        User user = new User();
        user.setId("1");
        user.setUsername("xiafna");
        user.setAge(null);
        String[] strings = new String[3];
        strings[0]= "xiafan";
        strings[1]= "xiafan11";
        strings[2]= "xiafan222";
        user.setName(strings);
        userDao.update(user);
    }

    @RequestMapping("/Cs1")
    @ResponseBody
    public void Cs1() {
//        List<User> users = userDao.selectUser("root");
        String name = userDao.selectName();
        System.out.println(name);
    }

    // http://127.0.0.1:8080/html
    @RequestMapping("/html")
    public String html() {
        return "index.html";
    }

    @ModelAttribute
    public void parseUser(@RequestParam(name = "name", defaultValue = "unknown user") String name
            , @RequestParam(name = "age", defaultValue = "12") Integer age, User user) {
//        user.setName("zhangsan");
//        user.setAge(18);
    }
}
