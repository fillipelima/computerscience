package com.fillipelima.strings;

class LicenseKeyFormatting {
	
	// Iterative - 232ms 9,80%
    public String bruteForce(String s, int k) {
        String result = "";
        int runningCount = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            runningCount++;
            result = String.valueOf(s.charAt(i)).toUpperCase() + result;
            // If batch size equals k, put a dash in front of it
            if (runningCount == k && i != 0) {                                
                 result = "-" + result;                
                 runningCount = 0;                                                
            }
        }
        if (result.length() > 0 && result.charAt(0) == '-')
            result = result.replaceFirst("-", "");
        return result;
    }
    
    // Recursive - Memory Limit Exceeded
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("\\-", "");
        return build(s.toUpperCase(), k);
    }
    // Recursive function
    private String build(String s, int k) {
        if (s.length() <= k)
            return s;
        return build(s.substring(0, s.length() - k), k)  + "-" + s.substring(s.length() - k);
    }    
    
    // With StringBuilder - Faster   
    public String sb(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }     
}
