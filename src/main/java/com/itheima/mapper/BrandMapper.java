package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {


    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);


    /**
     * 修改数据
     * @param id
     */

    void update(int id);

    /**
     * 批量删除
     * @param ids
     */

    void deleteByIds (@Param("ids") int[] ids);

    /**
     *分页查询
     * @param begin
     * @param size
     * @return
     */

    List<Brand>selectByPage(@Param("begin")int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    int selectTotalCount();

    /**
     *分页条件查询
     * @param begin
     * @param size
     * @return
     */

    List<Brand>selectByPageAndCondition(@Param("begin")int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
