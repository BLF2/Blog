package net.blf2.model.article.info;

import net.blf2.model.article.DAO.InsertArticle;
import net.blf2.model.article.staticfile.ArticleStatus;
import net.blf2.model.article.staticfile.IArticleInfo;

/**
 * Created by blf2 on 16-1-31.
 * 文章信息类（ArticleInfo）的工厂类
 */
public class ArticleInfoFactory {
    private String articleTitle;//文章标题
    private Integer writerId;//作者id
    private String articleText;//文章主体
    private String publishDateTime;//发表时间
    private ArticleStatus articleStatus;//文章状态  已发表 草稿箱 垃圾箱

    public ArticleInfoFactory() {
    }

    public ArticleInfoFactory(String articleTitle, Integer writerId, String articleText,
                              String publishDateTime, ArticleStatus articleStatus) {
        this.articleTitle = articleTitle;
        this.writerId = writerId;
        this.articleText = articleText;
        this.publishDateTime = publishDateTime;
        this.articleStatus = articleStatus;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        if(articleTitle.length() > 30)
            articleTitle = articleTitle.substring(0,30);
        this.articleTitle = articleTitle;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(String publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    public ArticleStatus getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(ArticleStatus articleStatus) {
        this.articleStatus = articleStatus;
    }

    public IArticleInfo getArticleInfo(){
        return new InsertArticle().insertArticleInfo(new ArticleInfo(this.articleTitle,this.writerId,this.articleText
        ,this.publishDateTime,this.articleStatus));
    }
}
