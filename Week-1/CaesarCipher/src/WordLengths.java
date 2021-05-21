import edu.duke.*;

import java.sql.SQLOutput;
import java.util.Arrays;

public class WordLengths {
    public void countWordLengths(FileResource resource, int count[]){
        String file = resource.asString();
        String fileArray[]=file.split(" ");
        int length=0;
        for(int i=0;i<fileArray.length;i++){
            length=fileArray[i].length();
            if(length>=30)length=30;
            if(!Character.isLetter(fileArray[i].charAt(0))){
                length--;
            }
            if(!Character.isLetter(fileArray[i].charAt(fileArray[i].length()-1))){
                length--;
            }
            count[length]++;
        }

    }
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int count[]= new int[31];
        countWordLengths(fr, count);
        System.out.println(Arrays.toString(count));
    }
    public static void main(String[] args){
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();
    }
}
