/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)
	This is a demo task.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
	For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	Given A = [1, 2, 3], the function should return 4.
	Given A = [−1, −3], the function should return 1.
	
	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            set.add(A[i]);   
        }
        int i = 1;
        for (i = 1; i <= set.size(); i++){
            if(!set.contains(i)){
                return i;
            }
        }
        
        return i ;
    }
}