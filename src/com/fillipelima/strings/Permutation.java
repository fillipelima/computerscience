package com.fillipelima.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
    public List<String> findPermutation(String S) {
        List<String> list = new ArrayList<String>();
        find(S, list, 0, S.length()-1);
        return list;
    }
    private void find(String s, List<String> list, int i, int j) {
         if (i == j) {
            list.add(s);    
         }else{
             for (int k = i; k <= j; k++) {
                 String swapped = swap(s, i, k);
                 find(swapped, list, i+1, j);
             }    
         } 
    }
    private String swap(String s, int i, int j) {
        char[] a = s.toCharArray();
        char aux =  a[i];
        a[i] = a[j];
        a[j] = aux;
        return String.valueOf(a);
    }
}
