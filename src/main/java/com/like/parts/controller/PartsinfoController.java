package com.like.parts.controller;

/**
 * @author like
 * @create 2022-06-01-15:39
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.like.parts.common.ResultMapUtil;
import com.like.parts.entity.Partsinfo;
import com.like.parts.service.IPartsinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 零部件相关的controller
 */
@Controller
@RequestMapping(value = "/partsinfo")
public class PartsinfoController {
    @Autowired
    private IPartsinfoService partsinfoService;

    /**
     * 转向零部件页面
     */
    @RequestMapping
    public String partsinfo() {
        return "/partsinfo";
    }


    /**
     * 分页查询零部件列表
     */
    @RequestMapping(value = "/partsinfoQueryPage")
    @ResponseBody
    public Object partsinfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Partsinfo> iPage = partsinfoService.selectPartsinfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 转向零部件新增页面
     */
    @RequestMapping(value = "/partsinfoPage")
    public String partsinfoPage() {
        return "/partsinfoPage";
    }

    /**
     * 添加一个零部件
     */
    @RequestMapping(value = "/partsinfoAdd")
    @ResponseBody
    public Object partsinfoAdd(Partsinfo partsinfo) {
        try {
            int i = partsinfoService.addPartsinfo(partsinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向零部件编辑页面
     */
    @RequestMapping(value = "/partsinfoQueryById")
    public String partsinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Partsinfo partsinfo = partsinfoService.queryPartsinfoById(id);
        model.addAttribute("obj",partsinfo);
        return "/partsinfoPage";
    }
    /**
     * 修改一个零部件
     */
    @RequestMapping(value = "/partsinfoEdit")
    @ResponseBody
    public Object partsinfoEdit(Partsinfo partsinfo) {
        try {
            int i = partsinfoService.editPartsinfo(partsinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个零部件
     */
    @RequestMapping(value = "/partsinfoDelById")
    @ResponseBody
    public Object partsinfoDelById(Integer id) {
        try {
            int i = partsinfoService.delPartsinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     *
     * 获取所有零部件
     */
    @RequestMapping(value = "/partsinfoList")
    @ResponseBody
    public Object partsinfoList(){
        List<Partsinfo> partsinfoList = partsinfoService.queryPartsinfoList();
        return ResultMapUtil.getHashMapList(partsinfoList);
    }
    /**
     * 转向零部件寿命检查页面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }
}
