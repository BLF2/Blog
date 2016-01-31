package net.blf2.model.article.staticfile;

/**
 * Created by blf2 on 16-1-31.
 * ArticleInfo类中文章状态的枚举类
 */
public enum ArticleStatus {
    published,drafts,dustbin;//已发表，草稿箱，垃圾箱

    public Boolean isPublished(){
        if(this == published)
            return true;
        return false;
    }
    public Boolean isDrafts(){
        if(this == drafts)
            return true;
        return false;
    }
    public Boolean isDustbin(){
        if(this == dustbin)
            return true;
        return false;
    }
}
