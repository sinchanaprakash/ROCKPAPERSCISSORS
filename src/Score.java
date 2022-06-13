import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Score {
    private int gamesWonByUser;
    private int totalNumberGames;
    public static int scoreOfUser;
    public static int highScore;

    public void incrementGamesWonByUser() {
        gamesWonByUser++;
    }

    public void incrementTotalNumberGames() {
        totalNumberGames++;
    }

    public void calculateScoreOfUser() {
        scoreOfUser += 10;
    }
    public void calculateHighScore() {
        if (scoreOfUser >= highScore) {
            highScore = scoreOfUser;
        }
    }
    public int totalNumberOfGames() {
        return totalNumberGames;
    }

    public int getGamesWonByUser() {
        return gamesWonByUser;
    }

    public int getScoreOfUser() {
        return scoreOfUser;
    }
    public int getHighScore() {
        return highScore;
    }
    
   /*public int getHighScore(){
       if (scoreOfUser > highScore) {
           highScore=scoreOfUser;
       }
       return highScore;
   }*/
}




