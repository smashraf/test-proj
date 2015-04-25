package rohan.test.dozer;

public class B {
    
    String bstr;
    
    Integer i;

    public String getBstr() {
        return bstr;
    }

    public void setBstr(String bstr) {
        this.bstr = bstr;
    }

    public Integer getI() {
        return i;
    }

    public void setBint(Integer bint) {
        this.i = bint;
    }

    @Override
    public String toString() {
        return "B [bstr=" + bstr + ", i=" + i + "]";
    }
}
