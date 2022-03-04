package com.fillipelima.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
    public List<String> findPermutation(String S) {
        List<String> list = new ArrayList<String>();
        find(S, list, 0, S.length()-1);
        return list;
    }
    private void find(String s, List<String> list, int start, int end) {
        if (start == end) {
           list.add(s);    
        }else{
            for (int i = start; i <= end; i++) {
                String swapped = swap(s, start, i);
                find(swapped, list, start+1, end);
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
