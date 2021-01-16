package com.exc.api.vo;

import java.util.List;

public class SjcityvideogetVo {


    /**
     * addr : 东风大道111号
     * becompleted : 1607479037000
     * buildingTypeSn : 3
     * city : 武汉市
     * control : AAA
     * description : 沌口四标万达广场4#
     * district : 蔡甸区
     * electricityNodes : []
     * id : 6
     * imageList : [{"buildingNum":"W0038","createTime":1606789016000,"fileType":"jpg","id":125,"photoName":"a23aabd0-4e31-4115-8c48-4ffc9400517c","realName":"22.jpg","type":1},{"buildingNum":"W0038","createTime":1606789020000,"fileType":"jpg","id":126,"photoName":"e56bea29-2be6-4ceb-b261-3532ee2c42f8","realName":"11.jpg","type":1},{"buildingNum":"W0038","createTime":1606789023000,"fileType":"jpg","id":127,"photoName":"326d4a65-2ff2-4ab0-9062-5c2955ad887c","realName":"19.jpg","type":1},{"buildingNum":"W0038","createTime":1606789027000,"fileType":"jpg","id":128,"photoName":"5c8d8875-adee-4666-8cc3-5ead8d621155","realName":"1.jpg","type":1},{"buildingNum":"W0038","createTime":1606789030000,"fileType":"jpg","id":129,"photoName":"9f1f2275-3200-4833-a9c7-328b98cc6757","realName":"5.jpg","type":1},{"buildingNum":"W0038","createTime":1606789034000,"fileType":"jpg","id":130,"photoName":"391ec044-4be9-4d07-8df3-4af95290aee0","realName":"9.jpg","type":1}]
     * isKey : 0
     * latitude : 22.54046422124227
     * longitude : 114.08615112304689
     * masterNodes : []
     * name : 沌口四标万达广场4号楼
     * nodes : []
     * num : W0038
     * partitionId : 3
     * power : 1000
     * province : 湖北省
     * quantity : 1
     * sites : []
     */

    private BuildingBean building;
    /**
     * addr : 东风大道111号
     * city : 武汉市
     * controller : 0
     * district : 蔡甸区
     * ip : 10.10.96.30
     * isOffline : 1
     * name : 经开万达广场4#
     * num : L0010
     * ports : 2012
     * videoList : []
     */

    private List<NodeListBean> nodeList;

    public BuildingBean getBuilding() {
        return building;
    }

    public void setBuilding(BuildingBean building) {
        this.building = building;
    }

    public List<NodeListBean> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<NodeListBean> nodeList) {
        this.nodeList = nodeList;
    }

    public static class BuildingBean {
        private String addr;
        private long becompleted;
        private int buildingTypeSn;
        private String city;
        private String control;
        private String description;
        private String district;
        private int id;
        private int isKey;
        private double latitude;
        private double longitude;
        private String name;
        private String num;
        private int partitionId;
        private String power;
        private String province;
        private int quantity;
        private List<?> electricityNodes;
        /**
         * buildingNum : W0038
         * createTime : 1606789016000
         * fileType : jpg
         * id : 125
         * photoName : a23aabd0-4e31-4115-8c48-4ffc9400517c
         * realName : 22.jpg
         * type : 1
         */

        private List<ImageListBean> imageList;
        private List<?> masterNodes;
        private List<?> nodes;
        private List<?> sites;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public long getBecompleted() {
            return becompleted;
        }

        public void setBecompleted(long becompleted) {
            this.becompleted = becompleted;
        }

        public int getBuildingTypeSn() {
            return buildingTypeSn;
        }

        public void setBuildingTypeSn(int buildingTypeSn) {
            this.buildingTypeSn = buildingTypeSn;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getControl() {
            return control;
        }

        public void setControl(String control) {
            this.control = control;
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

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
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

        public List<?> getElectricityNodes() {
            return electricityNodes;
        }

        public void setElectricityNodes(List<?> electricityNodes) {
            this.electricityNodes = electricityNodes;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public List<?> getMasterNodes() {
            return masterNodes;
        }

        public void setMasterNodes(List<?> masterNodes) {
            this.masterNodes = masterNodes;
        }

        public List<?> getNodes() {
            return nodes;
        }

        public void setNodes(List<?> nodes) {
            this.nodes = nodes;
        }

        public List<?> getSites() {
            return sites;
        }

        public void setSites(List<?> sites) {
            this.sites = sites;
        }

        public static class ImageListBean {
            private String buildingNum;
            private long createTime;
            private String fileType;
            private int id;
            private String photoName;
            private String realName;
            private int type;
            private boolean isSelect;

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

            public boolean getSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }
        }
    }

    public static class NodeListBean {
        private String addr;
        private String city;
        private int controller;
        private String district;
        private String ip;
        private int isOffline;
        private String name;
        private String num;
        private String ports;
        private List<?> videoList;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getController() {
            return controller;
        }

        public void setController(int controller) {
            this.controller = controller;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getIsOffline() {
            return isOffline;
        }

        public void setIsOffline(int isOffline) {
            this.isOffline = isOffline;
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

        public String getPorts() {
            return ports;
        }

        public void setPorts(String ports) {
            this.ports = ports;
        }

        public List<?> getVideoList() {
            return videoList;
        }

        public void setVideoList(List<?> videoList) {
            this.videoList = videoList;
        }
    }
}
