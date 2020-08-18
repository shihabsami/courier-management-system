package cms.model.vehicle;

import cms.model.interfaces.LandVehicle;
import cms.maintenance.TruckServiceHistory;
import cms.maintenance.LandVehicleServiceHistory;

public class Truck extends AbstractVehicle implements LandVehicle
{
	private final double CAPACITY;
	private final LandVehicleServiceHistory SERVICE_HISTORY;
	
	public Truck(String reg, String make, String model, int year, double odo, double serviceInterval, double capacity) 
	{
		super(reg, make, model, year);
		CAPACITY = capacity / 1000;
		SERVICE_HISTORY =  new TruckServiceHistory(odo, 0.0, serviceInterval, 0.5 * CAPACITY);
	}	

	public double getCAPACITY() 
	{
		return CAPACITY;
	}
	
	@Override
	public LandVehicleServiceHistory getServiceHistory()
	{
		return SERVICE_HISTORY;
	}
	
	@Override
	public String toString()
	{
		return String.format("Truck: %s, Capacity: %.02ft\n%s", super.toString(), CAPACITY, SERVICE_HISTORY.toString());
	}
}