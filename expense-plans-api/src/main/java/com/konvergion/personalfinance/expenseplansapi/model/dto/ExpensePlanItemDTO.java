package com.konvergion.personalfinance.expenseplansapi.model.dto;


import com.konvergion.personalfinance.expenseplansapi.model.enums.ExpenseStatus;
import com.konvergion.personalfinance.expenseplansapi.model.enums.ItemPriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class ExpensePlanItemDTO {

    private String itemId;

    private String itemDescription;

    private String itemLinkUrl;

    private ItemPriority itemPriority;

    private LocalDate targetExpenseDate;

    private LocalDate actualPurchaseDate;

    private BigDecimal estimatedAmount;

    private BigDecimal actualAmount;

    private ExpenseStatus expenseStatus;
}
