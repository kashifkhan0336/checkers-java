/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;

import pieces.Team;

/**
 *
 * @author fawad
 */
public class Player {
    private int score = 0;
    private final String name;
    private final Team team;

    public Player(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    
    public void increaseScore(int num) {
        this.score += num;
    }

    public Team getTeam() {
        return team;
    }
    
}
