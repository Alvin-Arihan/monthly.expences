package com.rpy.monthly.expences.service.impl;

import com.rpy.monthly.expences.dto.Category;
import com.rpy.monthly.expences.dto.MonthlyItems;
import com.rpy.monthly.expences.dto.PurchaseItem;
import com.rpy.monthly.expences.entity.CategoryEntity;
import com.rpy.monthly.expences.repository.CategoryRepository;
import com.rpy.monthly.expences.repository.MonthlyExpensesRepository;
import com.rpy.monthly.expences.service.MonthlyExpensesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MonthlyExpensesServiceImpl implements MonthlyExpensesService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MonthlyExpensesRepository monthlyExpensesRepository;

    List<MonthlyItems> monthlyItemsList =new ArrayList<>();
    @Override
    public List<MonthlyItems> getAllItems() {
        Category category1=new Category(1,"Dairy");
        MonthlyItems monthlyItem1=new MonthlyItems(1,"Curd",category1);
        MonthlyItems monthlyItem2=new MonthlyItems(2,"Milk",category1);
        MonthlyItems monthlyItem3=new MonthlyItems(3,"Paneer",category1);
        monthlyItemsList.add(monthlyItem1);
        monthlyItemsList.add(monthlyItem2);
        monthlyItemsList.add(monthlyItem3);
        return monthlyItemsList;
//        return null;
    }

    @Override
    public MonthlyItems getItemsByCategory() {
        return null;
    }

    @Override
    public MonthlyItems getPurchaseItemByMonth() {
        return null;
    }

    @Override
    public List<MonthlyItems> addItems(List<MonthlyItems> items) {
        return null;
    }

    @Override
    public List<Category> addCategory(List<Category> categories) {
        if(Objects.nonNull(categories) && !categories.isEmpty()){
//
//            List<Object> objects = convertToDTOs(categories);
            List<CategoryEntity> categoryEntities = convertToEntities(categories).stream()
                    .map(e -> (CategoryEntity)e).collect(Collectors.toList());
            List<CategoryEntity> result = categoryRepository.saveAll(categoryEntities);

            return convertToDTOs(result);
        }

        return Collections.emptyList();
    }

    private List<CategoryEntity> convertToEntities(List<Category> source) {
        return source.stream()
                .map(e -> {
                    CategoryEntity cat = new CategoryEntity();
                    BeanUtils.copyProperties(e, cat);
                    return cat;
                }).collect(Collectors.toList());

//        return target;
    }
    private List<Category> convertToDTOs(List<CategoryEntity> source) {
        return source.stream()
                .map(e-> {
                    Category cat=  new Category();
                    BeanUtils.copyProperties(source,cat );
                    return cat ;}).collect(Collectors.toList());

    }

    @Override
    public List<PurchaseItem> addPurchaseItem(List<PurchaseItem> items) {
        return null;
    }

    @Override
    public List<MonthlyItems> getItems() {
        return null;
    }

    @Override
    public List<Category> getCategory() {
        return convertToDTOs(categoryRepository.findAll());
    }

    @Override
    public List<PurchaseItem> UpdatePurchaseItem(List<PurchaseItem> items) {
        return null;
    }
}
