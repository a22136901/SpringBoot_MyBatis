package com.mytest.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytest.admin.bean.User;
import com.mytest.admin.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,
                             @RequestParam(value = "page",defaultValue = "1") Integer page,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        //添加重定向的参数（这样重定向回到页面的时候就会保留在当前页了）
        redirectAttributes.addAttribute("page",page);
        return "redirect:/user/list";
    }

    @GetMapping("/user/list")
    public String userList(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){

        /**
         * 让UserService实现IService<User>，并且让UserServiceImpl继承ServiceImpl<UserMapper,User>
         *     有很多已经定义好的方法可供使用。
         */
        //查询所有
//        List<User> list = userService.list();

        //创建翻页对象，分页查询数据（从第几页开始，每页几条数据）
        Page<User> userPage = new Page<>(page, 2);
        //分页查询的结果（翻页对象，进行查询的条件封装对象）
        Page<User> pages = userService.page(userPage, null);
        model.addAttribute("pages",pages);
        pages.getRecords(); //所有User记录都放到这里了

        //以下几行代码由于git测试，忽略
        pages.getCurrent();
        pages.getCurrent();
        System.out.println("冲突合并测试master");
        System.out.println("测试冲突合并hot-fix");

//        model.addAttribute("userlist",list);
        return "index";
    }

}
