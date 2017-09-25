import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * Created by akshay.pokley on 9/25/2017.
 */
public class ScriptPatten {

    int j;

    public static void main(String args[]) {
        int i;

        Scanner sa = new Scanner(System.in);
        System.out.println("Please enter switch No i" + "=");
        i = sa.nextInt();

        switch (i) {

            case 0:
                System.out.println("its a Zero ");

                switch (i) {

                    case 0:
                        System.out.println("Its o ");
                        break;
                }
                    break;
            case 1:
                System.out.println("its a one ");

                switch (i) {

                    case 0:
                        System.out.println("Its 0");
                        break;
                    case 1:
                        System.out.println("its a A");
                        break;


                }
                break;
            case 2:
                System.out.println("its a two ");

                switch (i) {
                    case 0:
                        System.out.println("Its 0");
                        break;
                    case 2:
                        System.out.println("its a B");
                }


        }

    }

}