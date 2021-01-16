package com.exc.api.vo;

public class PartitionhomenewVo {


    /**
     * dataSource : 1
     * description : 武汉市新洲区
     * offlineNum : 13
     * offlineRate : 25
     * onlineNum : 72
     * onlineRate : 75
     * totalEnergy : 0.0
     * totalNum : 96
     */

    private int dataSource;
    private String description;
    private int offlineNum;
    private int offlineRate;
    private int onlineNum;
    private int onlineRate;
    private double totalEnergy;
    private int totalNum;

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOfflineNum() {
        return offlineNum;
    }

    public void setOfflineNum(int offlineNum) {
        this.offlineNum = offlineNum;
    }

    public int getOfflineRate() {
        return offlineRate;
    }

    public void setOfflineRate(int offlineRate) {
        this.offlineRate = offlineRate;
    }

    public int getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(int onlineNum) {
        this.onlineNum = onlineNum;
    }

    public int getOnlineRate() {
        return onlineRate;
    }

    public void setOnlineRate(int onlineRate) {
        this.onlineRate = onlineRate;
    }

    public double getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(double totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
