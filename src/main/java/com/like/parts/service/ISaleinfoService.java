package com.like.parts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.like.parts.entity.Saleinfo;

/**
 * @author like
 * @create 2022-06-06-14:06
 */

/**
 * 零部件销售记录信息的service接口
 */
public interface ISaleinfoService extends IService<Saleinfo> {
    /**
     * 分页查询零部件销售记录数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-零部件销售记录名称
     * @return
     */
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条零部件销售记录信息
     * @param saleinfo
     */
    public int addSaleinfo(Saleinfo saleinfo);
    /**
     * 修改一条零部件销售记录信息
     * @param saleinfo
     */
    public int editSaleinfo(Saleinfo saleinfo);

    /**
     * 根据主键id查询一个零部件销售记录对象
     * @param id
     * @return
     */
    public Saleinfo querySaleinfoById(Integer id);
    /**
     * 根据主键id删除一个零部件销售记录对象
     * @param id
     * @return
     */
    public int delSaleinfoById(Integer id);


}
