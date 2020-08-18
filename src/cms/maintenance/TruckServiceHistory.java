package cms.maintenance;

public class TruckServiceHistory extends LandVehicleServiceHistory 
{
	public TruckServiceHistory(double odo, double lastService, double interval, double expense_rate) 
	{
		super(odo, lastService, interval, expense_rate);
	}
}