package com.rpy.monthly.expences.service;

import com.rpy.monthly.expences.dto.Category;
import java.util.List;

public interface CategoryService {


  public List<Category> addCategory(Category category);
  public List<Category> getAllCategory();

}
