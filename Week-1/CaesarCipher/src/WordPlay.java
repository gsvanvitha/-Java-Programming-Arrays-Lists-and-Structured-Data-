public class WordPlay {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')return true;
        return false;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder replace = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(isVowel(phrase.charAt(i)))replace.setCharAt(i,ch);
        }
        return replace.toString();
    }
    public String emphasize(String phrase, char ch){
        StringBuilder replace = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(phrase.charAt(i)==ch){
                if(i%2==0)replace.setCharAt(i,'*');
                else replace.setCharAt(i,'+');
            }
        }
        return replace.toString();
    }
    public void tester(){
        System.out.println(isVowel('a')+" "+isVowel('B')+" "+isVowel('U'));
        System.out.println(replaceVowels("Anna",'#'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }
    public static void main(String[] args){
        WordPlay wordplay = new WordPlay();
        wordplay.tester();
    }
}
