package dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTest {
    @Test
    public void test(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("3zbDJGceQd42n1z8");
//        reference.setInterface("3zbDJGceQd42n1z8");
//        reference.setInterface("4xQ1w4fPWV4490b8");
        reference.setVersion("1.1.1");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.40.14:2181");
        reference.setRegistry(registryConfig);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("openApi");
        reference.setApplication(applicationConfig);
        // 声明为泛化接口
        reference.setGeneric(true);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        // 基本类型以及Date,List,Map等不需要转换，直接调用
//        Object obj = genericService.$invoke("sayHello", new String[] {"APP_KEY"}, new Object[] {"8107b83292a44176b2a3a36a205e3a2d"});
        Object obj = genericService.$invoke("sayHello", null,null);

    }
}
