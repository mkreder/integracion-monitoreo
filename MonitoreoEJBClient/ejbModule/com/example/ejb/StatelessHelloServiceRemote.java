package com.example.ejb;

import javax.ejb.Remote;

@Remote
public interface StatelessHelloServiceRemote {
    public String sayHello(String name);

}
