package net.blf2.model.service;

import net.blf2.model.article.DAO.QueryArticle;
import net.blf2.model.article.info.ArticleInfo;
import net.blf2.model.articletag.DAO.DeleteArticleTag;
import net.blf2.model.articletag.DAO.QueryArticleTag;
import net.blf2.model.articletag.info.ArticleTag;
import net.blf2.model.tag.DAO.DeleteTag;
import net.blf2.model.tag.DAO.QueryTag;
import net.blf2.model.tag.DAO.UpdateTag;
import net.blf2.model.tag.info.TagInfo;
import net.blf2.model.tag.info.TagInfoFactory;
import net.blf2.model.tag.staticfile.ITagInfo;
import net.blf2.model.user.DAO.QueryUser;
import net.blf2.model.user.DAO.UpdateUser;
import net.blf2.model.user.info.LoginInfo;
import net.blf2.model.user.staticfile.LoginRule;

import java.util.Iterator;
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
    }//查看所有用户信息
    public Boolean updateLoginInfo(Integer loginId,String loginPswd,String loginName,LoginRule loginRule){
        LoginInfo loginInfo = new QueryUser().queryLoginInfoById(loginId);
        loginInfo.setLoginPswd(loginPswd);
        loginInfo.setLoginName(loginName);
        loginInfo.setLoginRule(loginRule);
        return new UpdateUser().updateLoginInfo(loginInfo);
    }//修改用户权限

    //增加文章  已继承
    public List<ArticleInfo> queryArticleInfoAll(){
        return new QueryArticle().queryArticleInfoAll();
    }//查看所有文章
    //修改文章 已继承
    //删除文章 已继承

    public ITagInfo addTagInfo(String tagName){
        TagInfoFactory tagInfoFactory = new TagInfoFactory(tagName);
        return tagInfoFactory.getTagInfo();
    }//增加标签

    public Boolean updateTagInfo(TagInfo tagInfo){
        return new UpdateTag().updateTagInfo(tagInfo);
    }//更新标签信息

    public TagInfo queryTagInfoByTagId(Integer tagId){
        return new QueryTag().queryTagInfoById(tagId);
    }//更具标签id查询标签信息

    public List<TagInfo> queryTagInfoAll(){
        return new QueryTag().queryTagInfoAll();
    }//查询所有标签信息

    public Boolean deleteTagInfo(TagInfo tagInfo){
        List<ArticleTag>list = new QueryArticleTag().queryArticleTagByTagId(tagInfo.getTagId());
        Iterator<ArticleTag>iterator = list.iterator();
        while(iterator.hasNext()){
            ArticleTag articleTag = iterator.next();
            new DeleteArticleTag().deleteArticleTag(articleTag);
        }
        return new DeleteTag().deleteTagInfo(tagInfo);
    }//删除标签

}
