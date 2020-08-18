package cms.model;

import cms.model.interfaces.AirVehicle;
import cms.model.interfaces.LandVehicle;

public class Job 
{
	private final String ID;
	private final double DISTANCE;
	private double cost;
	private double expense;
	private double profit;
	
	
	public Job(String id, double distance)
	{
		ID = id;
		DISTANCE = distance;
	}
	
	public String getId()
	{
		return ID;
	}
	
	public boolean scheduleJob(LandVehicle vehicle)
	{
        double odo = vehicle.getServiceHistory().getOdo();
        double lastService = vehicle.getServiceHistory().getLastService();
        double serviceInterval = vehicle.getServiceHistory().getServiceInterval();
        
        if (odo + DISTANCE < lastService + serviceInterval)
        {
			vehicle.getServiceHistory().setOdo(DISTANCE);
            calculateExpenses(vehicle);
            return true;
        }
        return false;
	}
	
	public boolean scheduleJob(AirVehicle vehicle)
	{
		int flightCount = vehicle.getServiceHistory().getFlightCount();
		int maxFlights = vehicle.getServiceHistory().getMaxFlights();
		double flightHours = vehicle.getServiceHistory().getFlightHours();
		double flyingHours = DISTANCE / vehicle.getServiceHistory().getAverageSpeed();
		double serviceInterval = vehicle.getServiceHistory().getServiceInterval();
		
		if (flightCount <= maxFlights
			&&  flightHours + flyingHours < serviceInterval)
		{
			vehicle.getServiceHistory().setFlightCount(flightCount + 1);
			vehicle.getServiceHistory().setFlightHours(flyingHours);
			calculateExpenses(vehicle);
			return true;
		}
		return false;
	}
	
    public void calculateExpenses(LandVehicle vehicle)
    {
        expense = vehicle.getServiceHistory().getExpenseRate() * DISTANCE;
        profit = expense * 0.50;
        cost = expense + profit;
    }
    
    public void calculateExpenses(AirVehicle vehicle)
    {
        expense = 30000 + vehicle.getServiceHistory().getExpenseRate() * DISTANCE;
        profit = expense * 0.50;
        cost = expense + profit;
    }
	
	@Override
	public String toString()
	{
		return String.format("ID: %s, Distance: %.02fkm, Cost: $%.02f, Expense: $%.02f, Profit: $%.02f", 
				ID, DISTANCE, cost, expense, profit);
	}
}