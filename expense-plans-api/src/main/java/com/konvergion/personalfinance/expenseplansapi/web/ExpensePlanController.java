package com.konvergion.personalfinance.expenseplansapi.web;

import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.service.IExpensePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ExpensePlanController {

    @Autowired
    private IExpensePlanService expensePlanService;

    @PostMapping
    public ResponseEntity<String> addExpensePlan(@RequestBody ExpensePlanItemDTO itemDTO){
        expensePlanService.addExpensePlan(itemDTO);
        return ResponseEntity.ok("An expense plan was added");
    }
}
