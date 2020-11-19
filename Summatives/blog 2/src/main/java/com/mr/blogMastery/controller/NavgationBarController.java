/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.controller;

import com.mr.blogMastery.dao.HashTagDaoImpl;
import com.mr.blogMastery.dao.PostDaoImpl;
import com.mr.blogMastery.dao.UserDaoImpl;
import com.mr.blogMastery.dto.Post;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author michaelrodriguez
 */
public class NavgationBarController {

    @Autowired
    PostDaoImpl postDao;

    @Autowired
    HashTagDaoImpl hashTagDao;

    @Autowired
    UserDaoImpl userDao;

    Set<ConstraintViolation<Post>> violations = new HashSet<>();
    
    
   @GetMapping({"/staticPosts"})
    public Model staticPost(Model model) {
        List staticPostList = postDao.ReadAllPostStatic();
        model.addAttribute("staticPostList", staticPostList);
        return model;
        
    } 
     @GetMapping({"/blogPosts"})
    public Model postForBlog(Model model) {
        List blogList = postDao.ReadAllPostForBlog();
        model.addAttribute("blogList", blogList);
        return model;
        
    } 
}
