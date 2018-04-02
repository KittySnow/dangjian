package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 17:05 2018/3/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomMenuServiceImplTest {

    @Autowired
    private CustomMenuService customMenuService;

    @Test
    public void test() {
        String testStr = "{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
        try {
            BaseMpApiResponse baseMpApiResponse = customMenuService.createMenu(testStr);
            Assert.assertNotEquals(baseMpApiResponse.getErrcode(), Integer.valueOf(0));
        } catch (DangjianException e) {
            e.printStackTrace();
        }
    }

}
