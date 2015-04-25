package rohan.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PasswordTest {

    public static final Integer MIN_LENGTH = 8;

    public static List<Character> specialCharsList = null;

    @Before
    public void initSpecialCharList() {
        specialCharsList = new ArrayList<>();
        specialCharsList.addAll(Arrays.asList('_', '$', '@', '#'));
    }

    public static Object[] getPassword() {
        return $($("@AXBA9ef"), $("#AXBA9ef"));
    }

    @Test
    @Parameters(method = "getPassword")
    public void validatorTest(String password) {
        boolean containsSpecialChar = false;
        assertTrue(password.length() >= MIN_LENGTH);
        for (Character c : specialCharsList) {
            if (password.contains(c.toString()))
                containsSpecialChar = true;
        }
        assertTrue(containsSpecialChar);
    }

}
