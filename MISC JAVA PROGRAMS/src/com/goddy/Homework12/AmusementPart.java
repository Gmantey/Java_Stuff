package com.goddy.Homework12;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Homework 12 -- Amusement Park
 * <p>
 * This program allows the user to purchase amusement park tickets
 * The user will be able to select which amusement park,
 * type of ticket and class of ticket they want
 *
 * @author Godfred Mantey, L01
 * @version Monday, April 20
 */
public class AmusementPart {

    static ArrayList<String> userSelection = new ArrayList<>();

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome Screen", "Amusement Park", JOptionPane.INFORMATION_MESSAGE);
        String[] choices = {"Walt Disney World", "Universal Studios", "Beto Carrero World", "Cedar Point"};
        String decision = (String) JOptionPane.showInputDialog(null, "Choose Amusement Park", "Amusement Park",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (decision == null) {
            return;
        }
        int[] prices_list = priceList(decision);
        int current_price = 0;
        String message = null;
        do {
            Object[] options = {"Add New Ticket", "Check Order", "Checkout"};
            int dec = JOptionPane.showOptionDialog(null, "Main Menu", "Amusement Park: " + decision, JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, null);

            if (dec == 0) {
                String park = option_4();
                if (park.equals("Cancel")) {
                    message = "lol";
                    continue;
                } else {
                    String classype = option_5();
                    if (classype.equals("Cancel")) {
                        message = "lol";
                        continue;
                    } else {
                        switch (classype) {
                            case "Child":
                                current_price = price(prices_list, 0);
                                break;
                            case "Student":
                                current_price = price(prices_list, 1);
                                break;
                            case "Adult":
                                current_price = price(prices_list, 2);
                                break;
                            case "Senior":
                                current_price = price(prices_list, 3);
                        }
                        userSelection.add(park + " " + classype + " " + String.valueOf(current_price));
                        message = "lol";
                        continue;
                    }
                }

            } else if (dec == 1) {
                if (userSelection.size() > 0) {
                    JOptionPane.showMessageDialog(null, new JList(userSelection.toArray()),
                            "Check Order: " + decision, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tickets", "Check Order: "
                            + decision, JOptionPane.INFORMATION_MESSAGE);
                }
                message = "lol";
                continue;
            } else if (dec == 2) {
                if (userSelection.size() == 0) {
                    message = option_8_Warning();
                    continue;
                } else {
                    double price = priceCalc(userSelection) * 1.07; // 7 percent tax
                    int checkout = JOptionPane.showConfirmDialog(null, "Total Price: " + String.format("%.2f", price),
                            "Amusement Park: " + decision, JOptionPane.YES_NO_OPTION);
                    if (checkout == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Order Confirmed!\nTotal Price: " + String.format("%.2f", price) + "\nThank you!",
                                "Amusement Park: " + decision, JOptionPane.INFORMATION_MESSAGE);
                        message = null; // Ends the Do-Loop
                    } else {
                        message = "lol";
                        continue;
                    }
                }
            }

        } while (!(message == null));
    }

    public static String option_4() {

        String[] choices = {"Single-Park", "Multi-Park"};
        String decision = (String) JOptionPane.showInputDialog(null, "Ticket Type", "Amusement Park",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (decision == null) {
            return "Cancel";
        }
        return decision;
    }

    public static String option_5() {
        String[] choices = {"Adult", "Child", "Student", "Senior"};
        String decision = (String) JOptionPane.showInputDialog(null, "Ticket Class", "Amusement Park",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (decision == null) {
            return "Cancel";
        }
        return decision;
    }

    public static int price(int[] prices, int type) {
        return prices[type];
    }

    /*
    Returns the correct Price List
     */
    public static int[] priceList(String park) {

        int[] prices = new int[4];
        switch (park) {
            case "Walt Disney World":
                prices = new int[]{60, 95, 130, 95};
                break;
            case "Universal Studios":
                prices = new int[]{35, 110, 110, 80};
                break;
            case "Beto Carrero World":
                prices = new int[]{70, 100, 115, 70};
                break;
            case "Cedar Point":
                prices = new int[]{20, 40, 60, 30};
                break;
        }
        return prices;
    }

    public static String option_8_Warning() {
        int warning = JOptionPane.showConfirmDialog(null, "Warning: Are you sure you would like to quit?",
                "Amusement Park", JOptionPane.YES_NO_OPTION);
        if (warning == JOptionPane.YES_OPTION) {
            return null;
        } else {
            return "lol";
        }
    }

    public static double priceCalc(ArrayList<String> orders) {
        double price = 0;

        for (int i = 0; i < orders.size(); i++) {

            String[] line = orders.get(i).split(" ");

            if (line[0].equals("Multi-Park")) {
                price += (Double.parseDouble(line[2]) * 1.3);
            } else {
                price += Double.parseDouble(line[2]);
            }
        }
        return price;
    }
}
