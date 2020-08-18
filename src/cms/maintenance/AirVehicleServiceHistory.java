package cms.maintenance;

public abstract class AirVehicleServiceHistory
{
	private double averageSpeed;
	private int maxFlights;
	private int flightCount;
	private double flightHours;
	private final double SERVICE_INTERVAL;
	private final double EXPENSE_RATE;

	public AirVehicleServiceHistory(double averageSpeed, int maxFlights, double flightHours, double serviceInterval, double expenseRate)
	{
		this.averageSpeed = averageSpeed;
		this.maxFlights = maxFlights;
		this.flightHours = flightHours;
		SERVICE_INTERVAL = serviceInterval;
		EXPENSE_RATE = expenseRate;
	}

	public double getAverageSpeed()
	{
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed)
	{
		this.averageSpeed = averageSpeed;
	}

	public int getMaxFlights()
	{
		return maxFlights;
	}

	public void setMaxFlights(int maxFlights)
	{
		this.maxFlights = maxFlights;
	}

	public double getFlightHours()
	{
		return flightHours;
	}

	public void setFlightHours(double flightHours)
	{
		this.flightHours += flightHours;
	}
	
	public void resetFlightHours()
	{
		this.flightHours = 0.0;
	}

	public double getServiceInterval()
	{
		return SERVICE_INTERVAL;
	}
	
	public double getExpenseRate()
	{
		return EXPENSE_RATE;
	}
	
	public int getFlightCount()
	{
		return flightCount;
	}

	public void setFlightCount(int flightCount)
	{
		this.flightCount = flightCount;
	}
	
	public void resetFlightCount()
	{
		this.flightCount = 0;
	}

	@Override
	public String toString()
	{
		return String.format("Service History: Average Speed: %.02fkm/h, Max Flights: %d, Times Flown: %d, Hours Flown: %.02fh, Service Interval: %.02fh",
				averageSpeed, maxFlights, flightCount, flightHours, SERVICE_INTERVAL);
	}
}
