package binarysearch;

import java.util.HashSet;

public class LeetCode804Solution {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                sb.append(codes[word.charAt(j)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(words));
    }
}
