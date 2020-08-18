package cms.model;

import java.util.Map;
import java.util.HashMap;

import cms.model.interfaces.Vehicle;
import cms.model.interfaces.AirVehicle;
import cms.model.interfaces.LandVehicle;
import cms.model.interfaces.CourierManagementSystem;

public class CourierManagementSystemImpl implements CourierManagementSystem
{
	private final Map<String, Vehicle> VEHICLES = new HashMap<>();
	private final Map<String, Job> JOBS = new HashMap<>();
	
	
	@Override
	public void addVehicle(Vehicle vehicle)
	{
		VEHICLES.put(vehicle.getReg(), vehicle);
	}
	
	@Override
	public void removeVehicle(String reg)
	{
		VEHICLES.remove(reg);
	}
	
	@Override
	public Vehicle getVehicle(String reg)
	{
		return VEHICLES.get(reg);
	}

	@Override
	public void displayVehicleInfo(String reg)
	{
		System.out.println(VEHICLES.get(reg));
	}
	
	@Override
	public void displayAllVehicles()
	{
		for (Vehicle vehicle : VEHICLES.values())
			System.out.println(vehicle);
	}

	@Override
	public void serviceVehicle(String reg)
	{
		if (VEHICLES.get(reg) instanceof LandVehicle)
		{	
			((LandVehicle) VEHICLES.get(reg)).getServiceHistory().setLastService();
		}
		else if (VEHICLES.get(reg) instanceof AirVehicle)
		{	
			((AirVehicle) VEHICLES.get(reg)).getServiceHistory().resetFlightCount();
			((AirVehicle) VEHICLES.get(reg)).getServiceHistory().resetFlightHours();
		}
	}
	
	@Override
	public boolean scheduleJob(double distance, String reg)
	{
		Job job = new Job(String.valueOf(JOBS.size() + 1), distance);
		
		if (VEHICLES.get(reg) instanceof LandVehicle)
		{
			LandVehicle vehicle = (LandVehicle) VEHICLES.get(reg);
			if (job.scheduleJob(vehicle))
			{	
				
				JOBS.put(job.getId(), job);
				return true;
			}
		}
		else if (VEHICLES.get(reg) instanceof AirVehicle)
		{
			AirVehicle vehicle = (AirVehicle) VEHICLES.get(reg);
			if (job.scheduleJob(vehicle))
			{
				JOBS.put(job.getId(), job);
				return true;
			}
		}
		return false;
	}

	@Override
	public void displayAllJobs()
	{
		for (Job job : JOBS.values())
			System.out.println(job);
	}
}