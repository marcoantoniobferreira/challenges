/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * I couldn't show a solution in a reasonable time
 */

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char character : s.toCharArray()){
            if(character == '(' || character == '{' || character == '['){
                stack.push(character);
            }else if(character == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(character == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(character == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
    
}
