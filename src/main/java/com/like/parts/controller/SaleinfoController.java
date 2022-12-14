package com.like.parts.controller;

/**
 * @author like
 * @create 2022-06-01-15:39
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.like.parts.common.ResultMapUtil;
import com.like.parts.entity.Saleinfo;
import com.like.parts.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 零部件销售记录相关的controller
 */
@Controller
@RequestMapping(value = "/saleinfo")
public class SaleinfoController {
    @Autowired
    private ISaleinfoService saleinfoService;

    /**
     * 转向零部件销售记录页面
     */
    @RequestMapping
    public String saleinfo() {
        return "/saleinfo";
    }


    /**
     * 分页查询零部件销售记录列表
     */
    @RequestMapping(value = "/saleinfoQueryPage")
    @ResponseBody
    public Object saleinfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Saleinfo> iPage = saleinfoService.selectSaleinfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 转向零部件销售记录新增页面
     */
    @RequestMapping(value = "/saleinfoPage")
    public String saleinfoPage() {
        return "/saleinfoPage";
    }

    /**
     * 添加一个零部件销售记录
     */
    @RequestMapping(value = "/saleinfoAdd")
    @ResponseBody
    public Object saleinfoAdd(Saleinfo saleinfo) {
        try {
//            saleinfo.setOperatetime(new Date());
            int i = saleinfoService.addSaleinfo(saleinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向零部件销售记录编辑页面
     */
    @RequestMapping(value = "/saleinfoQueryById")
    public String saleinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Saleinfo saleinfo = saleinfoService.querySaleinfoById(id);
        model.addAttribute("obj",saleinfo);
        return "/saleinfoPage";
    }
    /**
     * 修改一个零部件销售记录
     */
    @RequestMapping(value = "/saleinfoEdit")
    @ResponseBody
    public Object saleinfoEdit(Saleinfo saleinfo) {
        try {
            int i = saleinfoService.editSaleinfo(saleinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个零部件销售记录
     */
    @RequestMapping(value = "/saleinfoDelById")
    @ResponseBody
    public Object saleinfoDelById(Integer id) {
        try {
            int i = saleinfoService.delSaleinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
