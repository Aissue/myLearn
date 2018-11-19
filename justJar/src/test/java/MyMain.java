import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyMain {
    @Test
    public void test1(){
        String str = "APP_KEY=:APP_KEY or abb=:edf and (a=:c and e=:d) or f<=:g and i>=:x";
        String b = str.replaceAll("or","").replaceAll("and","")
                .replaceAll("\\(","").replaceAll("\\)","").replaceAll(">","")
                .replaceAll("<","");
        String[] a = b.split("\\s+");
        Set<String> set = new HashSet<String>();
        for(String s : a){
            System.out.println(s);
            String[] x = s.split("=:");
            set.add(x[0].toLowerCase());
        }
        for (String y : set){
            System.out.println("=="+y);
        }

    }
}
