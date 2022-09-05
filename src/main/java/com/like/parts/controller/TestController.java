package com.like.parts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author like
 * @create 2022-05-27-17:26
 */

@Controller
public class TestController {

    @RequestMapping("/testString")
    @ResponseBody
    public String testString(){
        return "大家好";
    }

}
