package com.goddy.Lab15;

import java.util.NoSuchElementException;

/**
 * A simple singly-linked LinkedList class
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- LB15</p>
 */

public class MyLinkedList {

    //TO DO: Add MyLinkedList data member head
    private Node head;

    /**
     * Simple Node class, represents a Node
     * contained within a MyLinkedList instance
     */
    private class Node {

        int data;
        Node link;

        /**
         * Constructor for Node
         *
         * @param data Integer data associated with the Node
         */
        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    /**
     * Default constructor for MyLinkedList class
     */
    public MyLinkedList() {
    }

    public MyLinkedList(Node head) {
        this.head = null;
    }

    /**
     * A method to create and insert a node at the end of the list
     *
     * @param data Integer data associated with the new Node
     */
    public void addNode(int data) {
        Node newEntry = new Node(data);

        if (head == null) {
            head = newEntry;
            return;
        }
        Node current = head;

        while (current.link != null) {
            current = current.link;
        }
        current.link = newEntry;
    }


    /**
     * A method to delete the first occurrence of a Node whose data matches value.
     *
     * @param value Integer value associated with the Node to be deleted.
     * @throws NoSuchElementException if the specified value is not in the list.
     */
    public void deleteNode(int value) throws NoSuchElementException {

        if (head.data == value) {
            head = head.link;
            return;
        }

        Node current = head;
        Node next = current.link;


        while (next.data != value) {
            current = next;
            next = next.link;

            if (next == null) {
                throw new NoSuchElementException();
            }

        }
        current.link = next.link;

    }

    /**
     * A helper function to print out an
     * instance of MyLinkedList to help
     * visualize the list and assist with debugging
     */
    public void printList() {
        Node current = this.head;
        System.out.println("-----");
        while (current != null) {
            if (current.link != null) {
                System.out.print(current.data + "->");
            } else {
                System.out.println(current.data + "->X");
            }
            current = current.link;
        }
        System.out.println("-----");
    }
}
