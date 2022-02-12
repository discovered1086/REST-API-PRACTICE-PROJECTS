package com.konvergion.personalfinance.expenseplansapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExpenseStatus {
    NOT_SPENT(1, "NOT SPENT"),
    NOT_PURCHASED(2, "NOT PURCHASED"),
    PURCHASED(3, "PURCHASED"),
    SPENT(4, "SPENT"),
    PARTIALLY_PURCHASED(5, "PARTIALLY PURCHASED"),
    PARTIALLY_SPENT(6, "PARTIALLY SPENT");

    private int statusId;
    private String displayValue;
}
