package Lesson11;

import java.util.Stack;

//Написать функцию, которая проверяет сбалансированность скобок трех видов.
// Пример "{}()" -> true, "{()[]}" -> true, "[}" -> false, "{{{])" -> false
// Подумайте, какие из пройденных контейнеров можно использовать - Stack, Queue, Deque
public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(checkParentheses("{()()[[()]()]}")); // t


    }

    public static boolean checkParentheses(String s)
    {
        Stack<Character> chars = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
                chars.push(c);
            else if (
                    c == ')' && chars.peek() == '(' ||  // проверка без удаления
                            c == ']' && chars.peek() == '[' ||
                            c == '}' && chars.peek() == '{'
            )
            {
                chars.pop();
            }
        }
        return chars.size() == 0;

    }

}
