/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)
	Write a function:
	class Solution { public int solution(int A, int B, int K); }
	that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
	{ i : A ≤ i ≤ B, i mod K = 0 }

	For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three 
	numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

	Write an efficient algorithm for the following assumptions:
		A and B are integers within the range [0..2,000,000,000];
		K is an integer within the range [1..2,000,000,000];
		A ≤ B.
*/


class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int result = 0;
        if(K <= B){
            int firstMultFromA = A;
            boolean foundMult = false;
            for (firstMultFromA = A; firstMultFromA <= B; firstMultFromA++){
                if(firstMultFromA % K == 0){
                    foundMult = true;
                    break;   
                }
            }
            if(foundMult){
                result = ((B - firstMultFromA) / K) + 1;
            }
            
        }else{
			if(B == 0){
				result ++;
			}
		}
        return result;
    }
}
	
/* 
TEST CASES

[10, 10, 5]
[10, 10, 10]
[10, 10, 7]
[10, 10, 12]
*/