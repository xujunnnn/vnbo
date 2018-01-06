package com.ebupt.vnbo.entity.enums;

/**
 * Created by xujun on 2017/10/16.
 */
public enum RespCode {
    success(200),fail(500);
    private int value;
    RespCode(int value){
        this.value=value;
    }
    public int value(){
        return  this.value;
    }
}
