package com.like.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.like.parts.entity.Billinfo;
import com.like.parts.mapper.BillinfoMapper;
import com.like.parts.service.IBillinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @create 2022-06-06-14:13
 */

/**
 * 供应商账单service的实现类
 */
@Service
public class BillinfoServiceImpl extends ServiceImpl<BillinfoMapper, Billinfo> implements IBillinfoService {
    @Autowired
    private BillinfoMapper billinfoMapper;
    /**
     * 分页查询供应商账单数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-供应商账单名称
     * @return
     */
    @Override
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Billinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据供应商名称精确查询
            queryWrapper.eq("sname",param);
        }
        Page<Billinfo> page = new Page<>(pageNum,pageSize);
        return billinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条供应商账单信息
     *
     * @param billinfo
     */
    @Override
    public int addBillinfo(Billinfo billinfo) {
        return billinfoMapper.insert(billinfo);
    }

    /**
     * 修改一条供应商账单信息
     *
     * @param billinfo
     */
    @Override
    public int editBillinfo(Billinfo billinfo) {
        return billinfoMapper.updateById(billinfo);
    }

    /**
     * 根据主键id查询一个供应商账单对象
     *
     * @param id
     * @return
     */
    @Override
    public Billinfo queryBillinfoById(Integer id) {
        return billinfoMapper.selectById(id);

    }

    /**
     * 根据主键id删除一个供应商账单对象
     *
     * @param id
     * @return
     */
    @Override
    public int delBillinfoById(Integer id) {
        return billinfoMapper.deleteById(id);
    }



}
