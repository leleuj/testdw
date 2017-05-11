package org.leleuj.testdw.test;

import org.leleuj.testdw.Util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Main {

    public static void main(String... args) throws Exception {
        final Client client = ClientBuilder.newClient();
        while (true) {
            client.target("http://localhost:8080").request().method("GET").getStatus();
            Util.sleep(500 + Util.random(2000));
        }
    }
}
