package com.haoze.controller.system;

import com.haoze.utils.PageUtil;
import com.haoze.common.model.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * 主页相关控制器信息。
 * @author maxl
 * @time 2018-04-27。
 */
@RequestMapping("/main")
@Controller
public class MainController {

    @ResponseBody
    @GetMapping("/open/list")
    public PageUtil opentList(@RequestParam Map<String, Object> params) {
        QueryParam query = new QueryParam(params);
        PageUtil pageUtils = new PageUtil(Collections.emptyList(),0);
        return pageUtils;
    }
}
