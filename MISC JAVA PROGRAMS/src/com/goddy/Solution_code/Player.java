package com.goddy.Solution_code;

public class Player {

    private String firstname;
    private String lastname;
    private String teams;
    private int nbaChampcount;
    private String position;

    public Player(String firstname, String lastname, String teams, int nbaChampcount, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.teams = teams;
        this.nbaChampcount = nbaChampcount;
        this.position = position;
    }

    // Getter and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public int getNbaChampcount() {
        return nbaChampcount;
    }

    public void setNbaChampcount(int nbaChampcount) {
        this.nbaChampcount = nbaChampcount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
