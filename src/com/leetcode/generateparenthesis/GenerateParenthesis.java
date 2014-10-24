package com.leetcode.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 10/23/14.
 */
public class GenerateParenthesis {

    public static void main(String[] strings) {

        GenerateParenthesis parenthesisList = new GenerateParenthesis();
        List<String> list = parenthesisList.generateParenthesis(3);
        for (String parenthesis : list) {
            System.out.println(parenthesis);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();

        if (n <= 0) {
            return list;
        }

        

        return list;
    }
}
