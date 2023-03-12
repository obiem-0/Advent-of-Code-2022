import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class AoCday1 {

    public AoCday1(){}
    

    public void run() {
      
        String content;

        try {
            content = Files.readString(Paths.get("day1/input.txt"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        

    List<Integer> result = Arrays.stream(content.split("\n\n"))
            .map(
                    x -> Arrays.stream(x.split("\n")).map(Integer::parseInt).toList()
                            .stream()
                            .reduce(0, Integer::sum)
            )
            .toList().stream().sorted().collect(Collectors.toList());


        System.out.println( 
                "Part 1 Answer: " + result.get(result.size() -1)
        );
    
        System.out.println(
                "Part 2 Answer: "
                        + (result.get(result.size() -1) 
                        + result.get(result.size() -2) 
                        + result.get(result.size() -3))
        );
    

}

}
