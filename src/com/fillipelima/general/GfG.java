package com.fillipelima.general;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class GfG
{
    int minEle;
    Stack<Integer> s;
    List<Integer> a;
    PriorityQueue<Integer> p = new PriorityQueue<>();
    public GfG() {
        minEle = Integer.MAX_VALUE;
        s = new Stack<>();
        
        String s = 
        		
        
    }

    /*returns min element from stack*/
    int getMin()
    {
        if (s.isEmpty())
            return -1;
	    return minEle; 
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if (s.isEmpty())
	        return -1;
	    int poped = s.pop();
	    
	    return poped; 
    }

    /*push element x into the stack*/
    void push(int x)
    {
        minEle = Math.min(minEle, x);
	    s.push(x);	
    }	
}
