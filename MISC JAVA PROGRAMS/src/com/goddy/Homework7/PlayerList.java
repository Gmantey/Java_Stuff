package com.goddy.Homework7;

import java.util.ArrayList;

/**
 * Homework 7 - PlayerList
 *
 * Finds the correct player for each position
 *
 * @author Godfred Mantey, LO1
 * @version March 9, 2020
 *
 */
public class PlayerList {
    private ArrayList<Player> players;

    //Constructor
    public PlayerList(ArrayList<Player> players) {
        this.players = players;
    }
    public void addPlayer (Player newPlayer) {
    }

    // Method for finding PG
    public Player findPG() {
        int criteria1 = 0;
        boolean criteria2 =  false;
        int defence = 0;
        Player answer = null;

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getPosition().equals("PG")) {
                answer = players.get(i);
                criteria1 = players.get(i).getShooting() + players.get(i).getPassing() + players.get(i).getLayup();

            }
            for (int j = 0; j <  players.get(i).getSkills().size(); j++) {
                if (players.get(i).checkSkill("Point Phenom")){
                    criteria2 = true;
                }
            }
            if (criteria1 > 280 && criteria2 && players.get(i).getDefense() > defence) {
                answer = players.get(i);
                defence = players.get(i).getDefense();
            }

        }
        return answer;
    }

    // Method for finding SG
    public Player findSG() {
        boolean criteria1 =  false;
        int sum = 0;
        int newsum = 0;
        int first = 0;
        int index = 0;

        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getPosition().equals("SG")) {
                first = i;
                for (int j = 0; j < players.get(i).getSkills().size(); j++) {
                    if (players.get(i).getSkills().get(j).equals("GOAT")) {
                        return players.get(i);
                    }
                }
                newsum = players.get(i).getShooting() +
                        players.get(i).getPassing() + players.get(i).getLayup()
                        + players.get(i).getDefense() + players.get(i).getAthletics();
                if (newsum > sum) {
                    sum = newsum;
                    index = i;
                }
            }
        }
        if (index != 0){
            return players.get(index);
        }
        return players.get(first);
    }
    // Method for finding SF
    public Player findSF() {
        boolean criteria1 =  false;
        int sum = 0;
        int first = 0;
        int index = 0;


        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equals("SF")) {
                first = i;
                for (int j = 0; j < players.get(i).getSkills().size(); j++) {
                    if (players.get(i).getSkills().get(j).equals("The King") ||
                            players.get(i).getSkills().get(j).equals("Floor General")
                                    && players.get(i).getTotalAttribute() > sum) {
                        index = i;
                        sum = players.get(i).getTotalAttribute();
                    }
                }
            }

        }
        if (index != 0){
            return players.get(index);
        }
        return players.get(first);
    }
    // Method for finding PF
    public Player findPF() {
        int sum = 0;
        int newsum = 0;
        int index = 0;
        int first = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equals("PF")) {
                first = i;
                if (players.get(i).getShooting() > 80 || players.get(i).getLayup() > 95) {
                    newsum = players.get(i).getDefense() + players.get(i).getRebound() + players.get(i).getAthletics();
                    if (newsum > sum) {
                        sum = newsum;
                        index = i;
                    }
                }
            }
        }
        if (index != 0){
            return players.get(index);
        }
        return players.get(first);
    }
    // Method for finding C
    public Player findC() {
        int sum = 0;
        int newsum = 0;
        int index = 0;
        int first = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equals("C")) {
                first = i;
                for (int j = 0; j < players.get(i).getSkills().size(); j++) {
                    if (players.get(i).getSkills().get(j).equals("Paint Dominator")){
                        newsum = players.get(i).getShooting() +
                                players.get(i).getRebound() + players.get(i).getLayup()
                                + players.get(i).getDefense() + players.get(i).getAthletics();
                        if (newsum > sum) {
                            sum = newsum;
                            index = i;
                        }
                    }
                }
            }
        }
        if (index != 0){
            return players.get(index);
        }
        return players.get(first);
    }
    // Getters and Setters
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
