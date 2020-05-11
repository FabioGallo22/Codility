/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/)
	A non-empty array A consisting of N integers is given.
	A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
	The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

	For example, array A such that:
		A[0] = 3
		A[1] = 2
		A[2] = 6
		A[3] = -1
		A[4] = 4
		A[5] = 5
		A[6] = -1
		A[7] = 2
	contains the following example double slices:
		double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
		double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
		double slice (3, 4, 5), sum is 0.
		
	The goal is to find the maximal sum of any double slice.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

	For example, given:
		A[0] = 3
		A[1] = 2
		A[2] = 6
		A[3] = -1
		A[4] = 4
		A[5] = 5
		A[6] = -1
		A[7] = 2
	the function should return 17, because no double slice of array A has a sum of greater than 17.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [3..100,000];
		each element of array A is an integer within the range [−10,000..10,000].
*/

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int max = 0; // comienza en cero porque en el peor de los casos debería ser cero //Integer.MIN_VALUE;
        
		// se genera un ciclo para generar los distintos índices a excluir, 
		// que no puede ser ni el primer ni último porque asi lo especifica la definición del 
		// problema A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
		// Se evalúa cual es el mayor valor posible dado que se excluyeron los distintos índices.
        for(int i = 1; i < A.length - 1; i++){
            int maxWitoutIndex = getMaxSumExcludingOne(A, i);
            //System.out.println("Max sin la posicion " + i + ": " + maxWitoutIndex);
            if(maxWitoutIndex > max){
                max = maxWitoutIndex;
            }
        }
        
        return max;
    }
    
    // calcula el máximo valor sumado de una slice exceptuando un determina indice
	// y siempre sin considerar el primer y último elemento del array A.
    public int getMaxSumExcludingOne(int[] A, int indexToExclude) {
        // write your code in Java SE 8
        
        int size = A.length; 
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0; 
  
		// se excluye el primer y el último elemento porque el ejemplo muestra que 
		// double slice (0, 3, 6)  es la suma de A[1] + A[2] + A[4] + A[5]
        for (int i = 1; i < size-1; i++) 
        { 
            if(i != indexToExclude){
                maxEndingHere = maxEndingHere + A[i]; 
                if (maxSoFar < maxEndingHere) 
                    maxSoFar = maxEndingHere; 
                if (maxEndingHere < 0) 
                    maxEndingHere = 0; 
            }
        } 
        return maxSoFar; 
        
    }
}