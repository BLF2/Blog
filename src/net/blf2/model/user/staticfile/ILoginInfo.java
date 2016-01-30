package net.blf2.model.user.staticfile;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息类（LoginInfo）接口
 */
public interface ILoginInfo {
    Integer getLoginId();
    String getLoginEmail();
    String getLoginPswd();
    String getLoginName();
    LoginRule getLoginRule();
    Boolean isUser();
    Boolean isAdmin();
}
