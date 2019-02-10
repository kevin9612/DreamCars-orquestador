/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.rest;

import co.dreamcars.dtos.VehicleDto;
import co.dreamcars.vehiculos.facade.VehiculosFacade;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * Servicio rest diseñado para los servicios que el usuario presta.
 * 
 * @author kevin
 */
@Path("/service")
public class VehiculosRest {
    
    @Inject
    private VehiculosFacade vehiculosFacade;
    
    @GET
    @Path("/services")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehicleDto> getVehiculos(){
        return vehiculosFacade.getVehiculos();
    }
    
    @POST
    @Path("/saveServicio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VehicleDto guardarServicio(final VehicleDto vehicleDto){
        return vehiculosFacade.registrarVehiculo(vehicleDto);       
    }
    
    @PUT
    @Path("/updateServicio/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VehicleDto actualizarServicio(final @PathParam("id") Long id, final VehicleDto vehicleDto){
        return vehiculosFacade.actualizarVehiculo(id, vehicleDto);       
    }
    
    @DELETE
    @Path("/deleteServicio/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VehicleDto eliminarServicio(final @PathParam("id") Long id){
        return vehiculosFacade.eliminarVehiculo(id);       
    }
    
}
