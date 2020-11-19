package com.company.converter;

import java.util.HashMap;
import java.util.Map;

public class RomanToArabic {
    Map<Integer, String> romanNumbersConvert = new HashMap<>();

    public String RomanToArabic(int arabicNumber) {//RomanToArabic
        romanNumbersConvert.put(0, "0");
        romanNumbersConvert.put(1, "I");
        romanNumbersConvert.put(5, "V");
        romanNumbersConvert.put(10, "X");
        romanNumbersConvert.put(50, "L");
        romanNumbersConvert.put(100, "C");
        romanNumbersConvert.put(500, "D");
        romanNumbersConvert.put(1000, "M");

        String romanNumber;
        if (arabicNumber == 0) {
            return "0";
        }
        romanNumber = transform(arabicNumber);
        return romanNumber;
    }

    private String transform(Integer i) {
        String result = "";
        char[] masS = i.toString().toCharArray();
        for (int j = 0; j < masS.length; j++) {
            result += backCall(masS[j],masS.length-j-1);
        }
        return result;
    }

    public String backCall(char ch, int addZero){
        int i = Integer.parseInt(String.valueOf(ch));
        int maxZero = (int) Math.pow(10, addZero);
        String result = "";
        if (i > 0 && i < 4) {
            for (int j = 0; j < i; j++) {
                result += romanNumbersConvert.get(1*maxZero);
            }
        }
        if (i == 4) {
            result += romanNumbersConvert.get(1*maxZero) + romanNumbersConvert.get(5*maxZero);
        }
        if (i == 5) {
            result += romanNumbersConvert.get(5*maxZero);
        }
        if (i > 5 && i < 9) {
            result += romanNumbersConvert.get(5*maxZero);
            for (int j = 5; j < i; j++) {
                result += romanNumbersConvert.get(1*maxZero);
            }
        }
        if (i == 9) {
            result += romanNumbersConvert.get(1*maxZero) + romanNumbersConvert.get(10*maxZero);
        }
        if (i == 10) {
            result += romanNumbersConvert.get(10*maxZero);
        }
        return result;
    }
}
