package rohan.junit;

public class CoinChange {

    // This one is trivial...
    public int getNumberOfWays(Integer S[], int N, int i) {
        if (N == 0)
            return 1;
        else if (i >= S.length && N != 0)
            return 0;
        else if (N < 0)
            return 0;
        else {
            return getNumberOfWays(S, N, i + 1) + getNumberOfWays(S, N - S[i], i);
        }
    }

    // Now the trick here is to identify the variables from the above
    // implementation.
    // The variables are N and i=> 2 variables so 2-d array
    public Long getNumberOfWaysDp(Integer S[], Integer N) {
        Long[][] arr = new Long[N+1][S.length];
        // Beacuse we can always create 0 rupee in exactly one way i.e. 0 coins
        // needed
        for (Integer j = 0; j < S.length; j++)
            arr[0][j] = 1L;
        for (Integer i = 1; i <= N; i++) {
            for (Integer j = 0; j < S.length; j++) {
                // Now we know we can make i with S[0..j-1] coins in arr[i][j-1]
                // ways and adding it to sum.
                // i-S[j] represents some previous i(rupee) which had
                // arr[i-S[j]][j] ways of creating it
                // So i can now be created with adding s[j] to i-S[j]
                arr[i][j] = (j - 1 >= 0 ? arr[i][j - 1] : 0) + (i - S[j] >= 0 ? arr[i - S[j]][j] : 0);
            }
        }
        // This is the number of ways to create N(rupee) from S[1..S.length]
        // coins
        return arr[N][S.length - 1];
    }

}
