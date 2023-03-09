import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoCday6 {
    public AoCday6() {
        //empty constructor

    }

    public void run() {
        String content;

        try {
            content = Files.readString(Paths.get("day6/input.txt"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
            int total = 0;
            int countOne = 0;

            System.out.println(content.length());

            for(int i = 0; i<content.length(); i++) {
                total=i;

                for(int j = i; j<i+14;  j++){
                    countOne++;
                    for(int k = j+1; k<i+14; k++){
                        if(content.charAt(j)==content.charAt(k)){
                            countOne = 0;
                        }
                    }

                }

                if(countOne==14){
                    break;
                }else{
                    countOne = 0;
                }
            }

        System.out.println(total+14);

        // a count to check when we have 4 characters, the count restarts as soon as it finds same so we can stop
        //a count to check how many characters we have been through
        //a variable to store the current position
    }
    
}
