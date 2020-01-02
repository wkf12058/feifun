package com.fun.feifun.base.result;

import java.io.Serializable;

/***
 * 业务代码接口
 *
 */
public interface IReMsg extends Serializable {
    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();
}
