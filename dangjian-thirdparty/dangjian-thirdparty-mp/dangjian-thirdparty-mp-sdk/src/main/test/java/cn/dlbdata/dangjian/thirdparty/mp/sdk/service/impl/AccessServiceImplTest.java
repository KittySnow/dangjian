package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 16:12 2018/3/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessServiceImplTest {
    @Autowired
    private AccessService accessService;

    @Test
    public void test() {
        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        try {
            AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
            Assert.assertNotNull(accessTokenResponse.getAccessToken());
        } catch (DangjianException e) {
            e.printStackTrace();
        }
    }
}
