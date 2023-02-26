import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoCday4 {
    public AoCday4(){
        //empty constructor
        
   }

   public void run(){
    int total = 0;
    File myObj = new File("day4/input.txt");
    Scanner myReader = null;
    try {
        myReader = new Scanner(myObj);
    } catch (FileNotFoundException ex) {
        throw new RuntimeException(ex);
    }

    
    
    while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        
        //Part 1 Answer
        String[] parts = data.split("[,-]");
        total+=numberPairs(parts[0], parts[1], parts[2], parts[3]);
       
        
        //Part 2 Ends here


    }
        System.out.println(total);
        myReader.close();
    }

    public int numberPairs(String first, String second, String third, String fourth){
        int countOne = 0;
        int countTwo = 0;
        ArrayList<Integer> groupOne = new ArrayList<Integer>();//list to store the range of number of the first assignment in the pair
        ArrayList<Integer> groupTwo = new ArrayList<Integer>();//list to store the range of number of the second assignment in the pair
        
        //to add the numbers to each list
        for(int i = Integer.parseInt(first); i<=Integer.parseInt(second); i++){
            groupOne.add(i);
            
        }

        for(int j = Integer.parseInt(third); j<=Integer.parseInt(fourth); j++){
            groupTwo.add(j);
            
        }

        //System.out.println(countOne+ " " + countTwo);
        
        //Check which assignment fully contains the other and return the count of all numbers that match
        if(groupOne.size()>=groupTwo.size()){//first check which assignment has the bigger range 
            for(int i = 0; i<groupOne.size(); i++){
                for(int j = 0; j<groupTwo.size(); j++){
                    if(groupTwo.get(j) == groupOne.get(i)){
                        countTwo++;
                        }
                    }
                } 
        } else{
            for(int i = 0; i<groupTwo.size(); i++){
                for(int j = 0; j<groupOne.size(); j++){
                    if(groupTwo.get(i) == groupOne.get(j)){
                        countOne++;
                        }
                    }
                } 
            }
        
        //If the size of the list matches the count, it means that all numbers were within that range
        //return 1 if one of the assignments in the pair fully contains the other else return 0
        if(countTwo == groupTwo.size() || countOne == groupOne.size()){
            return 1;
        }else {
            return 0;
        }
        
    }
}
