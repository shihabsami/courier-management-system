package cms.model.interfaces;

import cms.maintenance.LandVehicleServiceHistory;

public interface LandVehicle extends Vehicle 
{
	LandVehicleServiceHistory getServiceHistory();
}