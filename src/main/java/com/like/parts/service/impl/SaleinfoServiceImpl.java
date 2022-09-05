package com.like.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.like.parts.entity.Saleinfo;
import com.like.parts.mapper.SaleinfoMapper;
import com.like.parts.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @create 2022-06-06-14:13
 */

/**
 * 零部件销售记录service的实现类
 */
@Service
public class SaleinfoServiceImpl extends ServiceImpl<SaleinfoMapper, Saleinfo> implements ISaleinfoService {
    @Autowired
    private SaleinfoMapper saleinfoMapper;

    /**
     * 分页查询零部件销售记录数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-零部件销售记录名称
     * @return
     */
    @Override
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Saleinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Saleinfo> page = new Page<>(pageNum,pageSize);
        return saleinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条零部件销售记录信息
     *
     * @param saleinfo
     */
    @Override
    public int addSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.insert(saleinfo);
    }

    /**
     * 修改一条零部件销售记录信息
     *
     * @param saleinfo
     */
    @Override
    public int editSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.updateById(saleinfo);
    }

    /**
     * 根据主键id查询一个零部件销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public Saleinfo querySaleinfoById(Integer id) {
        return saleinfoMapper.selectById(id);

    }

    /**
     * 根据主键id删除一个零部件销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public int delSaleinfoById(Integer id) {
        return saleinfoMapper.deleteById(id);
    }



}
