package ru.job4j.models;
/**
 * Item.
 * @author Valeriy Labunets (vavilonw@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {

    private String id;
    public String name;
    public String desc;
    public long created;
    public String[] comments;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc() {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated() {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments() {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
