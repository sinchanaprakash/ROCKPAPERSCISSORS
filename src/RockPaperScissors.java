import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


interface Controller {
    String welcome();
    String enterOption();
    void selectUserChoice(Options userOption);
    Options randomMachineChoice();
    Player calculateResult();
    Score getResults();
}

class RockPaperScissorsGameController implements Controller {

    private Options userChoice = Options.EMPTY;
    private Options machineChoice = Options.EMPTY;
    private Score totalScore = new Score();

    @Override
    public String welcome() {

        return "     Welcome to Rock Paper Scissors Game    \n"+
                "                               \n";
    }

    @Override
    public String enterOption(){
        return  "         Choose                \n"+
                "         1. ROCK               \n"+
                "         2. PAPER              \n"+
                "         3. SCISSOR            \n"+
                "                               \n";
    }

    @Override
    public void selectUserChoice(Options userOption) {
        this.userChoice = userOption;
    }

    @Override
    public Options randomMachineChoice() {
        int randomNumberBetween1to3 = new Random().nextInt(3)+1;
        Options machineOption = Options.valueOf(randomNumberBetween1to3);
        this.machineChoice = machineOption;
        return machineOption;
    }

    @Override
    public Player calculateResult() {

        totalScore.incrementTotalNumberGames();

        if(machineChoice.equals(userChoice)){
            return Player.TIE;
        }
        if(machineChoice.isWinBy(userChoice)){
            totalScore.incrementGamesWonByUser();
            totalScore.calculateScoreOfUser();
            totalScore.calculateHighScore();
            return Player.USER;
        }
        return Player.MACHINE;
    }

    @Override
    public Score getResults() {
        return totalScore;
    }
}

public class RockPaperScissors {

    public static void main(String[] args) throws IOException {
            File path = new File("C:\\Rockpaperscissors\\aaa.txt");
            FileWriter wr = new FileWriter(path);
            wr.write(Integer.toString(Score.highScore));
           // wr.write("hello");
            wr.flush();
            wr.close();

        Controller gameController = new RockPaperScissorsGameController();

        Scanner scanner = new Scanner(System.in);
        System.out.print(gameController.welcome());
        String exitGame;

        do {
            System.out.println(gameController.enterOption());
            int userOptionRaw = scanner.nextInt();
            Options userOption = Options.valueOf(userOptionRaw);
            gameController.selectUserChoice(userOption);
            Options machineChoice = gameController.randomMachineChoice();
            Score score = gameController.getResults();
            Player winner = gameController.calculateResult();


            System.out.printf("You played    : %s \n" +
                              "Machine played: %s \n", userOption.name(), machineChoice.name());
            if (Player.USER.equals(winner)) {
                System.out.println("WON");
            }
            else if (Player.TIE.equals(winner)){
                System.out.println("TIE");
            }
            else{
                System.out.println("LOST");
            }
            System.out.printf("Total Games: %d \n",score.totalNumberOfGames());
            System.out.printf("Won        : %d \n",score.getGamesWonByUser());
            System.out.printf("Score      : %d \n",score.getScoreOfUser());
            //System.out.printf("High Score : %d \n", score.getHighScore());

            System.out.println("Continue playing (Y=Yes, N=No)");
            exitGame = scanner.next();

        }while(exitGame.toUpperCase().equals("Y"));

    }
}
