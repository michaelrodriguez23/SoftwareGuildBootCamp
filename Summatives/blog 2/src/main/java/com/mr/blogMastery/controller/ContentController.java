/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.controller;

import com.mr.blogMastery.dao.CommentDaoImpl;
import com.mr.blogMastery.dao.HashTagDaoImpl;
import com.mr.blogMastery.dao.PostDaoImpl;
import com.mr.blogMastery.dao.UserDaoImpl;
import com.mr.blogMastery.dto.Comment;
import com.mr.blogMastery.dto.HashTag;
import com.mr.blogMastery.dto.Post;
import com.mr.blogMastery.dto.User;
import static java.lang.Boolean.parseBoolean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.ConstraintViolation;
import org.springframework.ui.Model;

/**
 *
 * @author michaelrodriguez
 */
@Controller
public class ContentController {

    @Autowired
    PostDaoImpl postDao;

    @Autowired
    HashTagDaoImpl hashTagDao;

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    CommentDaoImpl commentDao;

    Set<ConstraintViolation<Post>> violations = new HashSet<>();

    @GetMapping("/getUsers")
    public String users(Model model) {
        List users = userDao.ReadAll();
        model.addAttribute("users", users);
        return "content";
    }

    @GetMapping("/content")
    public String displayHashTags(Model model) {
        List hashTags = hashTagDao.ReadAll();
        model.addAttribute("hashTags", hashTags);

        List<Post> posts = postDao.ReadAllPostUnpublished();
        model.addAttribute("posts", posts);

        List staticPostList = postDao.ReadAllPostStatic();
        model.addAttribute("staticPostList", staticPostList);

        List blogList = postDao.ReadAllPostForBlog();
        model.addAttribute("blogList", blogList);
        return "content";

    }

    @GetMapping("/ReDirectTag")
    public String redirectTag(HttpServletRequest request) {

        return "/addTag";
    }

    @PostMapping("/addHashTag")
    public String addHashTag(HttpServletRequest request) {

        String hashTagFromForm = request.getParameter("submitHashTag");

        HashTag hashTag = new HashTag();
        hashTag.setHashTag(hashTagFromForm);
        hashTagDao.Create(hashTag);

        return "redirect:/content";
    }

    @PostMapping("addComment")
    public String addComment(HttpServletRequest request) {

        String commentFromForm = request.getParameter("submitComment");
//        String userId = request.getParameter("userId");
//        int parsedUserId = Integer.parseInt(userId);
//        String postId = request.getParameter("postId");
//        int parsedPostId = Integer.parseInt(postId);
        Comment comment = new Comment();
        comment.setComment(commentFromForm);
       // comment.setUser(user);
//        comment.setPost(postDao.ReadById(parsedPostId));
        commentDao.Create(comment);

        return "redirect:/content";
    }

    @PostMapping("/addPost")
    public String addPost(HttpServletRequest request) {

        //  LocalDateTime now = LocalDateTime.now();
        // String dateStr = now.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a"));
        //  LocalDateTime dateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
        String[] hashTagIds = request.getParameterValues("hashTags");
        List<HashTag> hashTags = new ArrayList<>();
        for (String hashTagId : hashTagIds) {
            hashTags.add(hashTagDao.ReadById(Integer.parseInt(hashTagId)));
        }

        String title = request.getParameter("title");
        String blogPost = request.getParameter("txtArea");
        Boolean published = parseBoolean(request.getParameter("staticFlag"));
        Boolean postType = parseBoolean(request.getParameter("selectPostType"));

        String roleType = request.getParameter("selectRoleType");
        Post post = new Post();
        post.setTitle(title);
        post.setPost(blogPost);
        post.setPublished(published); // boolean
        post.setStaticPageFlag(postType); // boolean 

        post.setHashTags(hashTags);
        post.setImgUrl(request.getParameter("imageUrl"));

        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("d M/L y G  ");
        String text = dateNow.format(formmater);

        LocalDate parsedDate = LocalDate.parse(text, formmater);
        post.setDate(parsedDate);
        post.setTimePosted(parsedDate);
        post.setTimeExpiration(LocalDateTime.now().toLocalDate());
        post.setTimeScheduled(LocalDateTime.now().toLocalDate());

        User user = new User();
        if (roleType.equals("admin")) {

            user.setUserId(1);
        } else {

            user.setUserId(2);
        }

        post.setUser(user);

        postDao.Create(post);

        return "redirect:/home";
    }

    @GetMapping("editPost")
    public String editPost(Integer id, Model model) {
        Post post = postDao.ReadById(id);
        model.addAttribute("post", post);

        List hashTags = hashTagDao.ReadAll();
        model.addAttribute("hashTags", hashTags);
        model.addAttribute("errors", violations);
        return "editPost";
    }

    @PostMapping("editPost")
    public String performEditPost(HttpServletRequest request) {
        int postId = Integer.parseInt(request.getParameter("postId"));
        Post post = postDao.ReadById(postId);

        String[] hashTagIds = request.getParameterValues("hashTags");
        List<HashTag> hashTags = new ArrayList<>();
        for (String hashTagId : hashTagIds) {
            hashTags.add(hashTagDao.ReadById(Integer.parseInt(hashTagId)));
        }
        post.setHashTags(hashTags);
        String title = request.getParameter("title");
        String blogPost = request.getParameter("txtArea");
        Boolean published = parseBoolean(request.getParameter("staticFlag"));
        Boolean postType = parseBoolean(request.getParameter("selectPostType"));

        String roleType = request.getParameter("selectRoleType");

        post.setTitle(title);
        post.setPost(blogPost);
        post.setPublished(published); // boolean
        post.setStaticPageFlag(postType); // boolean 

        post.setImgUrl(request.getParameter("imageUrl"));

        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("d M/L y G ");
        String text = dateNow.format(formmater);
        LocalDate parsedDate = LocalDate.parse(text, formmater);
        post.setDate(parsedDate);
        post.setTimePosted(parsedDate);
        post.setTimeExpiration(LocalDateTime.now().toLocalDate());
        post.setTimeScheduled(LocalDateTime.now().toLocalDate());

        User user = new User();
        if (roleType.equals("admin")) {

            user.setUserId(1);
        } else {

            user.setUserId(2);
        }

        post.setUser(user);

        postDao.Update(post);

        return "redirect:/admin";

    }

}
