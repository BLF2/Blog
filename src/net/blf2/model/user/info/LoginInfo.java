package net.blf2.model.user.info;

import net.blf2.model.user.staticfile.ILoginInfo;
import net.blf2.model.user.staticfile.LoginRule;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息类
 */
public class LoginInfo implements ILoginInfo{
    private Integer loginId;//登陆id
    private String loginEmail;//登陆邮箱
    private String loginPswd;//登陆密码
    private String loginName;//用户昵称
    private LoginRule loginRule;//用户身份

    public LoginInfo() {
    }

    public LoginInfo(String loginEmail, String loginPswd, String loginName, LoginRule loginRule) {
        this.loginEmail = loginEmail;
        this.loginPswd = loginPswd;
        this.loginName = loginName;
        this.loginRule = loginRule;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPswd() {
        return loginPswd;
    }

    public void setLoginPswd(String loginPswd) {
        this.loginPswd = loginPswd;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LoginRule getLoginRule() {
        return loginRule;
    }

    public void setLoginRule(LoginRule loginRule) {
        this.loginRule = loginRule;
    }
    public Boolean isUser(){
        return this.loginRule.isUser();
    }
    public Boolean isAdmin(){
        return this.loginRule.isAdmian();
    }
    public Boolean isInactive(){
        return this.loginRule.isInactive();
    }
}
