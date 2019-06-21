package com.afs.vulnerable.springbreak.repositories;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class CookieRepository {
    public String getId(String cookie){
        throw new NotImplementedException();
    }
}
