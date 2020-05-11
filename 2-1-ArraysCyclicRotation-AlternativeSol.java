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

// <<< Alternative Solution: para hacerlo sin usar array copy, y en su lugar usar mi propio método que copia de un array a otro >>>

	import java.util.*;
	// positions availables are until iEndOrigin - 1 and iEndDest - 1.
    public  int[] copyArray(int[] origin, int iBeginOrigin, int iEndOrigin, int[] dest, int iBeginDes){
        // first it is checked that the destini has enought position availables to the end
        // System.out.println("Se compara " + (dest.length - iBeginDes) + " con " + (iEndOrigin - iBeginOrigin));
        // And both begin positions should be bigger or equal to 0.
        // And iEndOrigin must be smaller or equal to origin.length
        if((dest.length - iBeginDes >= iEndOrigin - iBeginOrigin) &&
           (iBeginOrigin >= 0 && iBeginDes >= 0) &&
           (iEndOrigin <= origin.length)){
            for(int i = iBeginOrigin; i < iEndOrigin; i++){
                dest[iBeginDes] = origin[i];
                iBeginDes++;
            }
            return dest;
        }else{
            return null;
        }
        
    }
    
    public static void printArray(int [] A){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + "\t");
        }
        System.out.println("\n");
    }

/*
TEST CASES

([3, 8, 9, 7, 6], 7)
([3, 8, 9, 7, 6], 12)
([3, 8, 9, 7, 6], 42)
([3, 8, 9, 7, 6], 5)
([3, 8, 9, 7, 6], 0)
([6], 0)
([6], 1)
([6], 2)
([], 1)
*/