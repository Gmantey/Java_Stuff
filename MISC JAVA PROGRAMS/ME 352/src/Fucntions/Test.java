package Fucntions;

import java.io.IOException;
import java.text.DecimalFormat;

public class Test {

    public static void main(String[] args) throws IOException {

     Stresses stresses = new Stresses(0.5);
     Failure_Theories failure_theories = new Failure_Theories(41017.462,0,0,0,0,7451.269);
     failure_theories.deTheory(86000);



    }
}
