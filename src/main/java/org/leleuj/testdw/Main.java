package org.leleuj.testdw;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Main {

    public static void main(String... args) throws Exception {
        final Client client = ClientBuilder.newClient();
        while (true) {
            try {
                client.target("http://localhost:8080").request().method("GET").getStatus();
                final int rand = (int) (Math.random() * 1.5);
                Thread.sleep(1000 * rand);
            } catch (final Exception e) {
                // ignore
            }
        }
    }
}
