package com.goddy.Homework.HW1;

import java.util.Scanner;
/**
 * Selection
 *
 * Create a sequential structure that can be used by a user to
 * identify different kinds of trees
 *
 * @author Godfred Mantey, L01
 * @version February 8, 2020
 *
 */
public class Selection {

    static final String QUESTION1 = "Does your tree have compound leaves?";
    static final String QUESTION2 = "Does your tree have 7 or fewer leaflets?";
    static final String QUESTION3 = "Are the leaflets rounded?";
    static final String QUESTION4 = "Is the leaf 6-8 inches long?";
    static final String QUESTION5 = "Are the leaves lobed?";
    static final String QUESTION6 = "Is the bark papery?";
    static final String QUESTION7 = "Are the leaf petioles flat?";
    static final String QUESTION8 = "Are the leaves triangular?";
    static final String QUESTION9 = "Is the leaf width equal to the length?";
    static final String QUESTION10 = "Are the leaves finely toothed?";
    static final String QUESTION11 = "Is the leaf at least 3 times longer than the width?";
    static final String QUESTION12 = "Are the leaf veins thin?";
    static final String QUESTION13 = "Is the bark dark?";
    static final String QUESTION14 = "Are the leaves shiny";
    static final String QUESTION15 = "Is the leaf base even?";
    static final String ERROR = "There was an error!";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yes = "y";
        String no = "n";
        String response;
        String answer = "";  // Initialie answer

        System.out.println("Let's see what kind of tree you have!");
        System.out.println("--------------------------------------");
        System.out.println(QUESTION1);
        response = scan.nextLine();

        /* add your code below */
        if (response.equals(yes)) {
            System.out.println(QUESTION2);
            response = scan.nextLine();
            if (response.equals(yes)) {
                answer = "Shagbark Hickory!";
            } else if (response.equals(no)) {
                System.out.println(QUESTION3);
                response = scan.nextLine();
                if (response.equals(yes)) {
                    answer = "Black Locust!";
                } else if (response.equals(no)) {
                    System.out.println(QUESTION4);
                    response = scan.nextLine();
                    if (response.equals(yes)) {
                        answer = "Mountain Ash!";
                    } else if (response.equals(no)) {
                        answer = "Black Walnut!";
                    }
                }
            }
        } else if ((response.equals(no))) {
            System.out.println(QUESTION5);
            response = scan.nextLine();
            if (response.equals(yes)) {
                answer = "Oak!";
            } else if (response.equals(no)) {
                System.out.println(QUESTION6);
                response = scan.nextLine();
                if (response.equals(yes)) {
                    answer = "Birch!";
                } else if (response.equals(no)) {
                    System.out.println(QUESTION7);
                    response = scan.nextLine();
                    if (response.equals(yes)) {
                        System.out.println(QUESTION8);
                        response = scan.nextLine();
                        if (response.equals(yes)) {
                            answer = "Eastern Cottonwood!";
                        } else if (response.equals(no)) {
                            answer = "Aspen!";
                        }
                    } else if (response.equals(no)) {
                        System.out.println(QUESTION9);
                        response = scan.nextLine();
                        if (response.equals(yes)) {
                            System.out.println(QUESTION10);
                            response = scan.nextLine();
                            if (response.equals(yes)) {
                                answer = "Balsam Poplar!";
                            } else if (response.equals(no)) {
                                answer = "Basswood!";
                            }
                        } else if (response.equals(no)) {
                            System.out.println(QUESTION11);
                            response = scan.nextLine();
                            if (response.equals(yes)) {
                                answer = "Willow!";
                            } else if (response.equals(no)) {
                                System.out.println(QUESTION12);
                                response = scan.nextLine();
                                if (response.equals(yes)) {
                                    System.out.println(QUESTION13);
                                    response = scan.nextLine();
                                    if (response.equals(yes)) {
                                        answer = "Black Cherry!";
                                    } else if (response.equals(no)) {
                                        answer = "Hackberry!";
                                    }
                                } else if (response.equals(no)) {
                                    System.out.println(QUESTION14);
                                    response = scan.nextLine();
                                    if (response.equals(yes)) {
                                        answer = "Beech!";
                                    } else if (response.equals(no)) {
                                        System.out.println(QUESTION15);
                                        response = scan.nextLine();
                                        if (response.equals(yes)) {
                                            answer = "Ironwood!";
                                        } else if (response.equals(no)) {
                                            answer = "Elm!";
                                        }
                                    }
                                }

                            }

                        }

                    }

                }

            }
        }
        if (response.equals(yes) || response.equals(no)) {
            System.out.println("Your tree: " + answer);
        } else System.out.println(ERROR);
    }
}





