package com.like.parts.controller;

/**
 * @author like
 * @create 2022-06-01-15:39
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.like.parts.common.ResultMapUtil;
import com.like.parts.entity.Owninfo;
import com.like.parts.service.IOwninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 零部件出入库相关的controller
 */
@Controller
@RequestMapping(value = "/owninfo")
public class OwninfoController {
    @Autowired
    private IOwninfoService owninfoService;

    /**
     * 转向零部件出入库页面
     */
    @RequestMapping
    public String owninfo() {
        return "/owninfo";
    }


    /**
     * 分页查询零部件出入库列表
     */
    @RequestMapping(value = "/owninfoQueryPage")
    @ResponseBody
    public Object owninfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Owninfo> iPage = owninfoService.selectOwninfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 转向零部件出入库新增页面
     */
    @RequestMapping(value = "/owninfoPage")
    public String owninfoPage() {
        return "/owninfoPage";
    }

    /**
     * 添加一个零部件出入库
     */
    @RequestMapping(value = "/owninfoAdd")
    @ResponseBody
    public Object owninfoAdd(Owninfo owninfo) {
        try {
            owninfo.setCreatetime(new Date());
            int i = owninfoService.addOwninfo(owninfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向零部件出入库编辑页面
     */
    @RequestMapping(value = "/owninfoQueryById")
    public String owninfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Owninfo owninfo = owninfoService.queryOwninfoById(id);
        model.addAttribute("obj",owninfo);
        return "/owninfoPage";
    }
    /**
     * 修改一个零部件出入库
     */
    @RequestMapping(value = "/owninfoEdit")
    @ResponseBody
    public Object owninfoEdit(Owninfo owninfo) {
        try {
            int i = owninfoService.editOwninfo(owninfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个零部件出入库
     */
    @RequestMapping(value = "/owninfoDelById")
    @ResponseBody
    public Object owninfoDelById(Integer id) {
        try {
            int i = owninfoService.delOwninfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
