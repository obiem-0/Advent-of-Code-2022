import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AoCday1 {

    static {
        try {
            content = Files.readString(Paths.get("day1/input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String content;

    List<Integer> result = Arrays.stream(content.split("\n\n"))
            .map(
                    x -> Arrays.stream(x.split("\n")).map(Integer::parseInt).toList()
                            .stream()
                            .reduce(0, Integer::sum)
            )
            .toList().stream().sorted().collect(Collectors.toList());


    public void p1() {

        System.out.println(
                "The highest total calories is: " + result.get(result.size() -1)
        );
    }
    public void p2() {

        System.out.println(
                "The sum of top highest 3 total calories is: "
                        + (result.get(result.size() -1) 
                        + result.get(result.size() -2) 
                        + result.get(result.size() -3))
        );
    }


}
