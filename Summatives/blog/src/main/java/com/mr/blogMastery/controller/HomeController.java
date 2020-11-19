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
import com.mr.blogMastery.dto.HashTag;
import com.mr.blogMastery.dto.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author michaelrodriguez
 */
@Controller
public class HomeController {

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

    @GetMapping({"/", "/home",})
    public String displayHomePage(Model model) {
        List<Post> posts = postDao.ReadAllPostForBlog();
        model.addAttribute("posts", posts);
        model.addAttribute("home");

        List<HashTag> hashTagList = hashTagDao.ReadAll();
        model.addAttribute("hashTagList", hashTagList);

        List staticPostList = postDao.ReadAllPostStatic();
        model.addAttribute("staticPostList", staticPostList);
        
        List blogList = postDao.ReadAllPostForBlog();
        model.addAttribute("blogList", blogList);
        
       List lastPosts = postDao.ReadLastPost();
       model.addAttribute("lastPosts", lastPosts);
       
       List TwoRandomPosts = postDao.ReadTwoRandomPost();
       model.addAttribute("TwoRandomPosts", TwoRandomPosts);

        return "home";
    }

    @GetMapping("postDetails")
    public String postDetail(Integer id, Model model) {
        Post post = postDao.ReadById(id);
        model.addAttribute("post", post);

        List hashTagsWithPostId = hashTagDao.ReadAllHashTagsByPostId(id);
        model.addAttribute("hashTagsByPostId", hashTagsWithPostId);
        return "postDetails";
    }

    @GetMapping("hashTagDetails")
    public String hashTagDetail(Integer id, Model model) {
        HashTag hashTag = hashTagDao.ReadById(id);
        model.addAttribute("hashTag", hashTag);

        List postsByHashTagId = postDao.ReadAllPostByHashTag(id);
        model.addAttribute("postsByHashTagId", postsByHashTagId);

        List hashTagsByHashTagId = hashTagDao.ReadAllByHashTagId(id);
        model.addAttribute("hashTagsByHashTagId", hashTagsByHashTagId);

        return "hashTagDetails";
    }

}
