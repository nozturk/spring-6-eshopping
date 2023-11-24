package dev.nozturk.eshopping.controller;


import org.springframework.util.Assert;

class Solution {
	public static void main(String[] args) {
		Assert.isTrue(isPalindrome(-12344321));
	}
    public static  boolean isPalindrome(int x) {
    	
    	 char[] num = String.valueOf(x).toCharArray();
        int lengthOfArray = num.length;
		for (int i = 0; i < lengthOfArray; i++) {
			if(num[i] != num[lengthOfArray-i-1]) {
				return false;
			}
	    }
        return true;
        
    }
    
    

    
}

