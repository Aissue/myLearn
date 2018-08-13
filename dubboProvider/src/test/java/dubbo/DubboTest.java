package dubbo;

import com.InterReqtVo;
import com.aissue.entity.InterRespVo;
import com.aissue.entity.Student;
import com.aissue.exception.ProviderException;
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

    @Test
    public void test2(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("OccupancyWoodlandLicense");
        reference.setVersion("1.1.1");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.248.129:2181");
        reference.setRegistry(registryConfig);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("openApi");
        reference.setApplication(applicationConfig);
        // 声明为泛化接口
        reference.setGeneric(true);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        //组装调用参数
        String[] paramNames = {"interRequestVo"};


        InterReqtVo interReqtVo = new InterReqtVo();
        interReqtVo.setRequestId("abcdefghijklmnopqrdt");
        Map<String,Object> params = new HashMap<>();
        params.put("name","Aissue");
        interReqtVo.setParams(params);


        Object[] paramValues = {interReqtVo};

        Object obj =null;
        try{
            obj = genericService.$invoke("",paramNames,paramValues);
        }catch (Exception e){
            throw new ProviderException("45",e.getMessage());
        }

        System.out.println(obj);
    }



}
