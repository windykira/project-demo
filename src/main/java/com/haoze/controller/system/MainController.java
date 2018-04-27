package com.haoze.controller.system;

import com.haoze.utils.PageUtils;
import com.haoze.utils.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by haoz-dev4 on 2018/4/27.
 */
@RequestMapping("/main")
@Controller
public class MainController {


    @ResponseBody
    @GetMapping("/open/list")
    public PageUtils opentList(@RequestParam Map<String, Object> params) {
        QueryParam query = new QueryParam(params);
        /*List<ContentDO> bContentList = bContentService.list(query);
        int total = bContentService.count(query);
        PageUtils pageUtils = new PageUtils(bContentList, total);*/
        PageUtils pageUtils = new PageUtils(Collections.emptyList(),0);
        return pageUtils;
    }
}
