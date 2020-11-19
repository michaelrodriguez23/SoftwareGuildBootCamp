/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.blogMastery.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author michaelrodriguez
 */
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String userPassword;
    private List<Role> roles;
    private boolean enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.userId;
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.userName);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.userPassword);
        hash = 67 * hash + Objects.hashCode(this.roles);
        hash = 67 * hash + (this.enabled ? 1 : 0);
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.userPassword, other.userPassword)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", email=" + email + ", userPassword=" + userPassword + ", roles=" + roles + ", enabled=" + enabled + '}';
    }
    

}
