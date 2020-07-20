package minitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fengyi
 * @description
 * @date 2020-07-20
 */
public class Solution {

    //记忆已做过切词的记录
    HashMap<String, List<String>> hashMap = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(hashMap.containsKey(s)) {
            return hashMap.get(s);
        }

        //结束递归
        List<String> list = new ArrayList<>();
        if(0 == s.length()){
            list.add("");
            return list;
        }

        //切词
        for(String str : wordDict){
            if(s.startsWith(str)){
                List<String> subList = wordBreak(s.substring(str.length()), wordDict);
                for(String sub : subList){
                    list.add(str + ("".equals(sub) ? "" : " ") + sub);
                }
            }
        }
        hashMap.put(s, list);
        return list;
    }
}
