/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.restGlobal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder; 
import org.apache.commons.logging.Log;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author kevin
 */
public abstract class GlobalRestClientFactory {
    
    private String uriMicroserviceComponent;
    private Integer connectionTimeOut;

    public GlobalRestClientFactory(final String uriMicroserviceComponent, final Integer connectionTimeOut) {
        this.uriMicroserviceComponent = uriMicroserviceComponent;
        this.connectionTimeOut = connectionTimeOut;
    }
    
     public GlobalRestClientFactory(final String uriMicroserviceComponent) {
        this.uriMicroserviceComponent = uriMicroserviceComponent;
    }   
    
    @Inject
    private Log log;
    
    /**
     * Metodo que devuelve le instancia del servicio rest.
     * 
     * @param <T>
     * @param IClass
     * @return 
     */
    public <T> T getProxyClient(final Class<T> IClass){
        
        try {
            return this.getTarget().proxy(IClass);
        } catch (final Exception e) {
            this.log.error("Error a la hora de crear el servicio rest", e);
            return null;
        }
    }
    
    /**
     * Metodo el cual crea el target del servicio.
     * @return 
     */
    public ResteasyWebTarget getTarget(){
              
        try {
            return this.getRestEasyClientBuilder().target(UriBuilder.fromPath(this.getPath()));
        } catch (final Exception e) {
            this.log.error("Error a la hora de construir el target del servicio", e);
            return null;
        }
        
    }
    
    /**
     * MEtodo el cual devuelve el cliente del servicio rest.
     * @return 
     */
    private ResteasyClient getRestEasyClientBuilder(){
    
        final ResteasyClientBuilder resteasyClientBuilder = new ResteasyClientBuilder();
        
        try {
            if (this.getConnectionTimeOut() != null) {
                resteasyClientBuilder.connectTimeout(this.getConnectionTimeOut(), TimeUnit.SECONDS);
            }
            return resteasyClientBuilder.build();            
        } catch (final Exception e) {
            log.error("Error a la hora de construir el cliente rest", e);
            return null;
        }
    }

    /**
     * Metodo el cual obtiene la fraccion de url del microservicio al que se va a llamar.
     * @return 
     */
    private String getPath() {
        
        try {
            final Properties properties = new Properties();
            final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("endpoint.properties");
            
            properties.load(inputStream);
            final String endPoint = properties.getProperty(this.getUriMicroserviceComponent());
            
            return endPoint;
        } catch (IOException ex) {
            this.log.error("Error a la hora de obtener la url del microservicio", ex);
            return null;
        }
    }
    
    public String getUriMicroserviceComponent() {
        return uriMicroserviceComponent;
    }

    public void setUriMicroserviceComponent(String uriMicroserviceComponent) {
        this.uriMicroserviceComponent = uriMicroserviceComponent;
    }

    public Integer getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(Integer connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }
    
}
