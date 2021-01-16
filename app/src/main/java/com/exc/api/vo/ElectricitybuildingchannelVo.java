package com.exc.api.vo;

import java.util.List;

public class ElectricitybuildingchannelVo {
    /**
     * defaultNum : 0
     * nodeNames : []
     * successNum : 1
     */

    private int defaultNum;
    private int successNum;
    private List<?> nodeNames;

    public int getDefaultNum() {
        return defaultNum;
    }

    public void setDefaultNum(int defaultNum) {
        this.defaultNum = defaultNum;
    }

    public int getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    public List<?> getNodeNames() {
        return nodeNames;
    }

    public void setNodeNames(List<?> nodeNames) {
        this.nodeNames = nodeNames;
    }
}
