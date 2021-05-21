import edu.duke.*;
public class caesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String newAplhabet = alphabet.substring(key)+alphabet.substring(0,key);
        String newMiniAplhabet = sAlphabet.substring(key)+sAlphabet.substring(0,key);
        for(int i=0;i<input.length();i++){
            int index = alphabet.indexOf(input.charAt(i));
            int mIndex = sAlphabet.indexOf(input.charAt(i));
            if(index !=-1)
            encrypted.setCharAt(i, newAplhabet.charAt(index));
            else if(mIndex != -1)
                encrypted.setCharAt(i, newMiniAplhabet.charAt(mIndex));
        }
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        String encrypt1 = encrypt(input, key1);
        String encrypt2 = encrypt(input, key2);
        StringBuilder encrypted= new StringBuilder(input);

        for (int i=0; i< input.length();i++){
            if (i%2==0)
                encrypted.setCharAt(i, encrypt1.charAt(i));

            else encrypted.setCharAt(i, encrypt2.charAt(i));
        }

        return encrypted.toString();
    }
    public void testCaesar(){
        int key = 15;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
        int key1=5,key2=10;
         encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println("key is " + key + "\n" + encrypted);
         decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }

    public static void main(String[] args){
        caesarCipher cc=new caesarCipher();
        System.out.println(cc.encrypt("CAT",3));
        cc.testCaesar();
    }
}
