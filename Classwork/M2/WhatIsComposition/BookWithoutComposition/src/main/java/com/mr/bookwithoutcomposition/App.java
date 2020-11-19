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
public class App {
    public static void main(String[] args) {
        Book book1 =new Book("Harry Potter", "2222", 500 , "english");
        System.out.println(book1);
        Book book2 = new Book ("True Crime", "3420", 10 , "spanish");
        
        System.out.println(book2.getPages());
    }
    
}

