package com.konvergion.personalfinance.expenseplansapi.model.entities;


import com.konvergion.personalfinance.expenseplansapi.model.enums.ExpenseStatus;
import com.konvergion.personalfinance.expenseplansapi.model.enums.ItemPriority;
import com.konvergion.personalfinance.expenseplansapi.model.sequencegenerators.CommonSequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
@Entity
@Table(name = "expense_plans")
public class ExpensePlanItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expensePlanSequenceGen")
    @GenericGenerator(name = "expensePlanSequenceGen", strategy = "com.konvergion.expenseplans.model.sequencegenerators.CommonSequenceGenerator", parameters = {
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = CommonSequenceGenerator.VALUE_PREFIX_PARAM, value = "PLNITM")})
    @Column(length = 20, name = "item_id", updatable = false, insertable = false)
    private String itemId;

    @Column(name = "item_description", length = 1000, nullable = false, unique = true)
    private String itemDescription;

    @Column(name = "item_url", length = 4000)
    private String itemLinkUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_priority", length = 100, nullable = false)
    private ItemPriority itemPriority;

    @Column(name = "target_expense_date", nullable = false)
    private LocalDate targetExpenseDate;

    @Column(name = "actual_expense_date")
    private LocalDate actualPurchaseDate;

    @Column(name = "estimated_amount", nullable = false)
    private BigDecimal estimatedAmount;

    @Column(name = "actual_amount")
    private BigDecimal actualAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_status", length = 100, nullable = false)
    private ExpenseStatus expenseStatus;
}
