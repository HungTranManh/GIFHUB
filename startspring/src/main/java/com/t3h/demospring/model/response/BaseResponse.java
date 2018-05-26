package com.t3h.demospring.model.response;

/**
 * Created by Lap trinh on 5/20/2018.
 */
public class BaseResponse {
    public static final int SUCCESS = 0;
    public static final int ERROR_PARAM = 1;

    private int code;
    private String msg;
    private Object data;

    //thanh cong
    public BaseResponse(Object data) {
        this.data = data;
        code = SUCCESS;
        msg = "SUCCESS";
    }

    //khong thanh cong
    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
