package com.goddy.homework13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AddController
 * <p>
 * Homework 13 -- Message Board
 *
 * @author Godfred Mantey, L01
 * @version April 27, 2020
 */
public final class AddController {

    private TwitterModel twitterModel;
    private AddTweet addTweet;

    /**
     * Implement the AddController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param addTweet     AddTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public AddController(TwitterModel twitterModel, AddTweet addTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.addTweet = addTweet;

        if (twitterModel == null || addTweet == null) {
            throw new IllegalArgumentException();
        }
        addTweet.getTweetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAddButtonSemantics();
            }
        });
    }

    /**
     * A method used to verify if a given string is strictly containing numeric values.
     *
     * @param aString A string to verify
     * @return boolean
     */
    public static boolean isNumeric(String aString) {
        if (aString == null) {
            return false;
        } else if (aString.isEmpty()) {
            return false;
        } else if (aString.indexOf(".") != aString.lastIndexOf(".")) {
            return false;
        } else {
            int counter = 0;
            for (char c : aString.toCharArray()) {
                if (Character.isDigit(c)) {
                    counter++;
                }
            }
            return counter == aString.length();
        }
    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getAddButtonSemantics() {

        if (isNumeric(addTweet.getidTextField().getText())) {
            if (Double.parseDouble(addTweet.getidTextField().getText()) > 0) {
                Tweet tweet = new Tweet(addTweet.getidTextField().getText(), addTweet.getBodyTextField().getText());
                twitterModel.add(tweet);
            }
            Tweet tweet = new Tweet(addTweet.getidTextField().getText(), addTweet.getBodyTextField().getText());
            twitterModel.add(tweet);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The specified ID is not valid number!"
                    , "Add a Tweet",
                    JOptionPane.ERROR_MESSAGE);
            addTweet.getidTextField().requestFocus();
        }
    }
    /**
     * A method to control specific GUI component actions.
     */
    public void getClearButtonSemantics() {
        // Need more stuff
        addTweet.getidTextField().setText("");
        addTweet.getidTextField().requestFocus();
    }
}
