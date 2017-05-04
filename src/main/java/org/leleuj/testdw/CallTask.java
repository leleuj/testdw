package org.leleuj.testdw;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;

import javax.ws.rs.client.Client;
import java.io.PrintWriter;

public class CallTask extends Task {

    private final Client client;

    public CallTask(final Client client) {
        super("call");
        this.client = client;
    }

    @Override
    public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {
        while (true) {
            client.target("http://localhost:8080").request().method("GET").getStatus();
            final int rand = (int) (Math.random() * 1);
            Thread.sleep(1000 * rand);
        }
    }
}
