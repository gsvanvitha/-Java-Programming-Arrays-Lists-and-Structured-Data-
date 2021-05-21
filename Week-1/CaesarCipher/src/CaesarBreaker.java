import java.util.Locale;

public class CaesarBreaker {
    public String decrypt(String encrypted, int key){
        caesarCipher cc = new caesarCipher();
        String message = cc.encrypt(encrypted, 26-key);
        return message;
    }
    public String halfOfString(String message, int start){
        String answer = "";
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);
        }
        return answer;
    }
    public int getKey(String s){
        int[] letterFreq = countLetters(s);
        int maxIndex = maxIndex(letterFreq);
        int key = maxIndex;
        if (maxIndex < 4) {
            key = 26 - (4-maxIndex);
        }
        return key;
    }
    public int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        message = message.toLowerCase();
        for (int k = 0; k<message.length(); k++) {
            char ch = message.charAt(k);
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index] += 1;
            }
        }
        return counts;
    }
    public void decryptTwoKeys(String encrypted){
        String s1 = halfOfString(encrypted, 0);
        String s2 = halfOfString(encrypted, 1);
        System.out.println(s1);
        System.out.println(s2);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        caesarCipher cc = new caesarCipher();
        System.out.println(cc.encryptTwoKeys(encrypted, 26-key1, 26-key2));
    }


    public int maxIndex(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i] > values[max]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        CaesarBreaker cb = new CaesarBreaker();
        cb.decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
    }
}
