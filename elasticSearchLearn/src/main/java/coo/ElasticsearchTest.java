package coo;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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

    /**
     * 创建连接
     * @throws UnknownHostException
     */
    @Before
    public void before() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        logger.info("Elasticsearch connect info ---->:" + client.toString());
    }

    /**
     * 关闭连接
     */
    @After
    public void after(){
        if(client!=null){
            client.close();
            logger.info("关闭连接...");
        }
    }

    /**
     * 创建索引1
     */
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

    /**
     * 创建索引2
     * @throws IOException
     */
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

    /**
     * 添加数据,单条
     */
    @Test
    public void insert_single() throws ExecutionException, InterruptedException {
        Map<String,Object> resource = new HashMap<>();
        resource.put("empname","王小二");
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("dept","employee");

        IndexResponse indexResponse = indexRequestBuilder.setSource(resource).execute().get();
        System.out.println(indexResponse);
    }

    /**
     * 添加数据,批量
     */
    @Test
    public void insert_multi(){
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        IndexRequestBuilder index1 = client.prepareIndex("dept","employee");
        IndexRequestBuilder index2 = client.prepareIndex("dept","employee");

        Map<String,Object> resource1 = new HashMap<>();
        resource1.put("empname","王小三");

        Map<String,Object> resource2 = new HashMap<>();
        resource2.put("empname","王小四");

        index1.setSource(resource1);
        index2.setSource(resource2);

        BulkResponse bulkResponse = bulkRequest.add(index1).add(index2).get();

        if(bulkResponse.hasFailures()) {
            System.out.println(bulkResponse.buildFailureMessage());
        }

        bulkResponse.forEach(response ->{
            System.out.println(response.getId());
        });


    }

    /**
     * 查询数据
     */
    @Test
    public void search(){
        /*1、根据ID查询
        GetResponse response = client.prepareGet("dept","employee","1").get();
        System.out.println(response.toString());*/



    }
}
