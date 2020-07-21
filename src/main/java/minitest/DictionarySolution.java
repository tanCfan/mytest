package minitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fengyi
 * @description Given a non-empty string and a dictionary containing a list of non-empty words
 * Add whitespace to the string to build the sentence
 * @date 2020-07-20
 */
public class DictionarySolution {

    //Used  to record a list of sentences that a string can produce
    HashMap<String, List<String>> hashMap = new HashMap<>();

    /**
     *
     * @param inputStr
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String inputStr, List<String> wordDict) {
        if(hashMap.containsKey(inputStr)) {
            return hashMap.get(inputStr);
        }

        //End the recursive call
        List<String> list = new ArrayList<>();
        if(0 == inputStr.length()){
            list.add("");
            return list;
        }

        //Through the dictionary
        for(String str : wordDict){
            if(inputStr.startsWith(str)){
                //Recursive processing
                List<String> subList = wordBreak(inputStr.substring(str.length()), wordDict);
                for(String sub : subList){
                    list.add(str + ("".equals(sub) ? "" : " ") + sub);
                }
            }
        }
        hashMap.put(inputStr, list);
        return list;
    }
}
