package main;

/**
 * @author yscredit
 */
public class myMain {
    public static void main(String[] args) throws InterruptedException {
        MemUsage memUsage = new MemUsage();
        CpuUsage cpuUsage = new CpuUsage();
        IoUsage ioUsage = new IoUsage();
        while(true){
            System.out.println("=====================");
            System.out.println(memUsage.get());
            System.out.println("=====================");
            System.out.println(cpuUsage.get());
            System.out.println("=====================");
            System.out.println(ioUsage.get());
            Thread.sleep(5000);
        }
    }
}
