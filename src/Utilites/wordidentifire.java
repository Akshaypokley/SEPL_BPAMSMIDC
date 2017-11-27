package Utilites;

import java.util.Scanner;

public class wordidentifire {

    public static void main(String args[])
    {


        String sentence = "Check this answer and you can find the keyword with this code";
        String search  = "keyord";

        if ( sentence.toLowerCase().indexOf(search.toLowerCase()) != -1 ) {

            System.out.println("I found the keyword");

        } else {

            System.out.println("not found");

        }



/*
        Scanner scn = new java.util.Scanner(System.in);
        String s = scn.nextLine();
        String[] lstarr = s.split(" ");
        if(s.contains("Aksha"))
        {
            System.out.println("Word is present");
        }else {
            System.out.println("word is not present");
        }*/
    }
}
