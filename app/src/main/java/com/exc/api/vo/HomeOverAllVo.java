package com.exc.api.vo;

import java.util.List;

public class HomeOverAllVo {

    private int number;
    private double energy;
    /**
     * name : 总控区
     * building : [{"buildingTypeSn":3,"electricityNodes":[],"id":2710,"masterNodes":[],"name":"测试建筑物（联机）","nodes":[],"num":"LJJZW","partitionId":1,"quantity":1,"sites":[]},{"buildingTypeSn":6,"electricityNodes":[],"id":2711,"masterNodes":[{"id":750,"isOffline":1}],"name":"测试建筑物（动态）","nodes":[],"num":"DTJZW","partitionId":1,"quantity":0,"sites":[]},{"buildingTypeSn":5,"electricityNodes":[],"id":2712,"masterNodes":[],"name":"测试建筑物（开关）","nodes":[],"num":"KGJZW","partitionId":1,"quantity":1,"sites":[]},{"buildingTypeSn":3,"electricityNodes":[],"id":3058,"masterNodes":[],"name":"沌口媒体中心","nodes":[],"num":"MTZX1","partitionId":1,"quantity":1,"sites":[]}]
     */

    private List<PartitionBean> partition;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public List<PartitionBean> getPartition() {
        return partition;
    }

    public void setPartition(List<PartitionBean> partition) {
        this.partition = partition;
    }

    public static class PartitionBean {
        private String name;
        /**
         * buildingTypeSn : 3
         * electricityNodes : []
         * id : 2710
         * masterNodes : []
         * name : 测试建筑物（联机）
         * nodes : []
         * num : LJJZW
         * partitionId : 1
         * quantity : 1
         * sites : []
         */

        private List<BuildingBean> building;

        private String centralPoint;

        private String coordinate;

        public int count;

        public int bgColor;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCentralPoint() {
            return centralPoint;
        }

        public void setCentralPoint(String centralPoint) {
            this.centralPoint = centralPoint;
        }

        public String getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }

        public String getName() {
            return name;
        }

        public int getBgColor() {
            return bgColor;
        }

        public void setBgColor(int bgColor) {
            this.bgColor = bgColor;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<BuildingBean> getBuilding() {
            return building;
        }

        public void setBuilding(List<BuildingBean> building) {
            this.building = building;
        }

        public static class BuildingBean {
            private int buildingTypeSn;
            private int id;
            private String name;
            private String num;
            private int partitionId;
            private int quantity;
            private float latitude;
            private float longitude;

            public float getLatitude() {
                return latitude;
            }

            public void setLatitude(float latitude) {
                this.latitude = latitude;
            }

            public float getLongitude() {
                return longitude;
            }

            public void setLongitude(float longitude) {
                this.longitude = longitude;
            }

            public int getBuildingTypeSn() {
                return buildingTypeSn;
            }

            public void setBuildingTypeSn(int buildingTypeSn) {
                this.buildingTypeSn = buildingTypeSn;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }
    }
}
