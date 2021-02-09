package com.tesfai.java8;

import java.util.Optional;

public class Java8Optional {
	public static void main(String[] args) {   
        String[] str = new String[10]; 
        str[5]="java";
        Optional<String> checkNull = Optional.ofNullable(str[5]);   
        if (checkNull.isPresent()) {   
            String word = str[5].toUpperCase();   
            System.out.print(word);   
         } 
        else 
           System.out.println("string is null");   
    } 
}
