package com.chenzhen.blog.controller;

import com.chenzhen.blog.entity.enums.SysConfigEnum;
import com.chenzhen.blog.entity.pojo.SysConfig;
import com.chenzhen.blog.service.SysConfigService;
import com.chenzhen.blog.service.ViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/17 21:22
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class AboutController {

    @Autowired
    ViewsService viewsService;
    @Autowired
    SysConfigService sysConfigService;

    @GetMapping("/about")
    public String about(Model model) {

        // 获取简介
        String intro = getCfg(SysConfigEnum.ABOUT_ME_INTRODUCTION);
        // 获取内容
        String content = getCfg(SysConfigEnum.ABOUT_ME_CONTENT);
        // 获取作者
        String author = getCfg(SysConfigEnum.AUTHOR);
        // 获取技能
        //获取技能字符串
        String skillStr = getCfg(SysConfigEnum.ABOUT_ME_SKILL);
        //逗号分割
        String[] skills = skillStr.split("[,，]");

        model.addAttribute("intro", intro);
        model.addAttribute("content", content);
        model.addAttribute("skills", skills);
        model.addAttribute("author", author);

        // 更新总浏览量
        viewsService.updateTotalViews();

        return "about";
    }

    private String getCfg(SysConfigEnum configEnum) {
        SysConfig cfg = sysConfigService.getByEnums(configEnum);
        if (cfg == null) {
            return "";
        }
        return cfg.getValue();
    }
}
