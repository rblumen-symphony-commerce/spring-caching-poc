package com.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Spring bean
 * 
 */
public class HelloWorld {
    private String name;
 
    public void setName(String name) {
        this.name = name;
    }
        
    //@Cacheable(value="stuff", key="#root.target.hashCode()")
    @Cacheable("stuff")
    public String getRulyComplicated(boolean flag, @IgnoreCacheKey int ignore) {
        String value = new Double(Math.random() * 1000.0).toString(); 
        logr("calculating ruly complicated thang=" + value);
        return value ;
    }
        
    //@Cacheable(value="other-stuff", key="#root.target.hashCode()")
    @Cacheable("other-stuff")
    public String getLongDistance() {
        String value = new Double(Math.random() * 1000.0).toString(); 
        logr("calculating long distance=" + value);
        return value ;
    }

    @CacheEvict(value="stuff", allEntries = true)
    public void hello() {
        logr("evicted stuff");
    }
        
    @CacheEvict(value="other-stuff", allEntries = true)
    public void bye() {
        logr("evicting other-stuff");
    }

    private void logr(String s) {
        System.out.println("[" + this.name + "]: " + s);
    }

    public int hashCode() {
        int hc = name.hashCode();
        //logr("hashing=" + hc);
        return hc; 
    }


}