/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)
	A non-empty array A consisting of N integers is given.
	A permutation is a sequence containing each element from 1 to N once, and only once.

	For example, array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
		A[3] = 2
	is a permutation, but array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
	is not a permutation, because value 2 is missing.

	The goal is to check whether array A is a permutation.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

	For example, given array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
		A[3] = 2
	the function should return 1.

	Given array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
	the function should return 0.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [1..1,000,000,000].
*/

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        int length = A.length;
        int result = 0;
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += A[i];
            set.add(A[i]);
        }
        if (sum == (length*(length+1))/2
            && length == set.size()){
            result = 1;        
        }
        return result;
    }
}
