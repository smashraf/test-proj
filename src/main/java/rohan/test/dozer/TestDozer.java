package rohan.test.dozer;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class TestDozer {

    @Resource(name = "mapper")
    private Mapper mapper;

    @Test
    public void testDozer() {
        A a = new A();
        
        a.setI(20);
        

        B b = mapper.map(a, B.class , "z");
        System.out.println(b.toString());

    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

}
