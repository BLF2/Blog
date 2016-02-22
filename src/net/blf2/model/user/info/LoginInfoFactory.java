package net.blf2.model.user.info;

import net.blf2.model.user.DAO.InsertUser;
import net.blf2.model.user.staticfile.ILoginInfo;
import net.blf2.model.user.staticfile.LoginRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blf2 on 16-1-30.
 * 创建LoginInfo类的工厂类
 */
public class LoginInfoFactory {
    private String loginEmail;//登陆邮箱
    private String loginPswd;//登陆密码
    private String loginName;//用户昵称
    private LoginRule loginRule;//用户身份

    public LoginInfoFactory() {
    }

    public LoginInfoFactory(String loginEmail, String loginPswd, String loginName, LoginRule loginRule) {
        this.setLoginEmail(loginEmail);
        this.setLoginPswd(loginPswd);
        this.setLoginName(loginName);
        this.setLoginRule(loginRule);
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(loginEmail);

        if(matcher.matches())
            this.loginEmail = loginEmail;
        else
            this.loginEmail = null;
    }

    public String getLoginPswd() {
        return loginPswd;
    }

    public void setLoginPswd(String loginPswd) {
        if(loginPswd.length() > 16)
            loginPswd = loginPswd.substring(0,17);
        this.loginPswd = loginPswd;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        if(loginName.length() > 16)
            loginName = loginName.substring(0,17);
        this.loginName = loginName;
    }

    public LoginRule getLoginRule() {
        return loginRule;
    }

    public void setLoginRule(LoginRule loginRule) {
        if(loginRule.isUser() || loginRule.isAdmian())
            this.loginRule = loginRule;
        else
            this.loginRule = null;
    }

    public ILoginInfo getLoginInfo(){
        if(this.loginEmail == null || this.loginRule == null)
            return null;
        return new InsertUser().insertLoginInfo(new LoginInfo(this.loginEmail,this.loginPswd,
        this.loginName,this.loginRule));
    }
}
