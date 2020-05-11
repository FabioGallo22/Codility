/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/)
	A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
	A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 
	2 and 5 are prime divisors of 20.

	You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

	For example, given:
		N = 15 and M = 75, the prime divisors are the same: {3, 5};
		N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
		N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
	
	Write a function:
		class Solution { public int solution(int[] A, int[] B); }
	that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of 
	A[K] and B[K] are exactly the same.

	For example, given:
		A[0] = 15   B[0] = 75
		A[1] = 10   B[1] = 30
		A[2] = 3    B[2] = 5
	the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

	Write an efficient algorithm for the following assumptions:
		Z is an integer within the range [1..6,000];
		each element of arrays A, B is an integer within the range [1..2,147,483,647].
*/

 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int response = 0;
        
        for(int i = 0; i < A.length; i++){
            HashSet<Integer> setDivA = primeFactors(A[i]);
            HashSet<Integer> setDivB = primeFactors(B[i]);
            
            if(setDivA.equals(setDivB)){
                response ++;    
            }
        }  
        
        return response;
    }
    
    public void prt(String s){System.out.println(s);}
    
    public HashSet<Integer>  primeFactors(int n){ 
        HashSet<Integer> setResult = new HashSet<Integer>();
        // Determines if the number of 2  divides n 
        // And divides by 2 until it is odd
        while (n % 2 == 0) { 
            setResult.add(2);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            // While i divides n, add i to the set and divide n 
            while (n % i == 0) { 
                setResult.add(i);
                n /= i; 
            } 
        } 
  
        // This is to handle the case when 
        // n is a prime number greater than 2 
        if (n > 2){ 
            setResult.add(n);
        }
        return setResult;
    } 
}