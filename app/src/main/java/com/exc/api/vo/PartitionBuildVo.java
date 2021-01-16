package com.exc.api.vo;

public class PartitionBuildVo {

    /**
     * name : 航发集团
     */

    private String name;
    private int id;
    private boolean select;

    public boolean isSelect() {
        return select;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
