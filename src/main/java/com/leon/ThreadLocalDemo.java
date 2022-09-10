package com.leon;

/**
 * @author Leon
 * @since 2021年09月13日 17:06
 **/
public class ThreadLocalDemo {

    static ThreadLocal<String> t = new ThreadLocal<>();
    static String getT(){
      return t.get();
    }
    public static void main(String[] args) {
        runInContext(()->{
            System.out.println(t.get());
        });
    }

    private static void runInContext(Runnable runner){
        try{
            t.set("123");
            runner.run();
        }finally{
            t.remove();
        }
    }
}
