package net.blf2.model.articletag.info;

/**
 * Created by blf2 on 16-2-21.
 * 文章属于某个标签的类
 */
public class ArticleTag {
    Integer acId;//为数据库主键 实际意义不大
    Integer articleId;//文章ID
    Integer tagId;//标签ID

    public ArticleTag() {
    }

    public ArticleTag(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
