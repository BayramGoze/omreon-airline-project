package com.bayramgoze.services;

public class CreditCardUtils {
    public static String maskCreditCard(String cardNumber) {
        String normalized = cardNumber.replaceAll("[^\\d]", ""); // Boşluk ve ayraçları kaldır
        return normalized.replaceAll("\\d{4}(?=\\d{4})", "****"); // Sadece son 4 haneyi bırak
    }
}
