/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.facade;

import co.dreamcars.dtos.VehicleDto;
import co.dreamcars.vehiculos.impl.AdministradorServiciosRestClient;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 *
 * Facade el cual llama a la configuración de los servicios rest.
 * 
 * @author kevin
 */
@Default
public class VehiculosFacade implements Serializable{
    
    @Inject
    private AdministradorServiciosRestClient administradorServiciosRestClient;
    
    public List<VehicleDto> getVehiculos(){
       return this.administradorServiciosRestClient.obtenerVehiculosRegistrados();
    }
    
    public VehicleDto registrarVehiculo(final VehicleDto vehicleDto){
        return this.administradorServiciosRestClient.guardarVehiculo(vehicleDto);
    }
    
    public VehicleDto actualizarVehiculo(final Long id, final VehicleDto vehicleDto){
        return this.administradorServiciosRestClient.actualizarVehiculo(id, vehicleDto);
    }
    
    public VehicleDto eliminarVehiculo(final Long id){
        return this.administradorServiciosRestClient.eliminarVehiculo(id);
    }
}
