package com.itheima.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Name: EsUtil
 * User: zhaocq
 * Date: 2018/12/3 0003
 * Time: 17:50
 * Description:ElasticSearch创建客户端连接对象的工具类
 */
public class EsUtil {

    private static TransportClient client;

    static {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static TransportClient createTransportClient(){
        return client;
    }
}
