import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoCday8 {
    public AoCday8() {
        //empty constructor

    }

    public void run(){
        String content;

        try {
            content = Files.readString(Paths.get("/Users/ooemuwa/Downloads/Advent of Code 2022/day8/input.txt"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println(content);

        System.out.println("---------");

        List<String> first = new ArrayList<>(Arrays.asList(content.split("\n")));
        List<String> second = new ArrayList<>();

        int ch = first.get(0).length();
        StringBuilder x = new StringBuilder();

        int count = 0;
        //to create list for the column
        for(int i = 0; i<ch; i++){
            for (String s : first) {
                x.append(s.charAt(i));
            }
            second.add(x.toString());
            x = new StringBuilder();

        }
        //to count the number on the edges
        for(int i = 0; i<first.size(); i++){
            for(int j = 0; j<ch; j++){
                if((i == 0 || i == ch-1 )){
                    count++;
                }else if((j == 0 || j == ch-1)){
                    count++;
                }
            }

        }

        System.out.println(first);
        System.out.println("---------");
        System.out.println(second);
        System.out.println("---------");

        //to compare the numbers
        for(int h = 1; h<first.size()-1;h++) {
            for (int i = 1; i < ch - 1; i++)  {
                int check = 0;
                int counted = 0;
                int main = convert(first.get(h).charAt(i));
                //to the left direction
                for(int l = i-1; l>=0;l--){
                   if(main>convert(first.get(h).charAt(l))){
                       check++;
                       System.out.println(main +" is greater than "+ convert(first.get(h).charAt(l)));
                    }else{
                       check  = 0;
                       System.out.println(main +" is not greater than "+ convert(first.get(h).charAt(l)));
                       break;
                   }
                }

                counted+=check;

                //to the right direction
                for(int k = i+1; k<ch;k++){
                    if(main>convert(first.get(h).charAt(k))){
                        check++;
                        System.out.println(main +" is greater than "+ convert(first.get(h).charAt(k)));
                    } else{
                        check = 0;
                        System.out.println(main +" is not greater than "+ convert(first.get(h).charAt(k)));
                        break;
                    }

                }

                counted+=check;

                //up
                for(int l=h-1; l>=0;l--){
                    if(main>convert(second.get(i).charAt(l))){
                        check++;
                        System.out.println(main +" is greater than "+ convert(second.get(i).charAt(l)));
                    }else{
                        check  = 0;
                        System.out.println(main +" is not greater than "+ convert(second.get(i).charAt(l)));
                        break;
                    }
                }

                counted+=check;

                //down

                for(int k = h+1; k<ch;k++){
                    if(main>convert(second.get(i).charAt(k))){
                        check++;
                        System.out.println(main +" is greater than "+ convert(second.get(i).charAt(k)));
                    } else{
                        check = 0;
                        System.out.println(main +" is not greater than "+ convert(second.get(i).charAt(k)));
                        break;
                    }

                }

                counted+=check;
                //if greater than zero, it means it was visible in at least one direction
                if(counted>0){
                    count++;
                }

                System.out.println("------");
                }

        }
        System.out.println("Total number of visible trees: "+count);

    }

    public int convert(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

}