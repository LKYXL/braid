package com.like.parts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.like.parts.entity.Billinfo;

/**
 * @author like
 * @create 2022-06-06-14:06
 */

/**
 * 账单信息的service接口
 */
public interface IBillinfoService extends IService<Billinfo> {
    /**
     * 分页查询账单数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单名称
     * @return
     */
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息
     * @param billinfo
     */
    public int addBillinfo(Billinfo billinfo);
    /**
     * 修改一条账单信息
     * @param billinfo
     */
    public int editBillinfo(Billinfo billinfo);

    /**
     * 根据主键id查询一个账单对象
     * @param id
     * @return
     */
    public Billinfo queryBillinfoById(Integer id);
    /**
     * 根据主键id删除一个账单对象
     * @param id
     * @return
     */
    public int delBillinfoById(Integer id);


}
