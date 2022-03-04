package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        find(result, nums, 0);
        return result;
    }
    private void find(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length-1) 
            result.add(Arrays.stream(nums).boxed().toList());
            
        for (int i = start; i < nums.length; i++) {
            int[] generatedPerm = generatePerm(nums, start, i);
            find(result, generatedPerm, start+1);
        }
    }
    private int[] generatePerm(int[] perm, int i, int j) {
        int[] generated = Arrays.copyOf(perm, perm.length);
        int aux = generated[i];
        generated[i] = generated[j];
        generated[j] = aux;
        return generated;
    }
}
