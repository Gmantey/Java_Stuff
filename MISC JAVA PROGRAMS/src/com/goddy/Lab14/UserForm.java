package com.goddy.Lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm {
    public static void main(String[] args) {
        // create a Jframe with title
        JFrame frame = new JFrame();
        frame.setTitle("Lab 14: UserForm");
        // Panel to define layout
        JPanel panel = new JPanel(new GridBagLayout());
        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();

        // Set the initial grid values to 0,0
        constr.gridx = 0;
        constr.gridy = 0;

        JLabel nameLabel = new JLabel("Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel phoneLabel = new JLabel("Phone");

        // Hidden Labels
        JLabel nameHidden = new JLabel();
        JLabel emailHidden = new JLabel();
        JLabel phoneHidden = new JLabel();

        // Set Visibility of hidden to False
        nameHidden.setVisible(false);
        emailHidden.setVisible(false);
        phoneHidden.setVisible(false);

        // Set the Labels in place
        panel.add(nameLabel, constr);
        constr.gridy = 1;
        panel.add(emailLabel, constr);
        constr.gridy = 2;
        panel.add(phoneLabel, constr);
        // Making Edit button
        JButton button = new JButton("Edit");
        constr.gridy = 3;
        panel.add(button, constr);

        JTextField nameTxt = new JTextField(20);
        JTextField emailTxt = new JTextField(20);
        JTextField phoneTxt = new JTextField(20);


        constr.gridx = 1;
        constr.gridy = 0;

        // Set the Txt and hidden labels in place
        panel.add(nameTxt , constr);
        panel.add(nameHidden,constr);
        constr.gridy = 1;
        panel.add(emailTxt , constr);
        panel.add(emailHidden,constr);
        constr.gridy = 2;
        panel.add(phoneTxt , constr);
        panel.add(phoneHidden,constr);
        // Making a button
        JButton button2 = new JButton("Save");
        constr.gridy = 3;
        panel.add(button2, constr);

        //Add the panel to the frame
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // add a listener button for both buttons
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTxt.setVisible(false);
                emailTxt.setVisible(false);
                phoneTxt.setVisible(false);

                nameHidden.setText(nameTxt.getText());
                emailHidden.setText(emailTxt.getText());
                phoneHidden.setText(phoneTxt.getText());

                nameHidden.setVisible(true);
                emailHidden.setVisible(true);
                phoneHidden.setVisible(true);
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nameTxt.setVisible(true);
                emailTxt.setVisible(true);
                phoneTxt.setVisible(true);

                nameHidden.setVisible(false);
                emailHidden.setVisible(false);
                phoneHidden.setVisible(false);
            }
        });
    }
}
