/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/)
	Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
	You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
	You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
	More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
	You stop eating when you encounter an empty wrapper.
	For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
	The goal is to count the number of chocolates that you will eat, following the above rules.

	Write a function:
		class Solution { public int solution(int N, int M); }
	that, given two positive integers N and M, returns the number of chocolates that you will eat.
	For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
	
	Write an efficient algorithm for the following assumptions:
		N and M are integers within the range [1..1,000,000,000].
*/

class Solution {
    public int solution(int N, int M) {
        // write your code in Java SE 8
        
        int gcdValue = gcd(N, M, 1);
        
        if(gcdValue > 1){
            return (N / gcdValue);
        }else{
            // there is no Greatest Common Divisor between N and M.
            // All Chocolates area eaten
            return N;
        }
    }
    
    // Given two numbers a and b (res = 1 first time it is call), returns the Greatest Common Divisor (GCD)
    // If there is not GCD returns 1.
	// According to algorithm in this pdf https://codility.com/media/train/10-Gcd.pdf
    public int gcd(int a, int b, int res){
        if(a == b){
            return res * a;
        }else{
            if((a % 2 == 0) && (b % 2 == 0)){
                //System.out.println("pasa por aqui");
                return gcd(a / 2, b / 2, 2 * res);
            }else{
                if(a % 2 == 0){
                    return gcd(a / 2, b, res);
                }else{
                     if(b % 2 == 0){
                        return gcd(a, b / 2, res);
                    }else{
                        if(a > b){
                            return gcd(a - b, b, res);
                        }else{
                            return gcd(a, b - a, res);
                        }
                    }
                }
            }
        }
    }
}