/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author michaelrodriguez
 */
public class Comment {

    private int commentId;
    private User user;
    private Post post;
    private LocalDate commentDate;
    private String comment;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.commentId;
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.post);
        hash = 97 * hash + Objects.hashCode(this.commentDate);
        hash = 97 * hash + Objects.hashCode(this.comment);
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
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.commentDate, other.commentDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", user=" + user + ", post=" + post + ", commentDate=" + commentDate + ", comment=" + comment + '}';
    }
    
    

}
