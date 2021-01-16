package com.exc.api.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

public class ListBuildingVo {

    /**
     * addr : 临江大道附近
     * buildingTypeSn : 4
     * city : 武汉市
     * description : 怡江苑1
     * district : 青山区
     * id : 182
     * isKey : 0
     * latitude : 30.622571
     * longitude : 114.359222
     * name : 青山怡江苑A栋
     * num : YJY01
     * partitionId : 19
     * province : 湖北省
     * quantity : 1
     */

    private List<BuildingListBean> buildingList;

    public List<BuildingListBean> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingListBean> buildingList) {
        this.buildingList = buildingList;
    }
    @Entity(tableName = "buildingDetail")
    public static class BuildingListBean {
        @PrimaryKey
        private int id;
        private String addr;
        private int buildingTypeSn;
        private String city;
        private String description;
        private String district;
        private int isKey;
        private double latitude;
        private double longitude;
        private String name;
        private String num;
        private int partitionId;
        private String province;
        private int quantity;
        private int isOnline;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getBuildingTypeSn() {
            return buildingTypeSn;
        }

        public void setBuildingTypeSn(int buildingTypeSn) {
            this.buildingTypeSn = buildingTypeSn;
        }

        public int getIsOnline(){
            return isOnline;
        }

        public void setIsOnline(int isOnline){
            this.isOnline = isOnline;
        }
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsKey() {
            return isKey;
        }

        public void setIsKey(int isKey) {
            this.isKey = isKey;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public int getPartitionId() {
            return partitionId;
        }

        public void setPartitionId(int partitionId) {
            this.partitionId = partitionId;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
