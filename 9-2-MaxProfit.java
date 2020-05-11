/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/)
	An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].

	For example, consider the following array A consisting of six elements such that:
	  A[0] = 23171
	  A[1] = 21011
	  A[2] = 21123
	  A[3] = 21366
	  A[4] = 21013
	  A[5] = 21367
	If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

	Write a function,
		class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.

	For example, given array A consisting of six elements such that:
	  A[0] = 23171
	  A[1] = 21011
	  A[2] = 21123
	  A[3] = 21366
	  A[4] = 21013
	  A[5] = 21367
	the function should return 356, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..400,000];
		each element of array A is an integer within the range [0..200,000].
*/


class Solution {
    public int solution(int[] A) {
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
  
        // this allows our loop to keep iterating the buying
        // price until a cheap stock price is found
        boolean changeBuyIndex = true;
          
        // loop through list of stock prices once
        for (int i = 0; i < A.length-1; i++) {
            
            // selling price is the next element in list
            sellPrice = A[i+1]; 
            
            // if we have not found a suitable cheap buying price yet
            // we set the buying price equal to the current element
            if (changeBuyIndex) { 
                buyPrice = A[i]; 
            }
            
            // if the selling price is less than the buying price
            // we know we cannot make a profit so we continue to the 
            // next element in the list which will be the new buying price
            if (sellPrice < buyPrice) {
              changeBuyIndex = true; 
            }
            
            // if the selling price is greater than the buying price
            // we check to see if these two indices give us a better 
            // profit then what we currently have
            else { 
              int tempProfit = sellPrice - buyPrice;
              if (tempProfit > maxProfit) { 
                  maxProfit = tempProfit;
              }
              changeBuyIndex = false;
            }
        
        }
        return maxProfit;
    }
}