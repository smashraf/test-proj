package rohan.test;

import static junitparams.JUnitParamsRunner.$;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MyHashMapTest {

    private Map<Object,Object> map;
    
    @Before
    public void setMap(){
        
        map = new HashMap<Object, Object>();
    }
    
    public static Object[] getHashMapData() {
        return $(
                    $(10,"abc"),
                    $(20,"xyz"),
                    $(null,10)
                );
    }
    
    public static Object[] getDuplicateData() {
        return $(
                    $(10,"val1","val2"),
                    $(10,"abc", "xyz")
                );
    }

    @Test
    @Parameters(method="getHashMapData")
    public void putGetTest(Object key, Object value) {
        map.put(key, value);
        Assert.assertEquals(value,map.get(key));
    }
    
    @Test
    @Parameters(method="getDuplicateData")
    public void putReplacementTest(Object key, Object value1,Object value2) {
        map.put(key, value1);
        map.put(key, value2);
        Assert.assertEquals(value2,map.get(key));
    }
    
    @Test
    @Parameters(method="getHashMapData")
    public void clearTest(Object key, Object value) {
        map.put(key, value);
        Assert.assertFalse(map.isEmpty());
        map.clear();
        Assert.assertTrue(map.isEmpty());
    }

    @After
    public void clearMap() {
        
        map.clear();
    }
}
