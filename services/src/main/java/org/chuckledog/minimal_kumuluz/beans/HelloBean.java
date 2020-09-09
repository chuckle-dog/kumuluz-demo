package org.chuckledog.minimal_kumuluz.beans;

import javax.enterprise.context.RequestScoped;
import java.sql.Timestamp;
import java.time.Instant;

@RequestScoped
public class HelloBean {

    public String sayHello(){
        return "Hello Kumuluz at " + Timestamp.from(Instant.now());
    }

}
