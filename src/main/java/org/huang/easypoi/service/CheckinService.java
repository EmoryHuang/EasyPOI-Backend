package org.huang.easypoi.service;

import org.huang.easypoi.bean.CheckinBean;
import org.huang.easypoi.mapper.CheckinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinService {

    @Autowired
    CheckinMapper checkinMapper;

    public int addCheckin(CheckinBean checkin) {
        return checkinMapper.addCheckin(checkin);
    }

    public Long getCheckinNum(String openid) {
        return checkinMapper.getCheckinNum(openid);
    }

    public List<CheckinBean> getRecentCheckins(String openid, Long num) {
        return checkinMapper.getRecentCheckins(openid, num);
    }
}
