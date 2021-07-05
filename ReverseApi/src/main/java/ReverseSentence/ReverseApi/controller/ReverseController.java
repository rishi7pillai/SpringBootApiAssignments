package ReverseSentence.ReverseApi.controller;

import ReverseSentence.ReverseApi.service.ReverseWordService;
import ReverseSentence.ReverseApi.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController {

    @Autowired
    private ReverseService reverseService;

    @Autowired
    private ReverseWordService revereseWordService;


    //it will reverse the sentence and also gives index of palindrome word
    @PostMapping("/reverse")
    public StringBuilder reverseSentence(@RequestBody String sentence){
        return reverseService.reverseString(sentence);
    }
    

    //it will reverse the sentence and also reverse the word as well as
    @PostMapping("/reverseword")
    public StringBuilder reverseWord(@RequestBody String sentence){
        return revereseWordService.reverseWord(sentence);
    }
}
