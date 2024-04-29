package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;

import java.util.List;

public interface CategoryService {

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageAndCategory(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 查询分类
     * @param type
     * @return
     */
    List<Category> category(Integer type);
}
