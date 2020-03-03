package minitest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * class functional description
 *
 * @author fengyi
 * @version 1.0.0
 * @since 2020/3/3
 */
public class DigitsIntoLettersSolution {

    private static  Map<String, List<String>> digitsMap ;//key ：digits value ：letters

    public DigitsIntoLettersSolution(){
        digitsMap=new HashMap<>();
        digitsMap.put("0",Arrays.asList(""));
        digitsMap.put("1", Arrays.asList(""));
        digitsMap.put("2",Arrays.asList("a","b","c"));
        digitsMap.put("3",Arrays.asList("d","e","f"));
        digitsMap.put("4",Arrays.asList("g","h","i"));
        digitsMap.put("5",Arrays.asList("j","k","l"));
        digitsMap.put("6",Arrays.asList("m","n","o"));
        digitsMap.put("7",Arrays.asList("p","q","r","s"));
        digitsMap.put("8",Arrays.asList("t","u","v"));
        digitsMap.put("9",Arrays.asList("w","x","y","z"));
    }

    /**
     * Convert the input digits into letter combinations
     * @param arrStr
     * @return
     */
    public String digitsToLetters(String[] arrStr) {

        //检测数据输入合法性
        if (arrStr == null || arrStr.length < 1) {
            return "-1";
        } else {
            for (int i = 0; i < arrStr.length; i++) {
                if (!arrStr[i].matches("[0-9]{1,2}")) {
                    return "-1";
                }
            }
        }

        List<String[]> dataList = new ArrayList<>();//收集输入数字对应的所有字母

        for (int i = 0; i < arrStr.length; i++) {
            //获取输入数字所对应的所有字母
            List<String> allLettersList = digitsMap.get(arrStr[i]);
            if (Objects.nonNull(allLettersList) && allLettersList.size() > 0) {
                String[] letterArr = allLettersList.toArray(new String[allLettersList.size()]);
                dataList.add(letterArr);
            }
        }

        //使用递归获取所有字母组合
        List<String[]> resultList = digitsIntoLettersForRecursion(dataList, 0, null);


        //返回所有排列组合结果
        StringBuilder result = new StringBuilder(" ");
        for (int i = 0; i < resultList.size(); i++) {
            String[] letterArr = resultList.get(i);
            for (String s : letterArr) {
                result.append(s);
            }
            result.append(" ");
        }
        return result.toString();
    }

    /**
     * Convert the input digits into letter combinations for recursion
     * @param dataList
     * @param index
     * @param resultList
     * @return
     */
    private static List<String[]> digitsIntoLettersForRecursion(List<String[]> dataList, int index, List<String[]> resultList) {
        if (index == dataList.size()) {
            return resultList;
        }

        List<String[]> firstResultList = new ArrayList<>();
        if (index == 0) {//第一列数组默认有多少个字母就添加多少个排列数据
            String[] dataArr = dataList.get(0);
            for (String s : dataArr) {
                firstResultList.add(new String[]{s});
            }
        } else {
            String[] dataArr = dataList.get(index);
            for (String[] dataArrPre : resultList) {
                for (String s : dataArr) {
                    //复制数组并扩充新元素
                    String[] dataArrCopy = new String[dataArrPre.length + 1];
                    System.arraycopy(dataArrPre, 0, dataArrCopy, 0, dataArrPre.length);
                    dataArrCopy[dataArrCopy.length - 1] = s;
                    //追加到结果集
                    firstResultList.add(dataArrCopy);
                }
            }
        }
        return digitsIntoLettersForRecursion(dataList, ++index, firstResultList);
    }
}
