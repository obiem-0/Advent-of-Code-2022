import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoCday7 {
    public AoCday7(){
        //empty
    }



    public void run() {
        String content;

        try {
            content = Files.readString(Paths.get("/Users/ooemuwa/Downloads/Advent of Code 2022/day7/input.txt"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        List<String> directory = new ArrayList<>(List.of(content.split("\\$ cd ")));
        directory.remove(0);
        HashMap <String, List> newDir = new HashMap<>();

        String curr_parent = null;
        String parent_path =  "_";
        Map <String, Integer>  DirSize = new HashMap<>();
        Map <String, Integer>  P1 = new HashMap<>();

        for(String s : directory){
            System.out.println("-------\n"  + "current parent: " + curr_parent + "\n-------\n");

            try{

                String first = s.split("\n")[0];
                System.out.println("navigate to " + first);

                List <String> remainder = new ArrayList<>(List.of(s.split("\n")));
                remainder.removeIf(n -> n.equals("$ ls") || n.equals(first)  );
                System.out.println("elements to add: " + remainder);

               /* if( newDir.get(curr_parent) != null){ /// if there are parents in the dictionary
                    System.out.println("parent node found");

                    if(newDir.get(curr_parent).contains("dir " + first) == false){ //if the current parent doesn't have element

                        System.out.println("doesn't contain element");
                        newDir.put(first, remainder);
                    }
                    else{
                        //find position of element
                        int ind = newDir.get(curr_parent).indexOf("dir " + first);
                        System.out.println("existing element found");

                        newDir.get(curr_parent). set(ind, remainder);

                        System.out.println("new hashMap added under " + first);


                    }
                }
                else{
                    newDir.put(first, remainder);
                    System.out.println("new node added as " +  first);
                } */


                List <String> ye =  new ArrayList<>(remainder);
                ye.removeIf(n -> n.startsWith("dir "));

                int result = ye.stream().map(n -> n.split(" ")[0]).map(Integer::parseInt).reduce(0 , (a, b) -> a +b);

                if(first.equals("..")) {

                    parent_path = parent_path.substring(0 ,parent_path.lastIndexOf("."));
                    curr_parent = parent_path.substring(parent_path.lastIndexOf(".")+1);

                    System.out.println("this is the parent now: " + parent_path );


                }
                else{
                    parent_path = parent_path + "." + first;
                    curr_parent = first;
                    DirSize.put(parent_path, result);
                    P1.put(parent_path, result);

                }

                if( remainder.isEmpty() == false) { // if there are elements that need to be added
                    newDir.put(parent_path, remainder);
                }

                String gp_path = parent_path.substring(0 ,parent_path.lastIndexOf("."));

                System.out.println("Directories' sizes before aggregation: "  + P1);

                if(P1.containsKey(gp_path)) {
                    P1.replaceAll((k,v) -> k.equals(gp_path)? v + result: v  );
                }

                System.out.println("Directories' sizes after aggregation: "  + P1);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            System.out.println(
                    "Directories: " + newDir + "\n\n"
            );



        }

        int TotalSize = DirSize.values().stream().reduce(0, Integer::sum);
        int needed = (30000000 - (70000000 -  TotalSize) );
        int smldirsize = P1.values().stream().filter(num -> num >= needed).min(Integer::compare).get();

        P1.entrySet().removeIf(entry -> entry.getValue() > 100000);

        System.out.println("\n ------- \n");
        System.out.println("Part 1 Answer : "  + P1.values().stream().reduce(0, Integer::sum) );

        System.out.println("\n ------- \n");
        System.out.println("Total size of Directory: "  + TotalSize );
        System.out.println("Needed: "  + needed );
        System.out.println("Part 2 Answer: "  +  smldirsize);


    }

}
