/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/8-leader/equi_leader/)
	A non-empty array A consisting of N integers is given.
	The leader of this array is the value that occurs in more than half of the elements of A.
	An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and 
	A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

	For example, given array A such that:
		A[0] = 4
		A[1] = 3
		A[2] = 4
		A[3] = 4
		A[4] = 4
		A[5] = 2
	we can find two equi leaders:
		0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
		2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
	The goal is to count the number of equi leaders.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

	For example, given:
		A[0] = 4
		A[1] = 3
		A[2] = 4
		A[3] = 4
		A[4] = 4
		A[5] = 2
	the function should return 2, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
*/

import java.util.*;

// Equi Leader es un índice que separa al array en dos tal que ambas mitades tienen el mismo leader
// Hay que devolver la cantidad de equiLeader del arreglo
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int [] leader = getAmountLeaderAndValue(A);
		
		// se pregunta si hay un lider de array completo
        if(leader[1] != -1){
            int cantLeaderInFirstBlock = 0;
            int leaderValue= leader[0] ;
            int cantLeaderTotal = leader[1];
            
            for(int i = 0; i < A.length - 1; i++){
                // First block is evaluated
                if (A[i] == leaderValue){
                    cantLeaderInFirstBlock ++;
                }
                if (cantLeaderInFirstBlock > ((i + 1) / 2)){
                    // it is leader in the first block
                    // then it is evaluated in second block
                    // Second block is evaluated
                    
                    if(cantLeaderTotal - cantLeaderInFirstBlock > ((A.length - i - 1) / 2)){
                        result ++;
                    }
                }
            }
        }
        
        return result;
    }
       
    
    // return an array of two element
    // arr[0] leader value
    // arr[1] amount
    // return [-1,-1] if there is no leader
    public int[] getAmountLeaderAndValue(int[] A) {
        HashMap<Integer,Integer[]> map = new HashMap<Integer,Integer[]>();
        
        int [] result = {-1, -1};
        
        for (int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                Integer [] arr = map.get(A[i]);
                arr[1] += 1;
            }else{
                Integer [] aux = {i, 1};
                map.put(A[i], aux);
            }
            
        }
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
            result[0] = A[maxIndex];  // leader valus
            result[1] = maxValue;  // amount
        }
        
        return result;
    }
}