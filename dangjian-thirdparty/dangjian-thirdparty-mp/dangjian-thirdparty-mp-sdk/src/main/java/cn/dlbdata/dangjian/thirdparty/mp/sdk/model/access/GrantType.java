package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access;

import cn.dlbdata.dangjian.common.wrapped.EnumDescriptor;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 0:53 2018/3/25
 */
public enum GrantType implements EnumDescriptor {

    /**
     * 获取access_token填写client_credential
     */
    client_credential(1, "获取access_token");

    private int value;
    private String description;

    GrantType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
