package com.like.parts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.like.parts.entity.Owninfo;

/**
 * @author like
 * @create 2022-06-06-14:06
 */

/**
 * 零部件出入库信息的service接口
 */
public interface IOwninfoService extends IService<Owninfo> {
    /**
     * 分页查询零部件出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-零部件出入库名称
     * @return
     */
    public IPage<Owninfo> selectOwninfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条零部件出入库信息
     * @param owninfo
     */
    public int addOwninfo(Owninfo owninfo);
    /**
     * 修改一条零部件出入库信息
     * @param owninfo
     */
    public int editOwninfo(Owninfo owninfo);

    /**
     * 根据主键id查询一个零部件出入库对象
     * @param id
     * @return
     */
    public Owninfo queryOwninfoById(Integer id);
    /**
     * 根据主键id删除一个零部件出入库对象
     * @param id
     * @return
     */
    public int delOwninfoById(Integer id);


}
