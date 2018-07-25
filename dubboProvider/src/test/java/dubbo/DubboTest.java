package dubbo;

import com.aissue.entity.Student;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by wangkun on 2018/2/3.
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

        Student student = new Student("aissue","175cm","男","140834");
        Map<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        try{

        }catch (Exception e){

        }
        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object obj = genericService.$invoke("abc", new String[] {"invokeType","myObject","Student"},
                new Object[] {"DUBBO",map,student});
        System.out.println(obj.toString());
    }



}
