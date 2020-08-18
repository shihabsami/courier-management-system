package cms.model.vehicle;

import cms.model.interfaces.LandVehicle;
import cms.maintenance.VanServiceHistory;
import cms.maintenance.LandVehicleServiceHistory;

public class Van extends AbstractVehicle implements LandVehicle
{	
	private final LandVehicleServiceHistory SERVICE_HISTORY;
	
	public Van(String reg, String make, String model, int year, double odo, double serviceInterval) 
	{
		super(reg, make, model, year);
		SERVICE_HISTORY = new VanServiceHistory(odo, 0.0, serviceInterval, 0.6);
	}
	
	@Override
	public LandVehicleServiceHistory getServiceHistory()
	{
		return SERVICE_HISTORY;
	}
	
	@Override
	public String toString()
	{
		return String.format("Van: %s\n%s", super.toString(), SERVICE_HISTORY.toString());
	}
}