package ReverseSentence.ReverseApi.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseWordService {

    //Reverse the sentence with words
    public StringBuilder reverseWord(String sentence){

        String words[]=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        sb.append(" ").append(" reversed sentence : ");
        for(int i=words.length-1;i>=0;i--){
             StringBuilder stringBuilder = new StringBuilder(words[i]);
             stringBuilder.reverse();
             sb.append(stringBuilder).append(" ");
        }
        return sb;
    }
}
