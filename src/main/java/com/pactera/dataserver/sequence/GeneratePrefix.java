package com.pactera.dataserver.sequence;

import java.util.Arrays;
import java.util.List;

/**
 * Prefix generation tool class
 *
 * @author Pactera WangShuai
 * @date 2020/07/10 14:00
 */
public class GeneratePrefix {

    static String singleLetter() {
        List<Character> charList = Arrays.asList('I', 'L', 'O');
        char result = (char) (Math.random() * 26 + 'A');
        if (charList.contains(result)) {
            return singleLetter();
        } else {
            return String.valueOf(result);
        }
    }

    /**
     * Confirm prefix strategy
     *
     * @author Pactera WangShuai
     * @date 2020/07/10 14:32
     */
    enum Strategy {
        /**
         * single letter strategy
         */
        singleLetter
    }

}
