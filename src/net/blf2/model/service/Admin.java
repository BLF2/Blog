package net.blf2.model.service;

import net.blf2.model.user.DAO.QueryUser;
import net.blf2.model.user.DAO.UpdateUser;
import net.blf2.model.user.info.LoginInfo;
import net.blf2.model.user.staticfile.LoginRule;

import java.util.List;

/**
 * Created by blf2 on 16-2-27.
 */
public class Admin extends PrimaryUser{
    //增加用户信息 已继承
    //修改用户信息 已继承
    //根据登陆邮箱查询登录信息 已继承
    //修改用户权限 已继承
    public List<LoginInfo> queryLoginInfoAll(){
        return new QueryUser().queryLoginInfoAll();
    }
    public Boolean updateLoginInfo(Integer loginId,String loginPswd,String loginName,LoginRule loginRule){
        LoginInfo loginInfo = new QueryUser().queryLoginInfoById(loginId);
        loginInfo.setLoginPswd(loginPswd);
        loginInfo.setLoginName(loginName);
        loginInfo.setLoginRule(loginRule);
        return new UpdateUser().updateLoginInfo(loginInfo);
    }

}
