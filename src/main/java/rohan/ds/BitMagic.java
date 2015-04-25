package rohan.ds;

public class BitMagic {

    public int getNextPowerOfTwo(int num) {
        int ans = 1;
        if (num == 0 || ((num & (num - 1)) == 0))
            return num;
        else {
            while (num != 0) {
                num = num >> 1;
                ans = ans << 1;
            }
        }
        return ans;
    }

    public boolean isMultipleOfThree(int num) {
        int oddCount = 0, evenCount = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                evenCount++;
            }
            num >>= 1;
            if (num != 0) {
                if ((num & 1) == 1) {

                    oddCount++;
                }
                num >>= 1;
            }
        }
        return (evenCount - oddCount) % 3 == 0;
    }
    
    public int getOddOccuring(int []arr) {
        int num=0;
        for (int i : arr) {
            num = (num^i);
        }
        return num;
    }
}
