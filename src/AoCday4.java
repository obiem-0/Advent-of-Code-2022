import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoCday4 {
    public AoCday4(){
        //empty constructor
        
   }

   public void run(){
    File myObj = new File("day4/input.txt");
    Scanner myReader = null;
    try {
        myReader = new Scanner(myObj);
    } catch (FileNotFoundException ex) {
        throw new RuntimeException(ex);
    }

    
    
    while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        

        //Part 1 Answer
       
        
        //Part 2 Ends here


    }

    myReader.close();
}
}
