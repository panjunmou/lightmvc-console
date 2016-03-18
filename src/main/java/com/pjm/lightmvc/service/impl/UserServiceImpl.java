package com.pjm.lightmvc.service.impl;

import com.pjm.lightmvc.contants.UserStatus;
import com.pjm.lightmvc.dao.biz.UserDao;
import com.pjm.lightmvc.model.sys.TUser;
import com.pjm.lightmvc.service.UserService;
import com.pjm.lightmvc.contants.ControllerMsg;
import com.pjm.lightmvc.util.MD5Util;
import com.pjm.lightmvc.vo.sys.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by PanJM on 2016/3/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public UserVo login(UserVo userVo) throws Exception{
        TUser tUser = userDao.getUserByNameOrPhone(userVo.getLoginName().trim());
        if (tUser == null || !tUser.getPassWord().trim().equals(MD5Util.md5(userVo.getPassWord()))) {
            throw new Exception(ControllerMsg.USER_LOGINNAME_OR_PASSWORD_INCORRECT_ERROR);
        }
        if (tUser.getStatus() == UserStatus.ACTIVITY.getValue()) {
            UserVo user = new UserVo();
            BeanUtils.copyProperties(tUser, user);
            // TODO: 2016/3/16 缺少机构,区域,角色 设定
            return user;
        }else if (tUser.getStatus() == UserStatus.UNACTIVITI.getValue()){
            throw new Exception(ControllerMsg.USER_USER_DISABLED_ERROR);
        }
        return null;
    }
}
