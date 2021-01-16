package com.exc.api.vo;

public class BuildingphotonumVo {

    /**
     * buildingNum : OJK28
     * createTime : 1603251400000
     * fileType : jpg
     * id : 59
     * photoName : de893f21-424d-4037-b6de-265962d1ea01
     * realName : 基础模式.jpg
     * type : 1
     */

    private String buildingNum;
    private long createTime;
    private String fileType;
    private int id;
    private String photoName;
    private String realName;
    private int type;

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
