package com.yy.blog.controller;

import com.yy.blog.domain.User;
import com.yy.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView List(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user.get());
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 保存或修改用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除
     * @param id
     */
    @GetMapping(value = "/del/{id}")
    public ModelAndView del(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user.get());
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);

    }
}
