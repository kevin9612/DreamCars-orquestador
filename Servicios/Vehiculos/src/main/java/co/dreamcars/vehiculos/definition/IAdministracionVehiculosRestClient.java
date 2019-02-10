/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.definition;

import co.dreamcars.dtos.VehicleDto;
import java.util.List;
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
 * Interface que llama a los servicios rest.
 * 
 * @author kevin
 */
@Path("/servicio")
public interface IAdministracionVehiculosRestClient {
    
    @GET
    @Path("/vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    List<VehicleDto> getVehicles();
    
    @POST
    @Path("/addVehicle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    VehicleDto guardarVehicles(final VehicleDto vehicleDto);
    
    @PUT
    @Path("/updateVehicle/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    VehicleDto actualizarVehicle(final @PathParam("id") Long id, final VehicleDto vehicleDto);
    
    @DELETE
    @Path("/deleteVehicle/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    VehicleDto eliminarVehicle(final @PathParam("id") Long id);
    
}
