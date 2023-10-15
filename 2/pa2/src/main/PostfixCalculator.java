/*
 * Name: Junseop Kim
 * Student ID: 2019134006
 */

public class PostfixCalculator implements IPostfixCalculator
{   
    // you may declare additional variables here.
    private Stack<Integer> stack;
    public PostfixCalculator()
    {
        // implement your constructor here.
        this.stack = new Stack<Integer>();

    }


    @Override
    public int evaluate(String exp)
    {
        /*
        * evaluate
        *
        * Evaluate the expression and return the result
        *
        * exp - String; the string representation of the postfix expression
        *
        * Note: We guarantee exp will always be a valid postfix expression of
        *       length >= 1. Only operators +, -, and * will be used and only
        *       non-negative integers will be used as terms. Terms and operators
        *       will be separated by spaces, for example "5 3 x". At no point in
        *       the evaluation will an intermediate value be large enough to
        *       overflow the Java int type. However, it can go below 0.
        */
        String[] token = exp.split(" ");
        for (String t : token){
            if(t.equals("+")){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 + operand1);
            }
            else if(t.equals("-")){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 - operand1);
            }
            else if(t.equals("x")){
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 * operand1);
            }
            else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}