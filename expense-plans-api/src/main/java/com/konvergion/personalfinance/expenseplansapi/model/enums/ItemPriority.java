package com.konvergion.personalfinance.expenseplansapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemPriority {
    VERY_HIGH(1, "VERY HIGH"),
    HIGH(2, "HIGH"),
    MEDIUM(3, "MEDIUM"),
    LOW(4, "LOW"),
    VERY_LOW(5, "VERY LOW");

    private int priorityId;
    private String displayValue;
}
