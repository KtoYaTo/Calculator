package com.company.core;

import com.company.converter.RomanToArabic;
import com.company.exception.MathematicalException;
import com.company.impl.Arabic;
import com.company.impl.Operator;
import com.company.impl.Roman;
import com.company.transfer.Dial;

import java.util.Arrays;
import java.util.Objects;

public class Calculator implements Arabic, Roman, Operator {
    private String instance;
    private String operatorUsed; // null - not hava or more 1 operators, error. Another save operator one to String +-*/
    private Dial dial; // Save type Arabic or Roman calculation
    private int firstElement;
    private int secondElement;
    private int result;
    private String resultOut;

    /**
     * Calculator calculator = new Calculator("3/ 2 ");
     * calculator.getResult();
     * calculator.getOperatorUsed - what operator used now
     * calculator.getDial - what dial used now Arabic or Roman from enum Dial
     * <p>
     * Change instance and result:
     * calculator.setInstance("2*5");
     * calculator.calculation(true);
     * calculator.getResult();
     *
     * @see MathematicalException
     * @see com.company.impl.Arabic
     * @see com.company.impl.Operator
     * @see com.company.impl.Roman
     */
    public Calculator(String instance) throws MathematicalException {
        // Delete scpase
        setInstance(instance.replace(" ", ""));
        setResult(calculation(true));
    }

    public void testAll() throws MathematicalException {
        // First step get delimical in instance
        setOperatorUsed(delimical(getInstance()));
        if (getOperatorUsed() == null) {
            throw new MathematicalException("Error! To many operators! You must use only one from this operators: * / +  -");
        }
        if ((getDial(0) != getDial(1)) || dial == null) {
            throw new MathematicalException("Error! Dials not right!");
        }
    }

    public int calculation(boolean testAll) throws MathematicalException {
        testAll();
        switch (getOperatorUsed()) {
            case "*":
                setResult(getFirstElement() * getSecondElement());
                return getResult();
            case "+":
                setResult(getFirstElement() + getSecondElement());
                return getResult();
            case "-":
                setResult(getFirstElement() - getSecondElement());
                return getResult();
            case "/":
                setResult(getFirstElement() / getSecondElement());
                return getResult();
        }
        return 0;
    }

    @Override
    public String delimical(String instance) {
        String operatorUseded = null;
        for (String operator : operators) {
            String edit = instance.replaceAll("[" + operator + "]", "");
            int lengthDifferences = instance.length() - edit.length();
            if (lengthDifferences == 1) {
                if (operatorUseded == null) {
                    operatorUseded = operator;
                } else {
                    return null;
                }
            }
        }
        return operatorUseded;
    }

    public Dial getDial(int number) {
        int keyArabicNumbers = 0;
        int keyRomanNumbers = 0;
        String[] parts = instance.split("[" + getOperatorUsed() + "]");
        keyArabicNumbers = Arrays.asList(arabicNumbers).indexOf(parts[number]);// if -1 then not find
        keyRomanNumbers = Arrays.asList(romanNumbers).indexOf(parts[number]); // if -1 then not find
        if (keyArabicNumbers >= 0) {
            keyArabicNumbers++;
            setDial(Dial.ARABIC);
            if (number == 0) setFirstElement(keyArabicNumbers);
            if (number == 1) setSecondElement(keyArabicNumbers);
            return Dial.ARABIC;
        }
        if (keyRomanNumbers >= 0) {
            setDial(Dial.ROMAN);
            keyRomanNumbers++;
            if (number == 0) setFirstElement(keyRomanNumbers);
            if (number == 1) setSecondElement(keyRomanNumbers);
            return Dial.ROMAN;
        }
        return null;
    }

    public void setFirstElement(int firstElement) {
        this.firstElement = firstElement;
    }

    public int getFirstElement() {
        return firstElement;
    }

    public void setSecondElement(int secondElement) {
        this.secondElement = secondElement;
    }

    public int getSecondElement() {
        return secondElement;
    }

    public void setDial(Dial dial) {
        this.dial = dial;
    }

    public Dial getDial() {
        return dial;
    }

    public void setOperatorUsed(String operatorUsed) {
        this.operatorUsed = operatorUsed;
    }

    public String getOperatorUsed() {
        return operatorUsed;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance.replace(" ", "");
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public String getResultOut() {
        if (getDial() == Dial.ROMAN) {
            RomanToArabic romanToArabic = new RomanToArabic();
            resultOut = romanToArabic.RomanToArabic(this.result);
        } else {
            resultOut = Integer.toString(this.result);
        }
        return resultOut;
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
