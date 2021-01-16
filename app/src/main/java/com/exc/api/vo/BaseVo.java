package com.exc.api.vo;

/**
 * .ClassName: BaseVo(实体类基类) <br/>
 * date: 2018年10月10日 下午5:00:05 <br/>
 *
 * @author liuxin136
 */
public class BaseVo<T> {

    /**
     * 返回code值
     */
    private int code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * data对象
     */
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
