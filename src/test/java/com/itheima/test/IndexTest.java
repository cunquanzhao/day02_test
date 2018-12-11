package com.itheima.test;

import com.itheima.utils.EsUtil;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

/**
 * Name: IndexTest
 * User: zhaocq
 * Date: 2018/12/5 0005
 * Time: 11:36
 * Description: TODO 索引相关的操作 （自定义索引库）
 */
public class IndexTest {

    /* *
     * @Author zhaocq
     * @Description //TODO 创建索引
     * @Date 11:37 2018/12/5 0005
     * @Param []
     * @return void
     **/
    @Test
    public void test(){
        int aa = 11;
        int bb = 12;
        // 创建客户端连接对象
        TransportClient client = EsUtil.createTransportClient();
        // 创建索引
        client.admin().indices().prepareCreate("blog3").get();
        // 关闭资源
        client.close();
    }


}
