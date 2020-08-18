package cms.model.aircraft;

import cms.model.interfaces.AirVehicle;
import cms.model.vehicle.AbstractVehicle;
import cms.maintenance.AircraftServiceHistory;

public class Aircraft extends AbstractVehicle implements AirVehicle
{
	private final AircraftServiceHistory SERVICE_HISTORY;
	
	public Aircraft(String reg, String make, String model, int year, 
			double averageSpeed, int maxFlights, double flightHours, double serviceInterval)
	{
		super(reg, make, model, year);
		SERVICE_HISTORY = new AircraftServiceHistory(averageSpeed, maxFlights, flightHours, serviceInterval, 5.0);
	}
	
	@Override
	public AircraftServiceHistory getServiceHistory()
	{
		return SERVICE_HISTORY;
	}
	
	@Override
	public String toString()
	{
		return String.format("Aircraft: %s\n%s", super.toString(), SERVICE_HISTORY.toString());
	}
}
