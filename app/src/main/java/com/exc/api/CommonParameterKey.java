package com.exc.api;

import java.util.List;

/**
 * 公共请求参数Key
 * Created By zhangyup72 At 2019-08-09
 */
public class CommonParameterKey {
    public static final String USERNAME = "username";  //用户名
    public static final String PASSWORD = "password";  //密码
    public static final String TYPE = "type";   //类型1分区，2站点，3建筑物
    public static final String NAME = "name";   //站点，分区，建筑名称
    public static final String ID = "id";       //ID数组
    public static final String CHANNELTYPEID = "channelTypeId"; //回路类型id 全关/全开传0 全部设置为0
    public static final String STATE = "state"; //开关状态: 0关 1开
    public static final String BUILDINGNUM = "buildingNum"; //建筑物编号
    public static final String FILETYPE = "type"; //文件类型 1 图片 2文档 （固定为1）
    public static final String FILE = "file";   //文件
    public static final String BUILDINGID = "buildingId"; //建筑ID
    public static final String DURATION = "duration";//播放时长
    public static final String FILENAME = "filename";//节目名称
    public static final String VIDNAME = "vidName";//节目名称
    public static final String NODEID = "nodeId";//节点ID
    public static final String SITEIDARRAY = "siteIdArray";//节点组id数组
    public static final String PARTITIONID = "partitionId";//分区ID
}
