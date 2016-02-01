package net.blf2.model.tag.info;

import net.blf2.model.tag.DAO.DbInsert;
import net.blf2.model.tag.staticfile.ITagInfo;

/**
 * Created by blf2 on 16-2-1.
 * 标签类的工厂类
 */
public class TagInfoFactory {
    private String tagName;

    public TagInfoFactory() {
    }

    public TagInfoFactory(String tagName) {
        this.setTagName(tagName);
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        if(tagName.length() > 10)
            tagName = tagName.substring(0,10);
        this.tagName = tagName;
    }

    public ITagInfo getTagInfo(){
        return new DbInsert().insertTagInfo(new TagInfo(this.tagName));
    }
}
