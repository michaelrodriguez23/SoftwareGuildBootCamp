/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.controller;

import com.mr.blogMastery.dao.CommentDaoImpl;
import com.mr.blogMastery.dao.HashTagDaoImpl;
import com.mr.blogMastery.dao.PostDaoImpl;
import com.mr.blogMastery.dao.RoleDaoImpl;
import com.mr.blogMastery.dao.UserDaoImpl;
import com.mr.blogMastery.dto.Post;
import com.mr.blogMastery.dto.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author michaelrodriguez
 */
@Controller
public class AdminController {

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    PostDaoImpl postDao;

    @Autowired
    CommentDaoImpl commentDao;

    @Autowired
    RoleDaoImpl roleDao;

    @Autowired
    HashTagDaoImpl hashTagDao;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping({"/admin"})
    public String displayHomePage(Model model) {
        List<Post> posts = postDao.ReadAllPostUnpublished();
        model.addAttribute("posts", posts);
        List staticPostList = postDao.ReadAllPostStatic();
        model.addAttribute("staticPostList", staticPostList);
        List blogList = postDao.ReadAllPostForBlog();
        model.addAttribute("blogList", blogList);

        List userList = userDao.ReadAll();
        model.addAttribute("userList", userList);

        List hashTagList = hashTagDao.ReadAll();
        model.addAttribute("hashTagList", hashTagList);
        return "/admin";

    }

    @GetMapping("publishPost")
    public String publishPost(Integer id) {
        Post post = postDao.ReadById(id);
        post.setPublished(true);
        postDao.Update(post);
        return "redirect:/home";

    }

    @GetMapping("editUser")
    public String editUser(Integer id, Model model, String firstName, String lastName, String email, String userName, Boolean enabled, String password) {
        User user = userDao.ReadById(id);
        model.addAttribute("user", user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUserPassword(password);

        return "editUser";
    }

    @PostMapping("editUser")
    public String submitEditUser(HttpServletRequest request, User user) {
        user = userDao.ReadById(user.getUserId());

        String firstName = request.getParameter("FirstNameInput");
        String lastName = request.getParameter("lastNameInput");
        String email = request.getParameter("emailInput");
        String userName = request.getParameter("userNameInput");
        String enabled = request.getParameter("enabledInput");
        String password = request.getParameter("passwordInput");

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUserName(userName);
        user.setUserPassword(encoder.encode(password));
        user.setUserId(user.getUserId());

        if (enabled.equals("true")) {

            user.setEnabled(true);
        } else {

            user.setEnabled(false);
        }

        userDao.Update(user);

        return "redirect:/admin";
    }

    @GetMapping("deletePost")
    public String deletePost(Integer id) {

        postDao.Delete(id);
        return "redirect:/admin";

    }

    @GetMapping("deleteHashTag")
    public String deletehashTag(Integer id) {

        hashTagDao.Delete(id);
        return "redirect:/admin";

    }
}
