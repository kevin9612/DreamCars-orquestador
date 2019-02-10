/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.vehiculos.impl;

import co.dreamcars.dtos.VehicleDto;
import co.dreamcars.vehiculos.config.RestClientServiciosConfig;
import co.dreamcars.vehiculos.definition.IAdministracionVehiculosRestClient;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;

/**
 *
 * @author kevin
 */
public class AdministradorServiciosRestClient {
    
    @Inject
    private Log log;
    
    @Inject
    private RestClientServiciosConfig restClientServiciosConfig;
 
    /**
     * Metodo el cual devuelve el proxy de los servicios rest.
     * 
     * @param connectionTimeOut
     * @return 
     */
    public IAdministracionVehiculosRestClient obtenerProxyRestServicios(final Integer connectionTimeOut){
    
        this.restClientServiciosConfig.setConnectionTimeOut(connectionTimeOut);
        return this.restClientServiciosConfig.getProxyClient(IAdministracionVehiculosRestClient.class);
    }
    
    /**
     * Metodo el cual consulta los servicios registrados.
     * @return 
     */
    public List<VehicleDto> obtenerVehiculosRegistrados(){    
        try {
            final IAdministracionVehiculosRestClient iAdministracionServiciosRestClient = this.obtenerProxyRestServicios(300);
            final List<VehicleDto> vehicleDtos = iAdministracionServiciosRestClient.getVehicles();
            return vehicleDtos;
        } catch (Exception e) {
            this.log.error("Error al instanciar servicios obtenerServiciosRegistrados", e);
            return null;
        }
    } 
    
    /**
     * Metodo el cual guarda un registro de un servicio a prestar.
     * @param vehicleDto
     * @return 
     */
    public VehicleDto guardarVehiculo(final VehicleDto vehicleDto){    
        try {
            final IAdministracionVehiculosRestClient iAdministracionServiciosRestClient = this.obtenerProxyRestServicios(300);
            return iAdministracionServiciosRestClient.guardarVehicles(vehicleDto);
        } catch (Exception e) {
            this.log.error("Error al instanciar servicios guardarServicio", e);
            return null;
        }
    } 
    
     /**
     * Metodo el cual actualiza un registro de un servicio a prestar.
     * @param id
     * @param vehicleDto
     * @return 
     */
    public VehicleDto actualizarVehiculo(final Long id, final VehicleDto vehicleDto){    
        try {
            final IAdministracionVehiculosRestClient iAdministracionVehiculosRestClient = this.obtenerProxyRestServicios(300);
            return iAdministracionVehiculosRestClient.actualizarVehicle(id, vehicleDto);
        } catch (Exception e) {
            this.log.error("Error al instanciar servicios actualizarServicio", e);
            return null;
        }
    } 
    
     /**
     * Metodo el cual actualiza un registro de un servicio a prestar.
     * @param id
     * @return 
     */
    public VehicleDto eliminarVehiculo(final Long id){    
        try {
            final IAdministracionVehiculosRestClient iAdministracionVehiculosRestClient = this.obtenerProxyRestServicios(300);
            return iAdministracionVehiculosRestClient.eliminarVehicle(id);
        } catch (Exception e) {
            this.log.error("Error al instanciar servicios eliminarServicio", e);
            return null;
        }
    } 
    
    
    
}
