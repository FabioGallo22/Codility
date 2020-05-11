/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/)
	A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

	For example, array A such that:
	  A[0] = -3
	  A[1] = 1
	  A[2] = 2
	  A[3] = -2
	  A[4] = 5
	  A[5] = 6
	  
	contains the following example triplets:
		(0, 1, 2), product is −3 * 1 * 2 = −6
		(1, 2, 4), product is 1 * 2 * 5 = 10
		(2, 4, 5), product is 2 * 5 * 6 = 60
	Your goal is to find the maximal product of any triplet.

	Write a function:
		class Solution { public int solution(int[] A); }
	that, given a non-empty array A, returns the value of the maximal product of any triplet.

	For example, given array A such that:
	  A[0] = -3
	  A[1] = 1
	  A[2] = 2
	  A[3] = -2
	  A[4] = 5
	  A[5] = 6
	the function should return 60, as the product of triplet (2, 4, 5) is maximal.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [3..100,000];
		each element of array A is an integer within the range [−1,000..1,000].
*/

import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int [] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, B.length); 
        Arrays.sort(B);
        
        // there only could be a pair of negatives values
        // if there is not enougth, then 
        // zero value must be avoid
        if(B[0] < 0 && B[1] < 0 && B[B.length - 1] > 0){
            // it is evaluated if 
            // [0]*[1] if bigger than [last-3]*[last-2]
            if (B[0] * B[1] > B[B.length-3] * B[B.length-2]){
                result = B[0] * B[1] * B[B.length - 1];
            }else{
                result =  B[B.length - 1] * B[B.length - 2] * B[B.length - 3];
            }
        }else{
            // they are all negatives OR there is only one negative value
            // then considere the last three numbers
            result = B[B.length - 1] * B[B.length - 2] * B[B.length - 3];
            
        }
        return result;
    }
}