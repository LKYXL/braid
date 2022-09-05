package com.like.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.like.parts.entity.Owninfo;
import com.like.parts.mapper.OwninfoMapper;
import com.like.parts.service.IOwninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @create 2022-06-06-14:13
 */

/**
 * 零部件出入库service的实现类
 */
@Service
public class OwninfoServiceImpl extends ServiceImpl<OwninfoMapper, Owninfo> implements IOwninfoService {
    @Autowired
    private OwninfoMapper owninfoMapper;

    /**
     * 分页查询零部件出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-零部件出入库名称
     * @return
     */
    @Override
    public IPage<Owninfo> selectOwninfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owninfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Owninfo> page = new Page<>(pageNum,pageSize);
        return owninfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条零部件出入库信息
     *
     * @param owninfo
     */
    @Override
    public int addOwninfo(Owninfo owninfo) {
        return owninfoMapper.insert(owninfo);
    }

    /**
     * 修改一条零部件出入库信息
     *
     * @param owninfo
     */
    @Override
    public int editOwninfo(Owninfo owninfo) {
        return owninfoMapper.updateById(owninfo);
    }

    /**
     * 根据主键id查询一个零部件出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public Owninfo queryOwninfoById(Integer id) {
        return owninfoMapper.selectById(id);

    }

    /**
     * 根据主键id删除一个零部件出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public int delOwninfoById(Integer id) {
        return owninfoMapper.deleteById(id);
    }



}
