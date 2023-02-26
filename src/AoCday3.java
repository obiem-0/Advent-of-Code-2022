import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoCday3 {
    public AoCday3(){
        //empty constructor
   }

    public void run(){
        File myObj = new File("day3/input.txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        int total = 0;
        int totalSecond = 0;
        int count = 0;
        ArrayList<String> groupElf = new ArrayList<String>();
        
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            

            //Part 1 Answer
            int length = data.length()/2;
            String[] parts = data.split("(?<=\\G.{" +length+ "})");
            total+=getNumber(compareLetters(parts[0], parts[1]));//Part 1
            //Part 1 Ends here

            //Part 2 Answer
            count++;
            groupElf.add(data);
            if(count == 3){
                totalSecond+=getNumber(compareLetters(groupElf.get(0), groupElf.get(1), groupElf.get(2)));

                groupElf = new ArrayList<String>();
                count = 0;
            }
            //Part 2 Ends here


        }

        System.out.println("Part 1: " + total);//Part 1
        System.out.println("Part 2: " + totalSecond);//Part 2
        myReader.close();
    }

    public int getNumber(char check){
        int number = 0;
        char c;

        for(c = 'a'; c <= 'z'; ++c){
            number++;
            if(check == c){
                return number;
            }
            //System.out.print(c + " ");
        }

        for(c = 'A'; c <= 'Z'; ++c){
            number++;
            if(check == c){
                return number;
            }
            //System.out.print(c + " ");
        }

        return 0;
    }

    public char compareLetters(String first, String second){
        for(int i = 0; i<first.length(); i++){
            for(int j = 0; j<second.length(); j++){
                if(first.charAt(i) == second.charAt(j)){
                    return first.charAt(i);
                }
            }
        }

        return 0;
    }

    public char compareLetters(String first, String second, String third){
        for(int i = 0; i<first.length(); i++){
            for(int j = 0; j<second.length(); j++){
                for(int k = 0; k<third.length(); k++){
                    if(first.charAt(i) == second.charAt(j) && first.charAt(i)== third.charAt(k)){
                    return first.charAt(i);
                    }
                }
            }
        }

        return 0;
    }
}
