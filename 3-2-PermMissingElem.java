/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/)
	An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
	Your goal is to find that missing element.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A, returns the value of the missing element.
	
	For example, given array A such that:
	  A[0] = 2
	  A[1] = 3
	  A[2] = 1
	  A[3] = 5
	  
	the function should return 4, as it is the missing element.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..100,000];
		the elements of A are all distinct;
		each element of array A is an integer within the range [1..(N + 1)].
*/

// <<< 100% correctitud, 60% porque falla para números grandes >>>
	
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        double n = A.length + 1;
        double total = (n*(n+1))/2;
        double sum = 0;
        for(int i = 0; i < (n - 1); i++){
            sum += A[i];
        }
        return (int)(total - sum);
    }
}