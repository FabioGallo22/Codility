/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)
	A string S consisting of N characters is called properly nested if:
		S is empty;
		S has the form "(U)" where U is a properly nested string;
		S has the form "VW" where V and W are properly nested strings.
		
	For example, string "(()(())())" is properly nested but string "())" isn't.

	Write a function:
		class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

	For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..1,000,000];
		string S consists only of the characters "(" and/or ")".
*/

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int result = 1;
        int cantOpenPar = 0;
        for (int i = 0; i < S.length(); i++){
            String oneCharacter = S.substring(i, i+1);
            if(oneCharacter.equals("(")){
                cantOpenPar++;
            }else{
                cantOpenPar--;
                if(cantOpenPar < 0){
                    result = 0;
                    break;
                }
            }
        }
        
        if (cantOpenPar != 0){
            result = 0;
        }
        
        return result;
    }
}