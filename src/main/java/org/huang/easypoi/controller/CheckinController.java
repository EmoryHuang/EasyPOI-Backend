package org.huang.easypoi.controller;

import org.huang.easypoi.bean.CheckinBean;
import org.huang.easypoi.bean.RespBean;
import org.huang.easypoi.service.CheckinService;
import org.huang.easypoi.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi")
public class CheckinController {

    @Autowired
    WeChatService weChatService;

    @Autowired
    CheckinService checkinService;

    @GetMapping("/openid")
    public String getUserInfo(@RequestParam(name = "code") String code) throws Exception {
        return weChatService.getUserInfo(code);
    }

    @PostMapping("/addCheckin")
    public RespBean addCheckin(@RequestBody CheckinBean checkin) {

        int res = checkinService.addCheckin(checkin);
        if (res == 1) {
            return new RespBean("1", "success");
        } else {
            return new RespBean("0", "fail");
        }
    }

    @GetMapping("/getCheckinNum")
    public Long getCheckinNum(@RequestParam(name = "openid") String openid) {
        return checkinService.getCheckinNum(openid);
    }

    @GetMapping("/getRecentCheckins")
    public List<CheckinBean> getRecentCheckins(@RequestParam("openid") String openid, @RequestParam("num") Long num) {
        return checkinService.getRecentCheckins(openid, num);
    }
}
