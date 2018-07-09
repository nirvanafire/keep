package top.vkeep.smart.bean;

/**
 * 返回数据独享
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/4
 **/
public class Data {
    /**
     * 数据模型
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
