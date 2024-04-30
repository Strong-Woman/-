package com.sky.service.impl;

import ch.qos.logback.classic.Logger;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import lombok.experimental.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageAndCategory(CategoryPageQueryDTO categoryPageQueryDTO){

        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page=categoryMapper.pageAndCategory(categoryPageQueryDTO);

        long total = page.getTotal();
        List<Category> records = page.getResult();
        return new PageResult(total,records);
    }

/*    *//**
     * 根据类型分类
     * @param type
     * @return
     */
    /*  @Override
    public List<Category> category(Integer type) {
       List<Category> list=categoryMapper.category(type);
        log.info("列表数据：{}",list);
        return list;
    }*/

    /**
     * 新增分类
     * @param categoryDTO
     */
    @Override
    public void insertCategory(CategoryDTO categoryDTO) {

        log.info("插入的数据：{}",categoryDTO);

        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);

        category.setStatus(StatusConstant.DISABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.insertCategory(category);
    }

    /**
     * 修改分类信息
     * @param categoryDTO
     */
    @Override
    public void updateCategory(CategoryDTO categoryDTO) {

        log.info("修改分类数据：{}",categoryDTO);

        Category category=new Category();

        BeanUtils.copyProperties(categoryDTO,category);
        Category category1=categoryMapper.getById(categoryDTO);


        category.setType(category1.getType());
        category.setStatus(category1.getStatus());
        category.setCreateTime(category1.getCreateTime());
        category.setCreateUser(category1.getCreateUser());
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());

        log.info("分类信息：{}",category);
        categoryMapper.updateCategory(category);
    }

    /**
     * 删除分类
     * @param categoryDTO
     */
    @Override
    public void deleteCategory(CategoryDTO categoryDTO) {
        log.info("删除分类的ID:{}",categoryDTO);
        categoryMapper.deleteCategory(categoryDTO);
    }

    /**
     * 启用禁止
     * @param categoryDTO
     */
    @Override
    public void startOrStop(CategoryDTO categoryDTO) {
        Category category = categoryMapper.getById(categoryDTO);
        Integer status=0;
        if(category.getStatus()==StatusConstant.DISABLE){
            status=StatusConstant.ENABLE;
        }
        else {
            status=StatusConstant.DISABLE;
        }
        categoryMapper.startOrStop(category.getId(),status);
    }
}
