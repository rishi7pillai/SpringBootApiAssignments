package ReverseSentence.ReverseApi.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseService {

    public StringBuilder reverseString(String sentence){

        //Split the sentence
        String[] words = sentence.split(" ");
        StringBuilder reverseString = new StringBuilder();


        //to check palindrome locations
        int numberCount=0;
        String palindromeLocation = "";
        String palindromeWords =" ";
        for(String w:words){
            try{
                if(isPalindrome(w)){
                    palindromeLocation = palindromeLocation+numberCount+" ";
                    palindromeWords=palindromeWords+w+" ";
                }
                numberCount=numberCount+w.length()+1;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        //For reverse the sentence
        reverseString.append(" ").append("Reverse sentence : ");
        for (int i = words.length - 1; i >= 0; i--) {
            reverseString.append(words[i]).append(" ");
        }
        reverseString.append("\r\n palindrome locations are : ")
                .append(palindromeLocation)
                .append("\r\n palindrome words are : ")
                .append(palindromeWords);

        return  reverseString;

    }

    //function to check palindrome
    private boolean isPalindrome(String w) {
        String reverse = "";
        for(int i=w.length()-1;i>=0;i--){
            reverse=reverse+w.charAt(i);
        }
        if(reverse.equals(w))
            return true;
        else
            return false;
    }

}
