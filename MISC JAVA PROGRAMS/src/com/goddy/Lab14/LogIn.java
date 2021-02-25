package com.goddy.Lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    public static void main(String[] args) {
        // create a Jframe with title
        JFrame frame = new JFrame();
        frame.setTitle("GUI Walkthrough");
        // Panel to define layout
        JPanel panel = new JPanel(new GridBagLayout());
        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();

        // Set the initial grid values to 0,0
        constr.gridx = 0;
        constr.gridy = 0;

        JLabel userNameLabel = new JLabel("Enter your username: ");
        JLabel hidden1 = new JLabel();
        panel.add(userNameLabel, constr);

        // Change grid position before adding text
        JTextField userNameTxt = new JTextField(20);
        constr.gridx = 1;
        panel.add(userNameTxt , constr);
        panel.add(hidden1,constr); // adding the hidden panel to the location
        hidden1.setVisible(false);

        // Create a password field
        JLabel pwdLabel = new JLabel("Enter your password :");
        JPasswordField pwdTxt = new JPasswordField(20);
        constr.gridx = 0;
        constr.gridy = 1;
        panel.add(pwdLabel, constr);
        constr.gridx = 1;
        panel.add(pwdTxt,constr);

        // Making a button
        JButton button = new JButton("Sign In");
        constr.gridy = 5;
        panel.add(button, constr);

        //Add the panel to the frame
        frame.add(panel);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // add a listener button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userNameTxt.setVisible(false);
                hidden1.setText(userNameTxt.getText());
                hidden1.setVisible(true);
            }
        });
    }
}
