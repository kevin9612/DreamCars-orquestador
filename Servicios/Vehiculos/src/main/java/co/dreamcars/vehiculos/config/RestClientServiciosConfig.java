/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.config;

import co.dreamcars.restGlobal.GlobalRestClientFactory;


/**
 *
 * Clase la cual se encarga de instanciar el globalrestclient.
 * @author kevin
 */
public class RestClientServiciosConfig extends GlobalRestClientFactory{
    
    private static final String URI_MICROSERVICE_REST = "microservices.uri.rest";
    private static final Integer CONNECTION_TIME_OUT = null;
    
    public RestClientServiciosConfig() {
        super(URI_MICROSERVICE_REST, CONNECTION_TIME_OUT);
    }
    
}
