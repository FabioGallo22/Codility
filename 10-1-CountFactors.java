/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/)
	A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
	For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
	Write a function:
		class Solution { public int solution(int N); }
	that, given a positive integer N, returns the number of its factors.
	For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

	Write an efficient algorithm for the following assumptions:
	N is an integer within the range [1..2,147,483,647].
*/

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int cantFactor = 1;
        for(int f = 2; f <= N/2; f++){
            if(N % f == 0){
                cantFactor++;
            }
        }
        if(N > 1){
            cantFactor++; // its is N considerar as it own factor
        }
        return cantFactor;
    }