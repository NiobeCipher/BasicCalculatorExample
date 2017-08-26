package com.example.jettcalder.basiccalculatorexample;


/**
 * Created by jettc on 8/26/2017.
 */

public class KhmerNumber {
    private char[] khNumber = {'០', '១', '២', '៣', '៤', '៥', '៦', '៧', '៨', '៩'};

    public char getKhNum(int i) {
        return khNumber[i];
    }

    public int getEnNumber(char num) {
        for (int i = 0; i < khNumber.length; i++) {
            if (num == khNumber[i]) {
                return i;
            }
        }
        return -1;
    }

    public char getKhNumber(Double num) {
        char[] newNum = num.toString().toCharArray();
        for (int i = 0; i < newNum.length; i++) {
            if (newNum[i] >= 0 & newNum[i] <= 9) {
                if (newNum[i] == i) {
                    return khNumber[i];
                }
            } else if (newNum[i] == '.') {
                return '.';
            }
        }
        return 0;
    }

    public String parseEnNumber(String num) {
        String enNum = "";
        for (char ch : num.toCharArray()) {
            if (ch == '.') {
                enNum += '.';
            } else {
                enNum += getEnNumber(ch);
            }
        }
        return enNum;
    }

    public String parseKhNumber(Double num) {
        String khNum = "";
        char[] newNum = num.toString().toCharArray();
        for (int i = 0; i < newNum.length; i++) {
            int tmp = Character.getNumericValue(newNum[i]);
            if (tmp >= 0 & tmp <= 9) {
                khNum += getKhNum(tmp);
            } else if (newNum[i] == '.') {
                khNum += '.';
            }
        }
        return khNum;
    }

}

