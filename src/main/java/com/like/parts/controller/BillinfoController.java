package com.like.parts.controller;

/**
 * @author like
 * @create 2022-06-01-15:39
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.like.parts.common.ResultMapUtil;
import com.like.parts.entity.Billinfo;
import com.like.parts.service.IBillinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供应商账单相关的controller
 */
@Controller
@RequestMapping(value = "/billinfo")
public class BillinfoController {
    @Autowired
    private IBillinfoService billinfoService;

    /**
     * 转向供应商账单页面
     */
    @RequestMapping
    public String billinfo() {
        return "/billinfo";
    }


    /**
     * 分页查询供应商账单列表
     */
    @RequestMapping(value = "/billinfoQueryPage")
    @ResponseBody
    public Object billinfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum,
                                    @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Billinfo> iPage = billinfoService.selectBillinfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 转向供应商账单新增页面
     */
    @RequestMapping(value = "/billinfoPage")
    public String billinfoPage() {
        return "/billinfoPage";
    }

    /**
     * 添加一个供应商账单
     */
    @RequestMapping(value = "/billinfoAdd")
    @ResponseBody
    public Object billinfoAdd(Billinfo billinfo) {
        try {
//            billinfo.setOperatetime(new Date());
            int i = billinfoService.addBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商账单编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/billinfoPage";
    }
    /**
     * 修改一个供应商账单
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billinfoEdit(Billinfo billinfo) {
        try {
            int i = billinfoService.editBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个供应商账单
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billinfoDelById(Integer id) {
        try {
            int i = billinfoService.delBillinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
