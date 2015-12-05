package groupl.cs314.quizapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class RandomArray {

    private static List<String[]> wordList = new ArrayList<String[]>();

    //get random array of 40
    //returns 0 to (max-1)
    private static List<Integer> getRandomArray(int max){
        List<Integer> ra = new ArrayList<Integer>();
        Random gen = new Random();
        int rn = gen.nextInt(max);
        int governor = 0;
        while(ra.size()<max){
            //safety
            if(governor == 10){
                rn = 0;
                boolean status = true;
                while(status){
                    if(!ra.contains(rn))
                        status = false;
                    else
                        rn++;
                }
            }
            if(!ra.contains(rn)){
                ra.add(rn);
                governor = 0;
            }else{
                governor++;
            }
            rn = gen.nextInt(max);
        }
        return ra;
    }
}
