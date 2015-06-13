package rohan.ds;

public class MathematicalQue {

    public void printCombos(int n, int[] curr, int k) {
        if (n <= 0) {
            for (int i = 0; i < k; i++)
                System.out.print(curr[i]);
            System.out.println();
            return;
        }
        if (n - 1 >= 0) {
            curr[k] = 1;
            printCombos(n - 1, curr, k + 1);
        }
        if (n - 2 >= 0) {
            curr[k] = 2;
            printCombos(n - 2, curr, k + 1);
        }
        if (n - 3 >= 0) {
            curr[k] = 3;
            printCombos(n - 3, curr, k + 1);
        }
    }

    public boolean isLucky(int pos, int i) {
        if (pos < i)
            return true;
        else if (pos % i == 0)
            return false;
        return isLucky(pos - pos / i, i + 1);
    }
}
