package net.blf2.model.service;

import net.blf2.model.article.DAO.DeleteArticle;
import net.blf2.model.article.DAO.QueryArticle;
import net.blf2.model.article.DAO.UpdateArticle;
import net.blf2.model.article.info.ArticleInfo;
import net.blf2.model.article.info.ArticleInfoFactory;
import net.blf2.model.article.staticfile.ArticleStatus;
import net.blf2.model.article.staticfile.IArticleInfo;
import net.blf2.model.articletag.DAO.DeleteArticleTag;
import net.blf2.model.articletag.DAO.InsertArticleTag;
import net.blf2.model.articletag.DAO.QueryArticleTag;
import net.blf2.model.articletag.info.ArticleTag;
import net.blf2.model.user.DAO.QueryUser;
import net.blf2.model.user.DAO.UpdateUser;
import net.blf2.model.user.info.LoginInfo;
import net.blf2.model.user.info.LoginInfoFactory;
import net.blf2.model.user.staticfile.ILoginInfo;
import net.blf2.model.user.staticfile.LoginRule;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blf2 on 16-2-26.
 * 普通用户service
 */
public class PrimaryUser {
    /**
     * 用户部分
     * @param loginEmail
     * @param loginPswd
     * @return
     */
    public Boolean loginCheck(String loginEmail,String loginPswd){
        LoginInfo loginInfo = new QueryUser().queryLoginInfoByEmail(loginEmail);
        if(loginEmail.equals(loginInfo.getLoginEmail()) && loginPswd.equals(loginInfo.getLoginPswd())){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public ILoginInfo registerLoginInfo(String loginEmail,String loginPswd,String loginName,LoginRule loginRule){
        LoginInfoFactory loginInfoFactory = new LoginInfoFactory(loginEmail,loginPswd,loginName,loginRule);
        return loginInfoFactory.getLoginInfo();
    }

    public ILoginInfo queryLoginInfo(String loginEmail){
        //判断合法E-Mail
        Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
        Matcher matcher = pattern.matcher(loginEmail);

        if(matcher.matches()) {
            return new QueryUser().queryLoginInfoByEmail(loginEmail);
        }
        return null;
    }
    public Boolean updateLoginInfo(Integer loginId,String loginPswd,String loginName){
        LoginInfo loginInfo = new QueryUser().queryLoginInfoById(loginId);
        loginInfo.setLoginPswd(loginPswd);
        loginInfo.setLoginName(loginName);
        return new UpdateUser().updateLoginInfo(loginInfo);
    }

    /**
     * 用户的文章操作部分
     * @param articleTitle
     * @param writerId
     * @param articleText
     * @param publishDateTime
     * @param articleStatus
     * @return
     */
    public Integer saveArticle(String articleTitle,Integer writerId,String articleText,String publishDateTime,
                               ArticleStatus articleStatus){
        ArticleInfoFactory articleInfoFactory = new ArticleInfoFactory(articleTitle,writerId,articleText,
                publishDateTime,articleStatus);
        IArticleInfo iArticleInfo = articleInfoFactory.getArticleInfo();
        return iArticleInfo.getArticleId();
    }
    public List<ArticleInfo> findArticleInfoAllByWriterId(Integer writerId){
        return new QueryArticle().queryArticleInfoByWriterId(writerId);
    }
    public ArticleInfo findArticleInfoByArticleId(Integer articleId){
        return new QueryArticle().queryArticleInfoById(articleId);
    }
    public Boolean updateArticleInfo(ArticleInfo articleInfo){
        return new UpdateArticle().updateArticleInfo(articleInfo);
    }
    public Boolean deleteArticleInfoByArticleId(Integer articleId){
        ArticleInfo articleInfo = new QueryArticle().queryArticleInfoById(articleId);
        if(articleId != null) {
            List<ArticleTag>list = new QueryArticleTag().queryArticleTagByArticleId(articleId);
            Iterator<ArticleTag>iterator = list.iterator();
            while(iterator.hasNext()) {
                ArticleTag articleTag = iterator.next();
                new DeleteArticleTag().deleteArticleTag(articleTag);
            }
            return new DeleteArticle().deleteArticleInfo(articleInfo);
        }
        return Boolean.FALSE;
    }

    /**
     * 用户给文章标签操作
     */
    public Boolean addTagToArticle(Integer tagId,Integer articleId){
        ArticleTag articleTag = new InsertArticleTag().insertArticleTag(new ArticleTag(articleId, tagId));
        if(articleTag != null)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    public Boolean deleteTagFromArticle(Integer tagId,Integer articleId){
        ArticleTag articleTag = new QueryArticleTag().queryArticleTagByDoubleId(articleId,tagId);
        if(articleTag != null){
            return new DeleteArticleTag().deleteArticleTag(articleTag);
        }
        return Boolean.FALSE;
    }

}
