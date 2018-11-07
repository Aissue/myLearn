package coo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticsearchTest {

    public final static String HOST = "192.168.248.130";
    public final static int PORT = 9300;

    @Test
    public void test1() throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT)
        );

        System.out.println("Elasticsearch connect info:" + client.toString());
        client.close();
    }
}
