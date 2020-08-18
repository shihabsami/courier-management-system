package cms.maintenance;

public class VanServiceHistory extends LandVehicleServiceHistory 
{
	public VanServiceHistory(double odo, double lastService, double interval, double expense_rate) 
	{
		super(odo, lastService, interval, expense_rate);
	}
}