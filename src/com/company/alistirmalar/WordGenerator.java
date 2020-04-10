package com.company.alistirmalar;


import java.util.Map;

public class WordGenerator {

    public static void main(String[] args) {
        int count = 3;
        int sayac=0;
        String deger = "Selam";
        StringBuilder yeni = new StringBuilder("Merhaba");
        //System.out.println(wordGen(count));
        f(deger);
        k(yeni);
        System.out.println(deger);
        System.out.println(yeni);

    }
    public static String wordGen(int count) {
        String word = "";
        if (count > 0) {
            count--;
            for (char i = 'A'; i <= 'Z'; i++) {
                word += i + wordGen(count) + " ";
            }
        } else {
            for (char i = 'A'; i <= 'Z'; i++) {
                word += i;
            }
        }

        return word;
    }

    public static void f(String k){
        k += " Murat";
        //return k;
    }

    public static void k(StringBuilder k){
        k.append(" Murat");
        //return k;
    }
}