package com.company;

import com.company.core.Calculator;
import com.company.exception.MathematicalException;

import java.util.Scanner;

/**
 * Calculator Arabic and Roman instance
 * Work from 1...10 and I to X
 * Operators: + - * /
 * @author Gavrilov Vasily
 * phoine +79994000009
 */
public class Main {
    public static void main(String[] args) throws MathematicalException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input:");
            String num = in.next();
            Calculator calculator = new Calculator(num);
            System.out.println("Output:");
            System.out.println(calculator.getResultOut());
        }
    }
}
