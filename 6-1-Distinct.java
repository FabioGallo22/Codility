/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/6-sorting/distinct/)
	Write a function
		class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns the number of distinct values in array A.

	For example, given array A consisting of six elements such that:
	 A[0] = 2    A[1] = 1    A[2] = 1
	 A[3] = 2    A[4] = 3    A[5] = 1
	the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..100,000];
		each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}