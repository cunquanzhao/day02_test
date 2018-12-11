package com.itheima.test;

import com.itheima.utils.EsUtil;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;

import java.io.IOException;

/**
 * Name: MappingsTest
 * User: zhaocq
 * Date: 2018/12/5 0005
 * Time: 11:45
 * Description:TODO  映射相关的操作
 */
public class MappingsTest {

    /* *
     * @Author zhaocq
     * @Description //TODO  添加映射 约束
     * @Date 11:46 2018/12/5 0005
     * @Param []
     * @return void
     **/
    @Test
    public void test() throws Exception {

        // 创建客户端连接对象
        TransportClient client = EsUtil.createTransportClient();
        // 构建映射文档
        /* *
        * 格式：
              "mappings" : {
                 "article" : {
                     "properties" : {
                         "id" : { "type" : "string" },
                         "title" : { "type" : "string" },
                         "content" : { "type" : "string" }
                     }
                 }
             }
         **/
        // 创建索引
        client.admin().indices().prepareCreate("blog2").get();
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id")
                .field("store", true)
                .field("type", "string")
                .endObject()
                .startObject("title")
                .field("store", true)
                .field("type", "string")
                .field("analyzer", "ik_smart")
                .endObject()
                .startObject("content")
                .field("store", true)
                .field("type", "string")
                .field("analyzer", "ik_smart")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        // 创建映射并且添加映射文档
        PutMappingRequest mappingRequest = Requests.putMappingRequest("blog2")
                .type("article").source(builder);

        client.admin().indices().putMapping(mappingRequest).get();
        // 关闭资源
        client.close();
    }
}
