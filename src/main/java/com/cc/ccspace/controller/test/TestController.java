package com.cc.ccspace.controller.test;

import com.alibaba.fastjson.JSON;
import com.cc.ccspace.base.controller.BaseController;
import com.cc.ccspace.service.test.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/2/26 16:42.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
@Resource
   TestService testService;
    @ResponseBody
    @RequestMapping(value="/xaTest",produces="text/plain;charset=utf-8")
    public String test(HttpServletRequest req) {
        String mode=req.getParameter("mode");
    try {
        testService.test(Integer.parseInt(mode));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "success";
}


}
