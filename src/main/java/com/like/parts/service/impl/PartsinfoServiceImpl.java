package com.like.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.like.parts.entity.Partsinfo;
import com.like.parts.mapper.PartsinfoMapper;
import com.like.parts.service.IPartsinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author like
 * @create 2022-06-06-14:13
 */

/**
 * 零部件service的实现类
 */
@Service
public class PartsinfoServiceImpl extends ServiceImpl<PartsinfoMapper, Partsinfo> implements IPartsinfoService {
    @Autowired
    private PartsinfoMapper partsinfoMapper;

    /**
     * 分页查询零部件数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-零部件名称
     * @return
     */
    @Override
    public IPage<Partsinfo> selectPartsinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Partsinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Partsinfo> page = new Page<>(pageNum,pageSize);
        return partsinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条零部件信息
     *
     * @param partsinfo
     */
    @Override
    public int addPartsinfo(Partsinfo partsinfo) {
        return partsinfoMapper.insert(partsinfo);
    }

    /**
     * 修改一条零部件信息
     *
     * @param partsinfo
     */
    @Override
    public int editPartsinfo(Partsinfo partsinfo) {
        return partsinfoMapper.updateById(partsinfo);
    }

    /**
     * 根据主键id查询一个零部件对象
     *
     * @param id
     * @return
     */
    @Override
    public Partsinfo queryPartsinfoById(Integer id) {
        return partsinfoMapper.selectById(id);

    }

    /**
     * 根据主键id删除一个零部件对象
     *
     * @param id
     * @return
     */
    @Override
    public int delPartsinfoById(Integer id) {
        return partsinfoMapper.deleteById(id);
    }

    /**
     * 查询所有零部件
     *
     * @return
     */
    @Override
    public List<Partsinfo> queryPartsinfoList() {
        return partsinfoMapper.selectList(null);
    }


}
