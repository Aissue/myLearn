package coo;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class ElasticsearchTest {
    public final static Logger logger = LoggerFactory.getLogger(ElasticsearchTest.class);

    public final static String HOST = "192.168.248.130";
    public final static int PORT = 9300;

    public TransportClient client = null;

    /**
     * 连接测试
     * @throws UnknownHostException
     */
//    @Test
    public void test1() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT)
        );
        logger.info("Elasticsearch connect info ---->:" + client.toString());
        client.close();
    }

    @Before
    public void before() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        logger.info("Elasticsearch connect info ---->:" + client.toString());
    }

    @After
    public void after(){
        if(client!=null){
            client.close();
            logger.info("关闭连接...");
        }
    }

    @Test
    public void createIndex(){
        IndexRequestBuilder requestBuilder = client.prepareIndex();
        requestBuilder.setIndex("invokelog").setType("invokelog").setSource("", XContentType.JSON);
        //获取索引结果
        IndexResponse response = requestBuilder.get();
        if(response.status() == RestStatus.CREATED){
            logger.info("interfaceInvokeLog创建成功!");
        }
    }

    @Test
    public void createIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
                .startObject().field("userName", "张三")
                .field("sendDate", new Date())
                .field("msg", "你好李四")
                .endObject()).get();

        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }
}
