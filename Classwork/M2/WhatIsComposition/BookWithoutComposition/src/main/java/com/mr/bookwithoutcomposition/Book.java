/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.bookwithoutcomposition;

/**
 *
 * @author michaelrodriguez
 */
public class Book {
    private String title;
    private String isbn;
    int pages;
    String language; 
    private Author[] authors; 
    private Publisher publisher; 
    
    public Book(String title, String isbn, int pages, String language){
    this.title = title; 
    this.isbn = isbn; 
    this.pages = pages; 
    this.language = language;
    
    
    
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
