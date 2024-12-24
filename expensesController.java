package com.rpy.monthly.expences.controller;

import com.rpy.monthly.expences.dto.Category;
import com.rpy.monthly.expences.dto.MonthlyItems;
import com.rpy.monthly.expences.dto.PurchaseItem;
import com.rpy.monthly.expences.service.MonthlyExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class expensesController {

    @Autowired
    MonthlyExpensesService monthlyExpensesService;

    @GetMapping("/monthly")
    public String getItem(Model model){
        PurchaseItem purchaseOrderItems =new PurchaseItem();
        var items = monthlyExpensesService.getAllItems();
        if(Objects.nonNull(items) && !items.isEmpty() ) {
            model.addAttribute("items", items);
            model.addAttribute("purchaseOrderItems", purchaseOrderItems);
        }else {
            model.addAttribute("message", "No items found");
        }

        return "expenses";
    }

    @PostMapping("/search")
    public String addItems(){


        return "expenses";
    }

    @PostMapping("/saveItems")
    public String SaveItems (@ModelAttribute("items") List<MonthlyItems> items, Model model){
model.addAttribute("items",null);
        return "saveItems";

    }

    @PostMapping("/savecategory")
            public String saveCat(@ModelAttribute("categorties")List<Category> categorylist, Model model) {
        List<Category> categories = monthlyExpensesService.addCategory(categorylist);
        if(categories.isEmpty()){
             model.addAttribute("addcategories", categories);
        }
           model.addAttribute("categorties", categories);
        return "saveCategory";
    }

    @GetMapping("/getcategory")
    public String getCategory(Model model){
        List<Category> categories = monthlyExpensesService.getCategory();
        model.addAttribute("categorties", categories);
        return "saveCategory";
    }
}
