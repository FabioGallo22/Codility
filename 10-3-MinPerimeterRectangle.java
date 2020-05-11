/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/)
	An integer N is given, representing the area of some rectangle.
	The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
	The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.
	
	For example, given integer N = 30, rectangles of area 30 are:
	(1, 30), with a perimeter of 62,
	(2, 15), with a perimeter of 34,
	(3, 10), with a perimeter of 26,
	(5, 6), with a perimeter of 22.
	
	Write a function:
		class Solution { public int solution(int N); }
	that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
	For example, given an integer N = 30, the function should return 22, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..1,000,000,000].
	
*/

import java.lang.*;
class Solution {
    public int solution(int N) {
        int A,B = 0;

        int minPerimeter = Integer.MAX_VALUE;

        if(N == 1){
            minPerimeter = 4;
        } else{       
            int limit = (int)Math.sqrt(N);// es clave q sea la raiz cuadrada para lograr 100% de performance
            for (A = 1; A <= limit; A ++){
                if (N % A == 0){
                    B = N / A;
                    if(B < A){
                        break;
                    }else{
                        //System.out.println("A: " + A + " B: " + B);
                        int perimeter = (A + B) * 2;
                        if(perimeter < minPerimeter){
                            minPerimeter = perimeter;
                        }
                    }
                }
            }
        }
        return minPerimeter;
    }
}