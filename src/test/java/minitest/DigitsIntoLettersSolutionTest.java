package minitest;

import org.junit.Assert;
import org.junit.Test;

/**
 * class functional description
 *
 * @author fengyi
 * @version 1.0.0
 * @since 2020/3/3
 */
public class DigitsIntoLettersSolutionTest {

    @Test
    public void testDigits23ToLetters () {
        DigitsIntoLettersSolution digitsIntoLettersSolution = new DigitsIntoLettersSolution();

        String result = digitsIntoLettersSolution.digitsToLetters(new String[]{"2", "3"});
        Assert.assertEquals(result, " ad ae af bd be bf cd ce cf ");
    }

    @Test
    public void testDigits3ToLetters () {
        DigitsIntoLettersSolution digitsIntoLettersSolution = new DigitsIntoLettersSolution();

        String result = digitsIntoLettersSolution.digitsToLetters(new String[]{"3"});
        Assert.assertEquals(result, " d e f ");
    }

    @Test
    public void testInputNonNumericalCharacterToLetters () {
        DigitsIntoLettersSolution digitsIntoLettersSolution = new DigitsIntoLettersSolution();

        String result = digitsIntoLettersSolution.digitsToLetters(new String[]{"a"});
        Assert.assertEquals(result, "-1");
    }
}
