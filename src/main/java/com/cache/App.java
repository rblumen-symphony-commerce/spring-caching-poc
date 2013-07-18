package com.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
                
        HelloWorld hw1 = (HelloWorld) context.getBean("hello");
        HelloWorld hw2 = (HelloWorld) context.getBean("hey");
        
        CacheManager mgr = (CacheManager) context.getBean("cacheManager");
        Cache cache = mgr.getCache("stuff"); 

        cache.clear();
        App app = new App();
        app.ruly(hw1);
        //cache.clear();
        app.ruly(hw1);
        // app.longDist(hw2);
    }

    void ruly(HelloWorld hw) {
    	System.out.println("RULY");
        String v1= hw.getRulyComplicated(true, 7);
        System.out.println("first v of ruly v1=" + v1);
                
        String v2= hw.getRulyComplicated(true, 11);
        System.out.println("second v of ruly, should be same as first v2=" + v2); 

        hw.hello();

        String v3= hw.getRulyComplicated(true, 7);
        System.out.println("should have new value of ruly v3=" + v3); 

        String v4= hw.getRulyComplicated(true, 11);
        System.out.println("should repeat new value of ruly v4=" + v4); 
    }

    void longDist(HelloWorld hw) {
    	System.out.println("LONG DIST");
        String v1= hw.getLongDistance();
        System.out.println("first v of ld y1=" + v1);
                
        String v2= hw.getLongDistance();
        System.out.println("second v of ld y2=" + v2); 

        hw.hello();

        String v3= hw.getLongDistance();
        System.out.println("third v of ld y3=" + v3); 

        String v4= hw.getLongDistance();
        System.out.println("fourth v of ld y4=" + v4); 

        hw.bye();

        v3= hw.getLongDistance();
        System.out.println("should have new ld y5=" + v3); 

        v4= hw.getLongDistance();
        System.out.println("should repeat ld y5 y6=" + v4); 
        
    }

}
