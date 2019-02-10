/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.config;

import co.dreamcars.vehiculos.rest.VehiculosRest;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author kevin
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    private final Set<Object> singletons = new HashSet<>();
    private final Set<Class<?>> set = new HashSet<>();

    public ApplicationConfig() {        
        this.getClasses().add(VehiculosRest.class);        
    }
       
	@Override
	public Set<Object> getSingletons() {

		return this.singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {

		return this.set;
	}
}
