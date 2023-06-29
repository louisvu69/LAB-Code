/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;

/**
 *
 * @author Theobromine
 */
public class StringUtils {

    private static HashMap<String, Integer> counting(String[] words) {
        HashMap<String, Integer> ret = new HashMap<>();
        for (String w : words) {
            Integer count = ret.get(w);
            ret.put(w, count == null ? 1 : count + 1);
        }
        return ret;
    }

    public static HashMap<String, Integer> countWord(String input) {
        String mergeWord = input.replaceAll("\\s+", " ").trim(); // replace all whitesapce characters that is far away with " ".
        String[] wordArray = mergeWord.split("\\s"); // split any number of whitespace characters
        return counting(wordArray);
    }

    public static HashMap<String, Integer> countChar(String input) {
        String[] s = input.replaceAll("\\s+", "").trim().split("");
        return counting(s);
    }
}
