/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/6-sorting/triangle/)
	An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
	A[P] + A[Q] > A[R],
	A[Q] + A[R] > A[P],
	A[R] + A[P] > A[Q].
	
	For example, consider array A such that:
	  A[0] = 10    A[1] = 2    A[2] = 5
	  A[3] = 1     A[4] = 8    A[5] = 20
	  
	Triplet (0, 2, 4) is triangular.

	Write a function:
		class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

	For example, given array A such that:
	  A[0] = 10    A[1] = 2    A[2] = 5
	  A[3] = 1     A[4] = 8    A[5] = 20
	  
	the function should return 1, as explained above. Given array A such that:
	  A[0] = 10    A[1] = 50    A[2] = 5
	  A[3] = 1
	the function should return 0.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..100,000];
		each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

// > > > ALTERNATIVE SOLUTION: This solution is implemented using 'double' instead of BigInteger


class Solution {
    public int solution(int[] A) {
        int response = 0;
        if (A.length > 2){
            Arrays.sort(A);
            boolean existTriangle = false;
            for(int i=0; i < A.length - 2; i++){
                if(isTrianguler(A[i], A[i+1], A[i+2])){
                    existTriangle = true;
                    response = 1;
                    break;
                }
            }
        }
        
        return response;
    }
    
    public boolean isTrianguler(int a, int b, int c){
        double A = a;
        double B = b;
        double C = c;
        
        if (A + B > C && 
            B + C > A && 
            C + A > B){
                return true;
        }else{
            return false;
        }
    }
}