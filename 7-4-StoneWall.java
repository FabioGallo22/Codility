/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/)
	You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; 
	however, it should have different heights in different places. The height of the wall is specified by an array H of N 
	positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular,
	H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

	The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). 
	Your task is to compute the minimum number of blocks needed to build the wall.

	Write a function:
		class Solution { public int solution(int[] H); }
	that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

	For example, given array H containing N = 9 integers:
	  H[0] = 8    H[1] = 8    H[2] = 5
	  H[3] = 7    H[4] = 9    H[5] = 8
	  H[6] = 7    H[7] = 4    H[8] = 8
	the function should return 7. The figure shows one possible arrangement of seven blocks.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..100,000];
		each element of array H is an integer within the range [1..1,000,000,000].
*/


import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        HashMap<Integer, Boolean> status = new HashMap<Integer, Boolean>();
        
        int cantBlocks = 0;
        
        for(int i = 0; i < H.length; i++){
            if(!status.containsKey(H[i])){
                status.put(H[i], false);
                cantBlocks++;
                //System.out.println("Se suma bloque en indice: " + i);
            }else{
                // antes existia el elemento
                
                // hay ver si es mayor o igual al anterior
                if(H[i] > H[i-1]){
                    cantBlocks++;
                    //System.out.println("Se suma bloque en indice: " + i);
                }else{
                    // si es la misma altura que el anterio no se hace nada
                    if(H[i] !=  H[i-1]){
                        if(status.get(H[i]) == true){
                            // desde la ultima vez que se encontró el elemento hubo uno más chico
                            // por lo tanto es necesario otro bloque
                            //System.out.println("Se suma bloque en indice: " + i + "  -- Status: " + status.get(H[i]));
                            cantBlocks ++;
                            // se actualiza su status
                            status.put(H[i], false);
                        }
                    }
                }
            }
            updateStatus(status, H[i]);
        }
        
        return cantBlocks;
    }
    
    
    public HashMap<Integer, Boolean> updateStatus(HashMap<Integer, Boolean> status, int key){
        // se pone de una a key:false; y todas aquellas kesy in status
        // que sean mayores a key se ponen en true
        
        // un elemento  key:true quiere decir que desde la ultima aparación de key se encontró un elemento menor
        
        status.put(key, false);
        for(Map.Entry<Integer,Boolean> entry : status.entrySet()){
            if(entry.getKey() > key){
                status.put(entry.getKey(), true);
                //System.out.println("Se modifica la clave: " + entry.getKey() + " dada la clave " + key);
            }
        }
        
        return status;
    }
}

/*
TEST CASES
[2, 5, 1, 4, 6, 7, 9, 10, 1]
[5,5,5,5,5,5]
[5,5,6,6,5,5]
[3,3,4,4,5,5,6,6]
[6,6,4,4,3,3]
[5,5,4,4,5,5]
*/