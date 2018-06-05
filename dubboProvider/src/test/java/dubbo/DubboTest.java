package dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Test;

/**
 * Created by linzhipeng on 2018/2/3.
 */
public class DubboTest {

    @Test
    public void test3(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("aissueInterface");
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
        Object obj = genericService.$invoke("", new String[] {}, new Object[] {});
        System.out.println(obj.toString());
    }



}
