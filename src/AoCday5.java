import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoCday5 {

    public AoCday5(){
            //empty constructor

        }

        public void run(){
            int count = 0;

            String content;

            try {
                content = Files.readString(Paths.get("/Users/ooemuwa/Downloads/Advent of Code 2022/day5/input.txt"));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }



            String stacks = content.split("\n\n")[0];
            List<String> guide = List.of(content.split("\n\n")[1].split("\n"));


            List<String> l4 = new ArrayList<>(Arrays.asList(stacks.split("\n")));
            int len = l4.size();
            l4.remove(len-1);

            List<String> l3 = new ArrayList<>();

            for ( String x : l4 ) {

                String s = x.replace("] ", "]")
                        .replace(" [", "[")
                        .replace("   ", "[#]")
                        .replace(" ", "")
                        .replace("][", ",")
                        .replace("]", "")
                        .replace("[", "");

                l3.add(s);
            }

           List<List<String>> l5 = new ArrayList<>();
            for(int i = 0; i<len; i++){ /// for the number of columns i.e 9 (if  counting from 0 then 8)
                List<String> temp = new ArrayList<>();

               for(String x: l3){
               if (!(x.split(",")[i].equals("#"))){
                   temp.add(
                           x.split(",")[i]
                   );
               }
            }

              l5.add(i,temp); ;
            }

            //List<String[]> newguide= new ArrayList<>();

            int end1 =0;
            int start1 = 0;
            int steps1 = 0;
            for ( String x : guide ){

                  String end = x.split("to ")[1];
                  String start = x.split(" to ")[0].split(" from ")[1];
                  String steps = x.split(" to ")[0].split(" from ")[0].split("move ")[1];

                  end1 = Integer.parseInt(end);
                  start1 = Integer.parseInt(start);
                  steps1 = Integer.parseInt(steps);


                  for(int i = 0; i<steps1; i++){
                    String s = l5.get(start1-1).get(0);
                    if(steps1==1){
                        l5.get(end1-1).add(0, s);
                    }else {
                        l5.get(end1-1).add(i, s);
                    }
                    l5.get(start1-1).remove(0);

                }
                //System.out.println(l5);


            }

            for(int i  = 0; i<l5.size(); i++){
                System.out.print(
                    l5.get(i).get(0)
                    );
            }








        }

    }
