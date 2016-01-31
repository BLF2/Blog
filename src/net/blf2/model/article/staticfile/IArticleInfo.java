package net.blf2.model.article.staticfile;

/**
 * Created by blf2 on 16-1-31.
 * ArticleInfo类的接口
 */
public interface IArticleInfo {
    Integer getArticleId();
    String getArticleTitle();
    String getWriterId();
    String getArticleText();
    String getPublishDateTime();
    ArticleStatus getArticleStatus();
    Boolean isPublished();
    Boolean isDrafts();
    Boolean isDustbin();
}
