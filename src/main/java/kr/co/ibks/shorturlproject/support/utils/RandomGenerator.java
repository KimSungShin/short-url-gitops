package kr.co.ibks.shorturlproject.support.utils;

import java.util.Random;

public class RandomGenerator {

    public static String generate(int count) {
        String charArr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < count; i++) {
            Random rand = new Random();
            int index = rand.nextInt(62);
            res.append(charArr.charAt(index));
        }
        return res.toString();
    }

    public static String generateNumber(int count) {
        String charArr = "0123456789";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < count; i++) {
            Random rand = new Random();
            int index = rand.nextInt(10);
            res.append(charArr.charAt(index));
        }
        return res.toString();
    }

}
