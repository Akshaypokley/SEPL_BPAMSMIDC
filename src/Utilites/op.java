package Utilites;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by akshay.pokley on 6/23/2017.
 */
public class op {
    public static void main(String[] args)
    {
    final String input = "dsfsdf89o9";
    final String gh = "d443";
        final String Email = "A@g.com";
        final String Flotw = "23.67";

        final Pattern Flot = Pattern.compile("^[+-]?([0-9]*[.])?[0-9]++$");

    /*final Pattern pattern = Pattern.compile("^[A-Za-z,0-9 ]++$");

    final  Pattern pattern2 = Pattern.compile("^[0-9]++$");

    final  Pattern Email2 = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
*/
      /*  if (!Email2.matcher(Email).matches()) {
            System.out.println("Invalid Email");
        }else {
            System.out.println("valid Email");
        }

    if (!pattern2.matcher(gh).matches()) {
            System.out.println("Invalid Integer");
        }else {
            System.out.println("valid Integer");
        }
    if (!pattern.matcher(input).matches()) {
        System.out.println("Invalid string");
    }else {
        System.out.println("valid String");
    }
*/
        if (!Flot.matcher(Flotw).matches()) {
            System.out.println("Invalid Flot Nm");
        }else {
            System.out.println("valid Flot Nm");
        }
}
}
