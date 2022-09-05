package com.like.parts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.like.parts.entity.Partsinfo;

import java.util.List;

/**
 * @author like
 * @create 2022-06-06-14:06
 */

/**
 * 零部件信息的service接口
 */
public interface IPartsinfoService extends IService<Partsinfo> {
    /**
     * 分页查询零部件数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数
     * @return
     */
    public IPage<Partsinfo> selectPartsinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条零部件信息-零部件名称
     * @param partsinfo
     */
    public int addPartsinfo(Partsinfo partsinfo);
    /**
     * 修改一条零部件信息
     * @param partsinfo
     */
    public int editPartsinfo(Partsinfo partsinfo);

    /**
     * 根据主键id查询一个零部件对象
     * @param id
     * @return
     */
    public Partsinfo queryPartsinfoById(Integer id);
    /**
     * 根据主键id删除一个零部件对象
     * @param id
     * @return
     */
    public int delPartsinfoById(Integer id);

    /**
     * 查询所有零部件
     * @return
     */
    public List<Partsinfo> queryPartsinfoList();
}
