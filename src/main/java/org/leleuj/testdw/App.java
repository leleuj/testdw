package org.leleuj.testdw;

import com.codahale.metrics.servlets.MetricsServlet;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.dropwizard.DropwizardExports;

import javax.ws.rs.client.Client;

public class App extends Application<MyConfig> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "testdw";
    }

    @Override
    public void initialize(Bootstrap<MyConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(MyConfig configuration,
                    Environment environment) {
        environment.jersey().register(new Resource());
        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());
        environment.admin().addTask(new CallTask(client));
        /*final CollectorRegistry collectorRegistry = new CollectorRegistry();
        collectorRegistry.register(new DropwizardExports(environment.metrics()));
        environment.admin()
                .addServlet("prometheusMetrics", new MetricsServlet(collectorRegistry))
                .addMapping("/prometheusMetrics");*/
    }
}
/*





 */
