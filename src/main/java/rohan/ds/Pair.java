package rohan.ds;

public class Pair {

    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        //Default constructor
    }

    public Integer getDiff() {
        return second != -1 ? second - first : -1;
    }

}
