package com.goddy.homework13;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;


/**
 * DeleteController
 *
 * Homework 13 -- Message Board
 *
 * @author Godfred Mantey, L01
 * @version April 27, 2020
 *
 */
public final class DeleteController {

    private TwitterModel twitterModel;
    private DeleteTweet deleteTweet;

    /** Implement the DeleteController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param deleteTweet DeleteTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public DeleteController(TwitterModel twitterModel, DeleteTweet deleteTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.deleteTweet = deleteTweet;

        if (twitterModel == null || deleteTweet == null) {
            throw new IllegalArgumentException();
        }
        deleteTweet.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDeleteButtonSemantics();
            }
        });

    }

    /** A method to control specific GUI component actions. */
    private void getDeleteButtonSemantics() {
        Tweet tweet = new Tweet();
        for (int i = 0; i < twitterModel.getTweetList().size(); i++) {
            tweet = (Tweet) twitterModel.getTweetList().get(i);
            if (tweet.getID().equals(deleteTweet.getidTextField().getText())) {
                twitterModel.remove(tweet);
                JOptionPane.showMessageDialog(null,
                        "Success: Tweet Deleted!"
                        , "Delete a Tweet",
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
    }

    /** A method to control specific GUI component actions. */
    private void getClearButtonSemantics() {
        deleteTweet.getidTextField().setText("");
        deleteTweet.getidTextField().requestFocus();
    }
}
