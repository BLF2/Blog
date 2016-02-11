package net.blf2.model.comment.info;

import net.blf2.model.comment.staticfile.ICmtInfo;

/**
 * Created by blf2 on 16-2-11.
 * 评论类的工厂类
 */
public class CmtInfoFactory {
    String cmtorName;//评论者昵称
    Integer articleId;//被评论的文章
    Integer replyId;//回复给谁
    String replyDateTime;//回复时间
    String cmtText;//回复内容
    String cmtorEmail;//评论者邮箱
    String cmtorMainPage;//评论者主页

    public CmtInfoFactory() {
    }

    public CmtInfoFactory(String cmtorName, Integer articleId, Integer replyId, String replyDateTime,
                          String cmtText, String cmtorEmail, String cmtorMainPage) {
        this.setCmtorName(cmtorName);
        this.setArticleId(articleId);
        this.setReplyId(replyId);
        this.setReplyDateTime(replyDateTime);
        this.setCmtText(cmtText);
        this.setCmtorEmail(cmtorEmail);
        this.setCmtorMainPage(cmtorMainPage);
    }

    public String getCmtorName() {
        return cmtorName;
    }

    public void setCmtorName(String cmtorName) {
        this.cmtorName = cmtorName;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyDateTime() {
        return replyDateTime;
    }

    public void setReplyDateTime(String replyDateTime) {
        this.replyDateTime = replyDateTime;
    }

    public String getCmtText() {
        return cmtText;
    }

    public void setCmtText(String cmtText) {
        this.cmtText = cmtText;
    }

    public String getCmtorEmail() {
        return cmtorEmail;
    }

    public void setCmtorEmail(String cmtorEmail) {
        this.cmtorEmail = cmtorEmail;
    }

    public String getCmtorMainPage() {
        return cmtorMainPage;
    }

    public void setCmtorMainPage(String cmtorMainPage) {
        this.cmtorMainPage = cmtorMainPage;
    }

    public ICmtInfo getCmtInfo(){
        return null;
    }

}
