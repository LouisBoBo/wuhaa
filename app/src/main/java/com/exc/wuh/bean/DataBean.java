package com.exc.wuh.bean;

import com.exc.api.ApiUrl;
import com.exc.api.vo.SjcityvideogetVo;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getTestData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("http://192.168.112.78:9702/a23aabd0-4e31-4115-8c48-4ffc9400517c.jpg", "相信自己,你努力的样子真的很美", 0));
        list.add(new DataBean("http://m.imeitou.com/uploads/allimg/2020111111/gaex0puq4fb.jpg", "极致简约,梦幻小屋", 0));
        list.add(new DataBean("http://m.imeitou.com/uploads/allimg/2020111111/1wflsnxka1v.jpg", "超级卖梦人", 0));
        list.add(new DataBean("http://192.168.112.78:9702/a23aabd0-4e31-4115-8c48-4ffc9400517c.jpg", "夏季新搭配", 0));
        list.add(new DataBean("http://m.imeitou.com/uploads/allimg/2020111111/2eud2juct0d.jpg", "绝美风格搭配", 0));
        list.add(new DataBean("http://m.imeitou.com/uploads/allimg/180611/3-1P611111634-53.jpg", "微微一笑 很倾城", 0));
        return list;
    }

    public static List<DataBean> setDatas(List<SjcityvideogetVo.BuildingBean.ImageListBean> imageListBeans){
        List<DataBean> list = new ArrayList<>();
        for(SjcityvideogetVo.BuildingBean.ImageListBean bean : imageListBeans){
            String url = ApiUrl.SERVICES_ADDRESS + bean.getPhotoName() + "." + bean.getFileType();
            list.add(new DataBean(url,bean.getRealName(),0));
        }
        return list;
    }
}
