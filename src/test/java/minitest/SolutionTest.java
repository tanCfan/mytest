package minitest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengyi
 * @description
 * @date 2020-07-20
 */
public class SolutionTest {

    @Test
    public void testWorkBreak1() {
        String inputStr = "ilikesamsungmobile";
        List<String> dictionaryList = new ArrayList<>();
        dictionaryList.add("i");
        dictionaryList.add("like");
        dictionaryList.add("sam");
        dictionaryList.add("sung");
        dictionaryList.add("samsung");
        dictionaryList.add("mobile");
        dictionaryList.add("ice");
        dictionaryList.add("cream");
        dictionaryList.add("man go");
        dictionaryList.add("and");
        Solution solution = new Solution();
        List<String> strings = solution.wordBreak(inputStr, dictionaryList);
        System.out.println(strings.toString());
    }

}
