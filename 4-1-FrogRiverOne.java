/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)
	A small frog wants to get to the other side of a river. The frog is initially located on one bank of 
	the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree 
	onto the surface of the river.

	You are given an array A consisting of N integers representing the falling leaves. A[K] represents the
	position where one leaf falls at time K, measured in seconds.

	The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can 
	cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the 
	earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of 
	the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

	For example, you are given integer X = 5 and array A such that:
	  A[0] = 1
	  A[1] = 3
	  A[2] = 1
	  A[3] = 4
	  A[4] = 2
	  A[5] = 3
	  A[6] = 5
	  A[7] = 4
	  
	In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

	Write a function:
	class Solution { public int solution(int X, int[] A); }
	that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when 
	the frog can jump to the other side of the river.

	If the frog is never able to jump to the other side of the river, the function should return −1.

	For example, given X = 5 and array A such that:
	  A[0] = 1
	  A[1] = 3
	  A[2] = 1
	  A[3] = 4
	  A[4] = 2
	  A[5] = 3
	  A[6] = 5
	  A[7] = 4
	the function should return 6, as explained above.

	Write an efficient algorithm for the following assumptions:
		N and X are integers within the range [1..100,000];
		each element of array A is an integer within the range [1..X].
*/

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int result = -1;
        HashSet<Integer> setFullPath = generatePathToX(X);
        
        // this set is going to contain the position in which 
        // already fall a leave.
        HashSet<Integer> setFallLeaves = new HashSet<Integer>();
    
		/*Comienza en 0 el valor de i, porque aunque la rana esta en la posición 0, 
		es la posición de otro array no del de los tiempos porq el planteo de solución 
		dice tengo que identificar el momento desde en el cual ya cayó al menos una hoja 
		en cada posición desde 1(porque la rana esta en cero)  hasta X inclusive 
		(porque quiere llegar a X + 1)		*/
        for(int i = 0; i < A.length; i++){
            setFallLeaves.add(A[i]);
            if(setFullPath.equals(setFallLeaves)){
                // the full path from 0 to X is completed with a leave in each position
                result = i;
                break;
            }
        }
        return result;
    }
    
    
    // genera un set con elementos enteros entre 1 y x (inclusive)
    public HashSet<Integer> generatePathToX(int x){
        HashSet<Integer> result = new HashSet<Integer>();
        
        for(int i = 1; i <= x; i ++){
            result.add(i);
        }
        
        return result;
        
    }
}

/*
TEST CASES

(5, [3]) the solution returned a wrong answer (got 1 expected -1)
(1, [1]) the solution returned a wrong answer (got -1 expected 0)
*/