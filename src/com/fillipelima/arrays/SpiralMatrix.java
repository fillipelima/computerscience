package com.fillipelima.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	 public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> path = new ArrayList<Integer>();
	        
	        // limits
	        int rL = matrix[0].length;
	        int dL = matrix.length;
	        int lL = 0;
	        int uL = 0;
	        
	        // row, column
	        int r = 0;
	        int c = 0;    
	        
	        int total = matrix.length*matrix[0].length;
	        while (path.size() < total) {
	            
	            // right
	            while (c < rL && path.size() < total) {
	                path.add(matrix[r][c]);
	                c++;
	            }
	            // Fix column
	            c--;
	            // Go to next row
	            r++;
	            // Upate up limit
	            uL++; 
	            
	            
	            // down
	            while (r < dL && path.size() < total) {
	                path.add(matrix[r][c]);
	                r++;
	            }
	            // Fix row
	            r--;
	            // Go to next column backwards
	            c--;
	            // Update right limit
	            rL--;
	            
	            
	            // left
	            while (c >= lL && path.size() < total) {
	                path.add(matrix[r][c]);
	                c--;
	            }
	            // Fix column
	            c++;
	            // Go to next row up
	            r--;
	            // Update down limit            
	            dL--;
	            
	            // up
	            while (r >= uL && path.size() < total) {
	                path.add(matrix[r][c]);
	                r--;
	            }
	            // Fix row
	            r++;
	            // Go to next column right
	            c++;
	            // Update left limit
	            lL++;
	            
	        }
	        
	        return path;
	    }
}
