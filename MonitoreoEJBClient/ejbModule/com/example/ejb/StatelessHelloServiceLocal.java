package com.example.ejb;

import javax.ejb.Local;

@Local
public interface StatelessHelloServiceLocal {
    public String sayHello(String name);
}
