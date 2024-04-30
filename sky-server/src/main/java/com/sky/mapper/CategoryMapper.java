package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageAndCategory(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 新增分类
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据分类ID查询分类类型
     * @param categoryDTO
     * @return
     */
    @Select("select * from category where id=#{id}")
    Category getById(CategoryDTO categoryDTO);

    @Delete("delete from category where id=#{id}")
    void deleteCategory(CategoryDTO categoryDTO);

    @Update("update category set status=#{status} where id=#{id}")
    void startOrStop(Long id, Integer status);


    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
   // List<Category> category(Integer type);
}
