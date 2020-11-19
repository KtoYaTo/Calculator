package com.company;

import com.company.converter.RomanToArabic;
import com.company.exception.MathematicalException;

/**
 * Calculator Arabic and Roman instance
 * Work from 1...10 and I to X
 * Operators: + - * /
 * @author Gavrilov Vasily
 * phoine +79994000009
 */
public class Main {
    public static void main(String[] args) throws MathematicalException {
        Calculator calculator = new Calculator("8* 2 ");
        //System.out.println(calculator.getResult());
        RomanToArabic romanToArabic = new RomanToArabic();
        String result = romanToArabic.RomanToArabic(calculator.getResult());
        System.out.println(result);
    }
}
