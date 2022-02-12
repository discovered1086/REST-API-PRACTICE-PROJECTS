package com.konvergion.personalfinance.expenseplansapi.model.beanmapping;


import com.konvergion.personalfinance.expenseplansapi.model.dto.ExpensePlanItemDTO;
import com.konvergion.personalfinance.expenseplansapi.model.entities.ExpensePlanItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpensePlanBeanMapper {

    ExpensePlanItemEntity convertDtoToEntity(ExpensePlanItemDTO expensePlanItemDTO);

    ExpensePlanItemDTO convertEntityToDto(ExpensePlanItemEntity expensePlanItemEntity);
}
