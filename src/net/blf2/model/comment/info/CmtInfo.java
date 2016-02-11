package net.blf2.model.comment.info;

import net.blf2.model.comment.staticfile.ICmtInfo;

/**
 * Created by blf2 on 16-2-11.
 * 评论信息类
 */
public class CmtInfo implements ICmtInfo{
    Integer cmtId;//本条评论的id
    String cmtorName;//评论者昵称
    Integer articleId;//被评论的文章
    Integer replyId;//回复给谁
    String replyDateTime;//回复时间
    String cmtText;//回复内容
    String cmtorEmail;//评论者邮箱
    String cmtorMainPage;//评论者主页

    public CmtInfo() {
    }

    public CmtInfo(String cmtorName, Integer articleId, Integer replyId, String replyDateTime,
                   String cmtText, String cmtorEmail, String cmtorMainPage) {
        this.cmtorName = cmtorName;
        this.articleId = articleId;
        this.replyId = replyId;
        this.replyDateTime = replyDateTime;
        this.cmtText = cmtText;
        this.cmtorEmail = cmtorEmail;
        this.cmtorMainPage = cmtorMainPage;
    }

    public Integer getCmtId() {
        return cmtId;
    }

    public void setCmtId(Integer cmtId) {
        this.cmtId = cmtId;
    }

    @Override
    public String getCmtorName() {
        return cmtorName;
    }

    public void setCmtorName(String cmtorName) {
        this.cmtorName = cmtorName;
    }

    @Override
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    @Override
    public String getReplyDateTime() {
        return replyDateTime;
    }

    public void setReplyDateTime(String replyDateTime) {
        this.replyDateTime = replyDateTime;
    }

    @Override
    public String getCmtText() {
        return cmtText;
    }

    public void setCmtText(String cmtText) {
        this.cmtText = cmtText;
    }

    @Override
    public String getCmtorEmail() {
        return cmtorEmail;
    }

    public void setCmtorEmail(String cmtorEmail) {
        this.cmtorEmail = cmtorEmail;
    }

    @Override
    public String getCmtorMainPage() {
        return cmtorMainPage;
    }

    public void setCmtorMainPage(String cmtorMainPage) {
        this.cmtorMainPage = cmtorMainPage;
    }
}
