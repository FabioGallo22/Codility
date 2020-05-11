/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/8-leader/dominator/)
	An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

	For example, consider array A such that
	 A[0] = 3    A[1] = 4    A[2] =  3
	 A[3] = 2    A[4] = 3    A[5] = -1
	 A[6] = 3    A[7] = 3
	The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

	Write a function
		class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

	For example, given array A such that
	 A[0] = 3    A[1] = 4    A[2] =  3
	 A[3] = 2    A[4] = 3    A[5] = -1
	 A[6] = 3    A[7] = 3
	the function may return 0, 2, 4, 6 or 7, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..100,000];
		each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

import  java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer,Integer[]> map = new HashMap<Integer,Integer[]>();
		// map contains < value, [a,b]>
		// where a: contains the index of the fist index that contains value,
		//       b: contains the times that 'value' is in the array A.
        
        int result = -1;
        
        for (int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
				// it is not the first time that see this element, 
				// so its amount is +1.
                Integer [] arr = map.get(A[i]);
                arr[1] += 1; // position arr[0] is not modified because only is considered the firts time that found the element A[i];
            }else{
				// It is the first time that found element A[i] in the array.
                Integer [] aux = {i, 1};
                map.put(A[i], aux);
            }
            
        }
		// there could be only one leader, so it is needed to cound the number with bigger occurrence
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(Map.Entry<Integer,Integer[]> entry : map.entrySet()){
            int cant = entry.getValue()[1];    
            if(cant > maxValue){
                maxValue = cant;
                maxIndex = entry.getValue()[0];
            }
            // System.out.println("Clave: " + entry.getKey() + "\t cant: " + cant);
        }
        
        if(maxValue > A.length / 2){
            result = maxIndex;
        }
        
        return result;
    }
}