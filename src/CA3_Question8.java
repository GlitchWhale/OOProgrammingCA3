import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 8 Arithmetic Expression Calculator (Stack)
 * Implement a calculator to evaluate arithmetic expressions for the operators + - * / and
 * parenthesis ( ). See the accompanying PDF document which is an extract from a book
 * explaining the algorithm
 */
public class CA3_Question8 {
    /*
    evaluates the top of the stack
     */
    public static void evaluate(Stack<Integer> numbers, Stack<Character> operators) {
        //variables
        int num1, num2, result;
        char operator;
        //pop the top of the stack
        num2 = numbers.pop();
        num1 = numbers.pop();
        operator = operators.pop();
        //evaluate the top of the stack
        result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> num1 / num2;
        };
        //push the result to the stack
        numbers.push(result);
    }

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        //variables
        String equation;
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Scanner in = new Scanner(System.in);

        //ask the user to enter an equation
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();

        //while the calculation is not done
        while (!equation.isEmpty()) {
                //if a number is read, push it on the number stack
                if (Character.isDigit(equation.charAt(0))) {
                    numbers.push(Integer.parseInt(equation.substring(0, 1)));
                    equation = equation.substring(1).trim();
                }
                //if an operator is read, push it on the operator stack
                else if (equation.charAt(0) == '(' || equation.charAt(0) == '+' || equation.charAt(0) == '-' || equation.charAt(0) == '*' || equation.charAt(0) == '/') {
                    operators.push(equation.charAt(0));
                    equation = equation.substring(1).trim();
                }
                //if a closing parenthesis is read, evaluate the top of the stack
                else if (equation.charAt(0) == ')') {
                    //evaluate the top of the stack until you reach the opening parenthesis
                    while (operators.peek() != '(') {
                        evaluate(numbers, operators);
                    }
                    //pop the opening parenthesis
                    operators.pop();
                    equation = equation.substring(1).trim();
                }
        }
        //evaluate the top of the stack until the stack is empty
        while (!operators.isEmpty()) {
            evaluate(numbers, operators);
        }
        System.out.println(numbers.pop());
    }
}
