package com.base.pessoa.app;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.AbstractContainerLifecycleListener;
import org.glassfish.jersey.server.spi.Container;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

@ApplicationPath("/rest/*")
public class ApplicationModel extends ResourceConfig {
   
    
    @Inject // Note: inject from HK2
    public void ApplicationConfig(ServiceLocator serviceLocator) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8089");
        beanConfig.setBasePath("/rest/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);


    	//final Logger logger = LoggerFactory.getLogger(getClass());

    	// Guice
        Injector injector = Guice.createInjector(new PersistenceModule(), new GuiceModule());

        // Guice HK2 bridge
        // See e.g. https://github.com/t-tang/jetty-jersey-HK2-Guice-boilerplate
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge bridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        bridge.bridgeGuiceInjector(injector);

        // Application startup and shutdown listener
        register(ApplicationLifecycleListener.class);

        // Scans during deployment for JAX-RS components in packages
        packages("com.base.pessoa.app");
    }
  
    private static class ApplicationLifecycleListener extends AbstractContainerLifecycleListener {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Inject // Note: The HK2 bridge takes care of injecting from correct DI-container
        PersistService service;

        @Override
        public void onStartup(Container container) {
            logger.info(">>> Application Startup");
        }

        @Override
        public void onShutdown(Container container) {
            logger.info(">>> Application Shutdown");

            // Stop persistence service
            service.stop();
        }
    }
   
}