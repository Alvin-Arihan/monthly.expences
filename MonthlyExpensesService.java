package com.rpy.monthly.expences.service;

import com.rpy.monthly.expences.dto.Category;
import com.rpy.monthly.expences.dto.MonthlyItems;
import com.rpy.monthly.expences.dto.PurchaseItem;

import java.util.List;

public interface MonthlyExpensesService {

    public List<MonthlyItems> getAllItems();


    public MonthlyItems getItemsByCategory();

    public MonthlyItems getPurchaseItemByMonth();

    public List<MonthlyItems> addItems(List<MonthlyItems> items);

    public List<Category> addCategory(List<Category> categories);

    public List<PurchaseItem> addPurchaseItem(List<PurchaseItem> items);

    public List<MonthlyItems> getItems();

    public List<Category> getCategory();

    public List<PurchaseItem> UpdatePurchaseItem(List<PurchaseItem> items);
}
