package com.goddy.Project3;

import java.util.ArrayList;

/**
 * Project 3 - Patron
 * <p>
 * This Patron Class stores information about Patrons and their
 * current loans. The bookLoanList stores a list of book ids
 * associated with each patron checkout
 *
 * @author Godfred Mantey, LO1
 * @version March 28, 2020
 */
public class Patron {

    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private ArrayList<Integer> bookLoanList = new ArrayList<>();

    public Patron(int id, String name, String address, String email,
                  String phoneNumber, ArrayList<Integer> bookLoanList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookLoanList = bookLoanList;
    }

    public void updateBookLoanList(int bookId) {

        for (int i = 0; i < bookLoanList.size(); i++) {
            if (bookLoanList.get(i) == bookId) {
                bookLoanList.remove(bookLoanList.get(i));
                return;
            }
        }
        bookLoanList.add(bookId);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Integer> getBookLoanList() {
        return bookLoanList;
    }

    public void setBookLoanList(ArrayList<Integer> bookLoanList) {
        this.bookLoanList = bookLoanList;
    }
}
