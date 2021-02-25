package com.goddy.Lab15;

public class Test {

    public static void main(String[] args) {
        /* Start with the empty list */
        MyLinkedList llist = new MyLinkedList();

        llist.addNode(7);
        llist.addNode(1);
        llist.addNode(3);
        llist.addNode(2);
        llist.addNode(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNode(3);  // Delete node at position 4

        System.out.println("\nLinked List after Deletion: ");
        llist.printList();
    }
}




