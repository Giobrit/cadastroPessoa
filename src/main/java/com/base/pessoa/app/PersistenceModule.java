package com.base.pessoa.app;

import java.util.Properties;

import com.base.pessoa.app.PersistenceInitializer;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.eclipse.persistence.config.PersistenceUnitProperties;

@Singleton
public class PersistenceModule implements Module {
	    @Override
	    public void configure(Binder binder) {
	        binder
	          .install(new JpaPersistModule("pessoa")
	          .properties(getPersistenceProperties()));

	        binder.bind(PersistenceInitializer.class).asEagerSingleton();
	    }

	    private Properties getPersistenceProperties() {
	        Properties properties = new Properties();
	        properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
	        properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://192.168.56.101:5432/postgres");
	        properties.put("javax.persistence.jdbc.user", "postgres");
	        properties.put("javax.persistence.jdbc.password", "123");
			properties.put("eclipselink.ddl-generation", PersistenceUnitProperties.DROP_AND_CREATE);
	        properties.put("eclipselink.create-ddl-jdbc-file-name", "createDDL_ddlGeneration.jdbc");
	        properties.put("eclipselink.drop-ddl-jdbc-file-name", "dropDDL_ddlGeneration.jdbc");
	        properties.put("eclipselink.ddl-generation.output-mode", "both");
	        
	        return properties;
	    }
	    

	    
	    
	    
	    
	    
}