
package com.goddy.homework13;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * EditController
 * <p>
 * Homework 13 -- Message Board
 *
 * @author Godfred Mantey, L01
 * @version April 27, 2020
 */
public final class EditController {

    private TwitterModel twitterModel;
    private EditTweet editTweet;

    /**
     * Implement the AddController constructor per the instructions in the handout
     *
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param editTweet    EditTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public EditController(TwitterModel twitterModel, EditTweet editTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.editTweet = editTweet;
        if (twitterModel == null || editTweet == null) {
            throw new IllegalArgumentException();
        }
        editTweet.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEditButtonSemantics();
            }
        });

    }

    /**
     * A method used to update a specific Tweet's body string.
     *
     * @param aTweet Tweet object containing an ID and body String
     * @param body   String
     */
    private void updateBody(Tweet aTweet, String body) {
        if (body.equals("")) {
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message body is empty. Maybe you should instead delete it?",
                    "Message Board",
                    JOptionPane.ERROR_MESSAGE);
            this.editTweet.getBodyTextField().requestFocus();
        } else {
            aTweet.setBody(body);
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message was properly updated!",
                    "Message Board",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getEditButtonSemantics() {

        Tweet tweet = new Tweet();

        for (int i = 0; i < twitterModel.getTweetList().size(); i++) {
            tweet = (Tweet) twitterModel.getTweetList().get(i);
            if (tweet.getID().equals(editTweet.getidTextField().getText())) {
                tweet.setBody(editTweet.getBodyTextField().getText());
                JOptionPane.showMessageDialog(null,
                        "Success: Tweet Edited!"
                        , "Edit a Tweet",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                        "A message with the given ID does not exist!"
                        , "Edit a Tweet",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        updateBody(tweet, tweet.getBody());
    }

    /**
     * A method to control specific GUI component actions.
     */
    private void getClearButtonSemantics() {
        // Need more stuff
        editTweet.getidTextField().setText("");
        editTweet.getidTextField().requestFocus();
    }

}
