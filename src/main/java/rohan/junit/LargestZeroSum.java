package rohan.junit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import rohan.ds.Pair;

public class LargestZeroSum {

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    // Naive recursive approach
    public int getLargestSubSet(Integer[] S, int sum, int i, int count) {
        if (sum == 0 && i == S.length)
            return count;
        else if (sum != 0 && i == S.length)
            return 0;
        else
            return max(getLargestSubSet(S, sum + S[i], i + 1, count + 1), getLargestSubSet(S, sum, i + 1, count));
    }

    // Iterative dumb solution O(n2)
    public int getLargestSumSetIterative(Integer[] S, int dummy1, int dummy2, int dummy3) {
        int[] arr = new int[S.length];
        arr[0] = (S[0] == 0 ? 1 : 0);
        for (int i = 0; i < S.length; i++) {
            int sum = 0;
            int count = 0;
            int global_count = 0;
            for (int j = i; j >= 0; j--) {
                sum += S[j];
                count++;
                global_count = (sum == 0 && count > global_count) ? count : global_count;
            }
            arr[i] = global_count;
        }
        return getMaxFromArray(arr);
    }

    // Basic idea is if a sum appears twice then the middle array is a zero sum
    // array.
    // We will store the indexes of them in a hash map keyed by the sum
    // Later on we can iterate over keys of the hash to fetch the pair having
    // the max diff
    // If 0 appears as key in the hashmap then it means the index of 0 has sum
    // adding to 0
    // O(n)
    public int getLargestSumSetSmart(Integer[] S, int dummy1, int dummy2, int dummy3) {
        Map<Integer, Pair> map = new HashMap<>();
        Integer sum = 0;
        // O(n) here
        for (int i = 0; i < S.length; i++) {
            sum += S[i];
            Pair p = new Pair();
            if (map.get(sum) != null) {
                p.first = map.get(sum).first;
                p.second = i;
                map.put(sum, p);
            } else {
                p.first = i;
                p.second = -1;
                map.put(sum, p);
            }
        }
        int cand1 = 0, cand2 = 0;
        if (map.get(0) != null) {
            // Plus 1 because indexes are from 0
            cand1 = map.get(0).first + 1;
        }
        // O(n) here
        for (Entry<Integer, Pair> e : map.entrySet()) {
            cand2 = (e.getValue().getDiff() > cand2) ? e.getValue().getDiff() : cand2;
        }
        return max(cand1, cand2);
    }

    private int getMaxFromArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

}
