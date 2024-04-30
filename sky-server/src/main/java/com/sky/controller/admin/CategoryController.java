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
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/admin/category")
@Api(tags = "分类相关接口")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("tag=新增分类")
    public Result<String> InsertCategory(@RequestBody CategoryDTO categoryDTO){

        log.info("添加的数据：{}",categoryDTO);

        categoryService.insertCategory(categoryDTO);
        return Result.success();
    }


  /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> PageAndCategory(CategoryPageQueryDTO categoryPageQueryDTO){

        log.info("分页查询：{}",categoryPageQueryDTO);

        PageResult pageResult=categoryService.pageAndCategory(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

 /*   *//**
     * 根据类型查询分类
     * @param type
     * @return
     */
/*    @GetMapping("/list")
    @ApiOperation("显示分类信息")
    public Result<List<Category>> Category(Integer type){
        log.info("分类类型：{}",type);
        List<Category> list=categoryService.category(type);
        return Result.success(list);
    }*/

    /**
     * 修改类型
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类信息")
    public Result<String> updateCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("修改数据：{}",categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 删除分类
     * @param categoryDTO
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result deleteCategory(CategoryDTO categoryDTO){
        log.info("传入分类的ID:{}",categoryDTO.getId());
        categoryService.deleteCategory(categoryDTO);
        return Result.success() ;
    }

    /**
     * 启用或者禁止
     * @param categoryDTO
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用或者禁止")
    public Result startOrStop(CategoryDTO categoryDTO){
        categoryService.startOrStop(categoryDTO);
        return Result.success();
    }
}
