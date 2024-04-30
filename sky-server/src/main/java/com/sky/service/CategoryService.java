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
   // List<Category> category(Integer type);

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    void insertCategory(CategoryDTO categoryDTO);

    /**
     * 修改分类数据
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 删除分类
     * @param categoryDTO
     */
    void deleteCategory(CategoryDTO categoryDTO);

    /**
     * 启用禁止
     * @param categoryDTO
     */
    void startOrStop(CategoryDTO categoryDTO);
}
