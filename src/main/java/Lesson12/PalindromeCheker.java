package Lesson12;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheker {
    public static void main(String[] args) {
        //алла
        // а роза упала на лапу азора
    }
    public static boolean checkPalindrome(String p){
        Deque<Character> chars = new ArrayDeque<>();
        p = p.replaceAll(" ", "");
        for(Character c: p.toCharArray())
        {
            chars.add(c);
        }

        while (chars.size() > 1 ){
            if(!chars.removeFirst().equals(chars.removeLast()))
                return false;
        }
        return true;

    }
}
