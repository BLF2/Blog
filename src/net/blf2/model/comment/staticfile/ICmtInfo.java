package net.blf2.model.comment.staticfile;

/**
 * Created by blf2 on 16-2-11.
 * 评论类接口
 */
public interface ICmtInfo {
    Integer getCmtId();
    String getCmtorName();
    Integer getArticleId();
    Integer getReplyId();
    String getReplyDateTime();
    String getCmtText();
    String getCmtorEmail();
    String getCmtorMainPage();
}
