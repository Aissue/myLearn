package main;

public class ExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.println("begin...");
            throw new RuntimeException("123456");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("==========");
    }
}
