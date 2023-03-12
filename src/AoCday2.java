import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class AoCday2 {

    public AoCday2(){

    }
    

    public void run() {

  
        //X = lose
        //Y = draw
        //Z = win
        //Rock = 1 = A
        //Paper = 2 = B
        //Scissors = 3 = C
        int playerScore = 0;
        int totalScore = 0;
        //int roundScore = 0;
        File myObj = new File("day2/input1.txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine().replaceAll("\\s", "");

            String compPlay = checkPlay(data.charAt(0));
            String userPlay = checkPlay(data.charAt(1));

            char outCome = getAnswer(data.charAt(1), compPlay);
            String userPlay1 = checkPlay(outCome);

            playerScore += checkScore(userPlay1) + checkScoreOfMatch(userPlay1, compPlay);
            totalScore += checkScore(userPlay) + checkScoreOfMatch(userPlay, compPlay);
            //roundScore = checkScoreOfMatch(userPlay1, compPlay) + checkScore(userPlay1);
            //System.out.println(checkPlay(data.charAt(0)) + " " + data.charAt(1) + " " + checkScoreOfMatch(userPlay, compPlay) + " " + roundScore +  " " + outCome);
            //System.out.println(checkPlay(data.charAt(0)) + " " + checkOutcome(data.charAt(1)) + " " + userPlay1 + " " + checkScoreOfMatch(userPlay1, compPlay) + " " + roundScore);
        }
        System.out.println("Part 1 Answer: " + totalScore);//Part 1
        System.out.println("Part 2 Answer: " + playerScore);//Part 2

        myReader.close();

    }

    //0 = loss
    //3 = draw
    //6 = won
    public String checkPlay(char gamePlay){
        //X = Rock = 1 = A
        //Y = Paper = 2 = B
        //Z = Scissors = 3 = C
        return switch (gamePlay) {
            case 'A', 'X' -> "Rock";
            case 'B', 'Y' -> "Paper";
            case 'C', 'Z' -> "Scissors";
            default -> "";
        };
    }

    public String checkOutcome(char gamePlay){
        //X = lose
        //Y = draw
        //Z = win
        return switch (gamePlay) {
            case 'X' -> "lose";
            case 'Y' -> "draw";
            case 'Z' -> "win";
            default -> "";
        };
    }

    public int checkScore(String playChosen){
        return switch (playChosen) {
            case "Rock" -> 1;
            case "Paper" -> 2;
            case "Scissors" -> 3;
            default -> 0;
        };
    }

    public int checkScoreOfMatch(String playChosen, String compChosen){
        if(compChosen.equals("Rock")) {
            return switch (playChosen) {
                case "Scissors" -> 0;
                case "Paper" -> 6;
                default -> 3;
            };
        }

        if(compChosen.equals("Scissors")) {
            return switch (playChosen) {
                case "Rock" -> 6;//win
                case "Paper" -> 0;//loss
                default -> 3;
            };
        }

        if(compChosen.equals("Paper")) {
            return switch (playChosen) {
                case "Rock" -> 0;//win
                case "Scissors" -> 6;//loss
                default -> 3;
            };
        }

        return 0;
    }

    public char getAnswer(char desiredOutcome, String compChosen){

        //X = Rock = 1 = A
        //Y = Paper = 2 = B
        //Z = Scissors = 3 = C
        if(compChosen.equals("Rock")) {
            return switch (desiredOutcome) {
                case 'X' -> 'C';//loss
                case 'Z' -> 'B';//win
                default -> 'A';
            };
        }

        if(compChosen.equals("Scissors")) {
            return switch (desiredOutcome) {
                case 'X' -> 'B';//loss
                case 'Z' -> 'A';//win
                default -> 'C';
            };
        }

        if(compChosen.equals("Paper")) {
            return switch (desiredOutcome) {
                case 'X' -> 'A';//loss
                case 'Z' -> 'C';//win
                default -> 'B';
            };
        }
        return 0;
    }



}