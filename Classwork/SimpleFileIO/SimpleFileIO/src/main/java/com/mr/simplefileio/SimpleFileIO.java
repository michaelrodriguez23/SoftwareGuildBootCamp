/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class SimpleFileIO {
    
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("outFile.txt") );
        
        out.println("this is a line in my file...");
        out.println("this is the second line in my file..");
        out.println("this is the third line in my file... ");
        out.flush();
        out.close();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
        // while there is next line is true, it will put the contents
        // of the line into currentLine
        while(sc.hasNextLine()){
        String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
        System.out.println("Thats all the content in the file. ");
    }
}
