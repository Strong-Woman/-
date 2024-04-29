package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api("分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation("显示分类信息")
    public Result<List<Category>> Category(Integer type){
        log.info("分类类型：",type);
       List<Category> list=categoryService.category(type);
        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> PageAndCategory(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult=categoryService.pageAndCategory(categoryPageQueryDTO);
        return Result.success(pageResult);
    }
}
