package rohan.test.dozer;

public class A {

    //C c;

    Integer i;

    public int getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public C getC() {
        C c = new C();
        //B b = new B();
        c.setCstr("cstr in A");
        return c;
    }

//    public void setC(C c) {
//        this.c = c;
//    }

}
