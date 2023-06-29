package org.huang.easypoi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.huang.easypoi.bean.CheckinBean;

import java.util.List;

@Mapper
public interface CheckinMapper {

    int addCheckin(CheckinBean checkin);

    Long getCheckinNum(String openid);

    List<CheckinBean> getRecentCheckins(@Param("openid") String openid, @Param("num") Long num);
}
