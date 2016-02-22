package net.blf2.model.article.info;

import net.blf2.model.article.staticfile.ArticleStatus;
import net.blf2.model.article.staticfile.IArticleInfo;

/**
 * Created by blf2 on 16-1-31.
 * 文章信息类
 */
public class ArticleInfo implements IArticleInfo{
    private Integer articleId;//文章id
    private String articleTitle;//文章标题
    private Integer writerId;//作者id
    private String articleText;//文章主体
    private String publishDateTime;//发表时间
    private ArticleStatus articleStatus;//文章状态  已发表 草稿箱 垃圾箱

    public ArticleInfo() {
    }

    public ArticleInfo(String articleTitle, Integer writerId, String articleText, String publishDateTime, ArticleStatus articleStatus) {
        this.articleTitle = articleTitle;
        this.writerId = writerId;
        this.articleText = articleText;
        this.publishDateTime = publishDateTime;
        this.articleStatus = articleStatus;
    }

    @Override
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    @Override
    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public String getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(String publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    @Override
    public ArticleStatus getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(ArticleStatus articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Boolean isPublished(){
        return this.articleStatus.isPublished();
    }
    public Boolean isDrafts(){
        return this.articleStatus.isDrafts();
    }
    public Boolean isDustbin(){
        return this.articleStatus.isDustbin();
    }
}
