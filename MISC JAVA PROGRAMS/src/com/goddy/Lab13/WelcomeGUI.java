package com.goddy.Lab13;

import javax.swing.*;

public class WelcomeGUI {

    public static void main(String[] args) {

        String [] test = {"hello"};
        //JOptionPane.showMessageDialog(null, new JList(test), "Welcome", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Welcome to Lab 13!" , "Welcome", JOptionPane.INFORMATION_MESSAGE);
        String name = JOptionPane.showInputDialog(null, "What is your name?", "Survey",
                JOptionPane.QUESTION_MESSAGE);
        String Age = JOptionPane.showInputDialog(null, "How old are you?", "Survey",
                JOptionPane.QUESTION_MESSAGE);
        String occupation = JOptionPane.showInputDialog(null, "Occupation?", "Survey",
                JOptionPane.QUESTION_MESSAGE);


        int reply = JOptionPane.showConfirmDialog(null, "Would you like to exit?", "Exit",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! There's no more panels.", "Exit",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
