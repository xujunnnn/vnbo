package com.ebupt.vnbo.service.initialize;

import com.ebupt.vnbo.entity.result.Result;

/**
 * Created by xujun on 2017/10/16.
 */
public interface InitService {
    /**
     * 初始化基本流表
     * @return
     */
    public Result initBaseFlow();

    /**
     * 初始化监控流表
     * @return
     */
    public Result initMonitor() ;
}
