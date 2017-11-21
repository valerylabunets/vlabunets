package ru.job4j.tracker;

public class Item {

    private String id;
    public String name;
    public String desc;
    public long created;
    public String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
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
