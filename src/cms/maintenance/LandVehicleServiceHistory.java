package cms.maintenance;

public abstract class LandVehicleServiceHistory
{
	private double odo;
	private double lastService;
	private final double SERVICE_INTERVAL;
	private final double EXPENSE_RATE;
	
	public LandVehicleServiceHistory(double odo, double lastService, double serviceInterval, double expenseRate) 
	{
		this.odo = odo;
		this.lastService = lastService;
		SERVICE_INTERVAL = serviceInterval;
		EXPENSE_RATE = expenseRate;
	}

	public double getOdo() 
	{
		return odo;
	}

	public void setOdo(double odo) 
	{
		this.odo += odo;
	}

	public double getLastService() 
	{
		return lastService;
	}

	public void setLastService() 
	{
		lastService = odo;
	}

	public double getServiceInterval() 
	{
		return SERVICE_INTERVAL;
	}

	public double getExpenseRate() 
	{
		return EXPENSE_RATE;
	}
	
	@Override
	public String toString()
	{
		return String.format("Service History: Odometer: %.02fkm, Last Service: %.02fkm, Service Interval: %.02fkm",
				odo, lastService, SERVICE_INTERVAL);
	}
}