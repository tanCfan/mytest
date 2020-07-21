package minitest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengyi
 * @description Test DictionarySolution
 * @date 2020-07-20
 */
public class DictionarySolutionTest {

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
        DictionarySolution solution = new DictionarySolution();
        List<String> strings = solution.wordBreak(inputStr, dictionaryList);
        System.out.println(strings.toString());
        Assert.assertEquals("[i like sam sung mobile, i like samsung mobile]", strings.toString());
    }

}
