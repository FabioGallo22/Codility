/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/)
	A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
	A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. 
	The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
	You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number 
	of semiprimes within specified ranges.

	Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

	For example, consider an integer N = 26 and arrays P, Q such that:
		P[0] = 1    Q[0] = 26
		P[1] = 4    Q[1] = 10
		P[2] = 16   Q[2] = 20
		
	The number of semiprimes within each of these ranges is as follows:
		(1, 26) is 10,
		(4, 10) is 4,
		(16, 20) is 0.
	
	Write a function:
		class Solution { public int[] solution(int N, int[] P, int[] Q); }
	that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

	For example, given an integer N = 26 and arrays P, Q such that:
		P[0] = 1    Q[0] = 26
		P[1] = 4    Q[1] = 10
		P[2] = 16   Q[2] = 20
	the function should return the values [10, 4, 0], as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [1..50,000];
		M is an integer within the range [1..30,000];
		each element of arrays P, Q is an integer within the range [1..N];
		P[i] ≤ Q[i].
*/

import java.util.*;
class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] result = new int [P.length];
        if (N >= 2){ 
            
			// contendrá todos primos multiplicados entre sí, 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, ...
            HashSet<Integer> primesSet = new HashSet<Integer>();
            
			// primesToN[] contendrá los número primos menores o iguales a N.
			// el valor de la posición i si es true, significa que i es primo, false caso contrario.
			// por ejemplo primesToN[5] = true porque 5 es primo, primesToN[6] = false porque 6 no es primo.
            boolean [] primesToN = generateNfirstPrimes(N);
			
            
            for(int i = 0; i < primesToN.length; i ++){
                if(primesToN[i]){
                    for(int k = i; k < primesToN.length; k++){
                        if(primesToN[k]){
                            primesSet.add(i * k);
                            //System.out.println("Se guarda en el set: " + i * k);
                        } 
                    }
                }
            }
            
            
            // At this momento we already have al the prime numbers needed and its dobles.
            // Semiprimes in (4,10) consider both 4 and 10, according to example.
            for(int i = 0; i < P.length; i++){
                int canPrimesThisQuery = 0;
                for(int k = P[i]; k <= Q[i]; k++){
                    if(primesSet.contains(k)){
                        canPrimesThisQuery++;
                    }
                }
                result[i] = canPrimesThisQuery;
            }
            
        }
        
        return result;
    }
       
	// genera un array 0..N posiciones, con true/false
	// la posición i = true indica que i es primo, si es false no es primo
    public boolean[] generateNfirstPrimes(int n){
        //System.out.println("Se generan los N " + n + " primeros primos");
        if(n >= 2){
            boolean[] result = new boolean[n+1];
            
            Arrays.fill(result, true);
            
            result[0] = false;
            result[1] = false;
            for(int i = 2; (i * i) <= n; i++){
                if(result[i]){
                    int k = i * i;
                    while(k <= n){
                        result[k] = false;
                        k = k + i;
                    }
                }
            }
            return result;
        
        }else{
            return null;
        }
    }
}