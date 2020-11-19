/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author michaelrodriguez
 */
public class Post {

    private int postId;
    private String title;
    private boolean published;
    private LocalDate date;
    private String imgUrl;
    private String post;
    @DateTimeFormat(pattern = "MM-dd-yyyy-")
    private LocalDate timePosted;
    private LocalDate timeExpiration;
    private LocalDate timeScheduled;
    private boolean staticPageFlag;
    private List<HashTag> hashTags;
    private User user; 

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(LocalDate timePosted) {
        this.timePosted = timePosted;
    }

    public LocalDate getTimeExpiration() {
        return timeExpiration;
    }

    public void setTimeExpiration(LocalDate timeExpiration) {
        this.timeExpiration = timeExpiration;
    }

    public LocalDate getTimeScheduled() {
        return timeScheduled;
    }

    public void setTimeScheduled(LocalDate timeScheduled) {
        this.timeScheduled = timeScheduled;
    }

    public boolean isStaticPageFlag() {
        return staticPageFlag;
    }

    public void setStaticPageFlag(boolean staticPageFlag) {
        this.staticPageFlag = staticPageFlag;
    }

    public List<HashTag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<HashTag> hashTags) {
        this.hashTags = hashTags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.postId;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + (this.published ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.date);
        hash = 17 * hash + Objects.hashCode(this.imgUrl);
        hash = 17 * hash + Objects.hashCode(this.post);
        hash = 17 * hash + Objects.hashCode(this.timePosted);
        hash = 17 * hash + Objects.hashCode(this.timeExpiration);
        hash = 17 * hash + Objects.hashCode(this.timeScheduled);
        hash = 17 * hash + (this.staticPageFlag ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.hashTags);
        hash = 17 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (this.postId != other.postId) {
            return false;
        }
        if (this.published != other.published) {
            return false;
        }
        if (this.staticPageFlag != other.staticPageFlag) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.imgUrl, other.imgUrl)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.timePosted, other.timePosted)) {
            return false;
        }
        if (!Objects.equals(this.timeExpiration, other.timeExpiration)) {
            return false;
        }
        if (!Objects.equals(this.timeScheduled, other.timeScheduled)) {
            return false;
        }
        if (!Objects.equals(this.hashTags, other.hashTags)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", title=" + title + ", published=" + published + ", date=" + date + ", imgUrl=" + imgUrl + ", post=" + post + ", timePosted=" + timePosted + ", timeExpiration=" + timeExpiration + ", timeScheduled=" + timeScheduled + ", staticPageFlag=" + staticPageFlag + ", hashTags=" + hashTags + ", user=" + user + '}';
    }

 

}
