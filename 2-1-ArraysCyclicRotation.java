/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/)
	An array A consisting of N integers is given. Rotation of the array means that each element is shifted right 
	by one index, and the last element of the array is moved to the first place. 
	For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted 
	right by one index and 6 is moved to the first place).
	
	The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

	Write a function:
	class Solution { public int[] solution(int[] A, int K); }
	that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

	For example, given
		A = [3, 8, 9, 7, 6]
		K = 3
	the function should return [9, 7, 6, 3, 8]. Three rotations were made:
		[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
		[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
		[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
		
	For another example, given
		A = [0, 0, 0]
		K = 1
	the function should return [0, 0, 0]

	Given
		A = [1, 2, 3, 4]
		K = 4
	the function should return [1, 2, 3, 4]

	Assume that:
	N and K are integers within the range [0..100];
	each element of array A is an integer within the range [−1,000..1,000].
	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/

import java.util.*;
class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int cantElem = A.length;
        
        if(cantElem == 0){
            return A;
        }
        
        // when K is bigger than A.length, mod function is 
        // apply for discaring unnecesary cycles 
        if(K > cantElem){
            K = (K % cantElem);
        }
        
        
        // Arrays.copyOfRange(oldArray, startIndex, endIndex);
        int [] arrayPart1 = Arrays.copyOfRange(A, cantElem - K, cantElem); 
        int [] arrayPart2 = Arrays.copyOfRange(A, 0, cantElem - K); 
        
        int[] result = new int[cantElem];

        System.arraycopy(arrayPart1, 0, result, 0, arrayPart1.length);
        System.arraycopy(arrayPart2, 0, result, arrayPart1.length, arrayPart2.length);
        
        return result;
    }
    
}