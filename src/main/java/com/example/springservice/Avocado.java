package com.example.springservice;

import java.math.BigDecimal;

public record Avocado(
        String id,
        String color,
        BigDecimal purchasePrice
) {
}
