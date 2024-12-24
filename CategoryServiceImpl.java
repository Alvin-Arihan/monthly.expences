package com.rpy.monthly.expences.service.impl;


import com.rpy.monthly.expences.dto.Category;
import com.rpy.monthly.expences.entity.CategoryEntity;
import com.rpy.monthly.expences.repository.CategoryRepository;
import com.rpy.monthly.expences.service.CategoryService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;
  @Override
  public List<Category> addCategory(Category category) {
    CategoryEntity categoryEntity =new CategoryEntity();

    BeanUtils.copyProperties(category,categoryEntity);
    CategoryEntity save = categoryRepository.save(categoryEntity);
    if(Objects.nonNull(save))
    return getAllCategory();

    return Collections.EMPTY_LIST;
  }

  @Override
  public List<Category> getAllCategory() {
    List<CategoryEntity> all = categoryRepository.findAll();
    List<Category> list=new ArrayList<>();
    all.stream().forEach(e-> {
      Category  temp =new Category();
      BeanUtils.copyProperties(e,temp );
      list.add(temp);
       });
    return list;
  }
}
