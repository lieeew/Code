package com.yupi.user_center.service;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author leikooo
 * @create 2023-08-31 16:22
 * @Package com.yupi.user_center.service
 * @Description
 */
@SpringBootTest
public class YuCongMingTest {

    @Resource
    private YuCongMingClient client;

    @Test
    public void message() {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1656451952516644865L);
        devChatRequest.setMessage("给我推荐一下机甲类型的番剧");

        // 获取响应
        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        System.out.println(response.getData());
    }

}
