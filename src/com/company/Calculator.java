package com.company;

public class Calculator {
    String instance;
    String romanNumbers[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String arabicNumbers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String operatorsCalc[] = {"+", "-", "*", "/"};

    Calculator(String instance) {

        instance = instance.replace(" ","");
        delimical(instance);
    }
    public String delimical(String instance){
        for (String operator: operatorsCalc) {
            String[] num = instance.split(operator);
            System.out.println(operator);
            System.out.println(num);
        }
        return "num";
    }
}
