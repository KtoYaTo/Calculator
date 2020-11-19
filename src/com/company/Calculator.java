package com.company;

import com.company.exception.MathematicalException;
import com.company.impl.Arabic;
import com.company.impl.Operator;
import com.company.impl.Roman;
import com.company.transfer.Dial;

import java.util.Arrays;

public class Calculator implements Arabic, Roman, Operator {
    private String instance;
    private String operatorUsed; // null - not hava or more 1 operators, error. Another save operator one to String +-*/
    private Dial dial; // Save type Arabic or Roman calculation
    private int firstElement;
    private int secondElement;
    private int result;

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
        if (getDial() == Dial.ROMAN) {

        }
    }

    public int calculation(boolean testAll) throws MathematicalException {
        /**
         * Start for all construction, first go testAll anc other
         */
        if (testAll) testAll();
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
        String[] parts = instance.split("[" + getOperatorUsed() + "]");
        if (Arrays.asList(arabicNumbers).contains(parts[number])) {
            setDial(Dial.ARABIC);
            if (number == 0) setFirstElement(Integer.parseInt(parts[number]));
            if (number == 1) setSecondElement(Integer.parseInt(parts[number]));
        }
        if (Arrays.asList(romanNumbers).contains(parts[number])) {
            setDial(Dial.ROMAN);
            if (number == 0) setFirstElement(Integer.parseInt(parts[number]));
            if (number == 1) setSecondElement(Integer.parseInt(parts[number]));
        }
        return getDial();
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
}
