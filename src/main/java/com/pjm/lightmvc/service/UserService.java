package com.pjm.lightmvc.service;

import com.pjm.lightmvc.vo.sys.UserVo;

/**
 * Created by PanJM on 2016/3/16.
 */
public interface UserService {

    UserVo login(UserVo userVo) throws Exception;
}
