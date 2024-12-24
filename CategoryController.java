package com.rpy.monthly.expences.controller;

import com.rpy.monthly.expences.dto.Category;
import com.rpy.monthly.expences.dto.MonthlyItems;
import com.rpy.monthly.expences.service.impl.CategoryServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

  @Autowired
  CategoryServiceImpl categoryService;

  @PostMapping("/addCategory")
  public String SaveItems (@ModelAttribute("catagory") Category ca, Model model){
    categoryService.addCategory(ca);
    model.addAttribute("categories",null);
    model.addAttribute("errormsg","Getting Error");
    return "CategoryList"; // CategoryList.html
  }


}
