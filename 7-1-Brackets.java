/*
Author: Fabio Gallo (fabiorafael22@gmail.com)
		LinkedIn: https://www.linkedin.com/in/fabio-rafael-gallo-46334044/

PROBLEM DESCRIPTION (Source: https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)
	A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
		S is empty;
		S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
		S has the form "VW" where V and W are properly nested strings.
		
	For example, the string "{[()()]}" is properly nested but "([)()]" is not.

	Write a function:
		class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

	For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

	Write an efficient algorithm for the following assumptions:
		N is an integer within the range [0..200,000];
		string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/


import java.util.Stack;
class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        
        int result = 1;
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < S.length(); i++){
            String caracter = S.substring(i,i+1);
            if (caracter.equals("(") || caracter.equals("[") || caracter.equals("{")){
                stack.push(caracter);  
            }else{
                if(!stack.empty()){
                    String popElem = stack.pop();
                    if (caracter.equals(")") && !popElem.equals("(")){
                        result = 0;
                        break;
                    }else{
                        if (caracter.equals("]") && !popElem.equals("[")){
                            result = 0;
                            break;
                        }else{
                            if (caracter.equals("}") && !popElem.equals("{")){
                                result = 0;
                                break;
                            }
                        }
                    }
                }else{
                    result = 0;
                    break;
                }
            }
        }
        
        // there could be a bracket missing
        if(!stack.empty()){
            result = 0;   
        }
        return result;
    }
}