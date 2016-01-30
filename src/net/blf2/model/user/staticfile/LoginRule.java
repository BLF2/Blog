package net.blf2.model.user.staticfile;

/**
 * Created by blf2 on 16-1-30.
 * 登陆信息类中身份的枚举类
 */
public enum LoginRule {
    user,admin;//普通用户  管理员
    public Boolean isUser(){
        if(this == user)
            return true;
        return false;
    }
    public Boolean isAdmian(){
        if(this == admin)
            return true;
        return false;
    }
}
