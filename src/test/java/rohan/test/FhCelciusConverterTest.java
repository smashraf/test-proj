package rohan.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class FhCelciusConverterTest {
    
    public static Object[] getData() {
        return $( $(32,0),
                  $(98,37),
                  $(212,100)
                );
    }
    
    @Test
    @Parameters(method="getData")
    public void shouldCToF(Integer c, Integer f ) {
        assertEquals(c,FToCConverter(f));
    }
    
    //Dummy imple
    private Integer FToCConverter(Integer f) {
        return f;
    }
    

}
