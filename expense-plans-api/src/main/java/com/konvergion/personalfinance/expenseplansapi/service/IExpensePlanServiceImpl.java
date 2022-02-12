package com.konvergion.personalfinance.expenseplansapi.service;


import com.konvergion.personalfinance.expenseplansapi.model.beanmapping.ExpensePlanBeanMapper;
import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpensePlanItemEntity;
import com.konvergion.personalfinance.expenseplansapi.model.repository.ExpensePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IExpensePlanServiceImpl implements IExpensePlanService {

    private final ExpensePlanRepository expensePlanRepository;

    private final ExpensePlanBeanMapper expensePlanBeanMapper;

    @Autowired
    public IExpensePlanServiceImpl(ExpensePlanRepository expensePlanRepository, ExpensePlanBeanMapper expensePlanBeanMapper) {
        this.expensePlanRepository = expensePlanRepository;
        this.expensePlanBeanMapper = expensePlanBeanMapper;
    }

    @Override
    public ExpensePlanItemDTO addExpensePlan(ExpensePlanItemDTO expensePlanItemDTO) {
        final ExpensePlanItemEntity expensePlanItemEntity = expensePlanBeanMapper.convertDtoToEntity(expensePlanItemDTO);
        expensePlanRepository.save(expensePlanItemEntity);
        return expensePlanBeanMapper.convertEntityToDto(expensePlanItemEntity);
    }

    @Override
    public void deleteExpensePlanItem(String itemId) {
        expensePlanRepository.deleteById(itemId);
    }

    @Override
    public List<ExpensePlanItemDTO> getAllExpensePlanItems() {
        final var allExpensePlanItems = expensePlanRepository.findAll();
        return allExpensePlanItems.stream().map(expensePlanBeanMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpensePlanItemDTO getSingleExpensePlanItem(String planItemId) {
        return expensePlanRepository.findById(planItemId)
                .map(expensePlanBeanMapper::convertEntityToDto)
                .orElse(new ExpensePlanItemDTO());
    }
}
