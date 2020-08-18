package cms.model.interfaces;

import cms.maintenance.AirVehicleServiceHistory;

public interface AirVehicle extends Vehicle 
{
	AirVehicleServiceHistory getServiceHistory();
}