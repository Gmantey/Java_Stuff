package com.goddy.FinalExam;

import javax.swing.*;
import javax.tools.FileObject;
import java.io.File;
import java.net.Socket;
import java.util.ArrayList;

public class Test{

    public static void main(String[] args) {
        int a = 7;
        if (a++ == 7){
            System.out.println("seven");
        }

        Animal cat = Animal.CAT;

        System.out.println(cat == Animal.CAT && cat.equals(Animal.CAT));

       }


}
enum Animal{

    CAT,
    DOG
}
