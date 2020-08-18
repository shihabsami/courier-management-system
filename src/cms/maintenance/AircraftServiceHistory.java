package cms.maintenance;

public class AircraftServiceHistory extends AirVehicleServiceHistory
{
	public AircraftServiceHistory(double averageSpeed, int maxFlights, double flightHours, double serviceInterval, double expenseRate)
	{
		super(averageSpeed, maxFlights, flightHours, serviceInterval, expenseRate);
	}
}