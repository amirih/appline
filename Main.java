/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinusee.applinebuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        System.out.println("Start :");
        PrintWriter writer = new PrintWriter("Application-Timeline.txt", "UTF-8");
        String temp=" ";
        
    do{      
        Process proc = Runtime.getRuntime().exec("xdotool getactivewindow getwindowname");
        java.io.InputStream is = proc.getInputStream();
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String val = "";
        if (s.hasNext()) {
            val = s.next();
        }
        else {
            val = "";
        }
       
        if(!temp.equalsIgnoreCase(val)){
        
            writer.println(val + " \n");
            writer.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd---->HH:mm:ss")));
            
            System.out.print(val +" " + "at:");
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd---->HH:mm:ss")));
            } 
        temp=val;
        TimeUnit.SECONDS.sleep(20);


    }while(true);
    }
    
}
