package com.like.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.like.parts.entity.Problem;
import com.like.parts.mapper.ProblemMapper;
import com.like.parts.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author like
 * @create 2022-06-06-14:13
 */

/**
 * 问题零部件service的实现类
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 分页查询问题零部件数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-问题零部件名称
     * @return
     */
    @Override
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Problem> page = new Page<>(pageNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条问题零部件信息
     *
     * @param problem
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 修改一条问题零部件信息
     *
     * @param problem
     */
    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据主键id查询一个问题零部件对象
     *
     * @param id
     * @return
     */
    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);

    }

    /**
     * 根据主键id删除一个问题零部件对象
     *
     * @param id
     * @return
     */
    @Override
    public int delProblemById(Integer id) {
        return problemMapper.deleteById(id);
    }



}
