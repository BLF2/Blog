package net.blf2.model.tag.info;

import net.blf2.model.tag.staticfile.ITagInfo;

/**
 * Created by blf2 on 16-2-1.
 * 标签类
 */
public class TagInfo implements ITagInfo{
    private Integer tagId;
    private String tagName;

    public TagInfo() {
    }

    public TagInfo(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
