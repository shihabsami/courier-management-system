package cms.model.vehicle;

import cms.model.interfaces.Vehicle;

public abstract class AbstractVehicle implements Vehicle 
{
	private final String REG;
	private final String MAKE;
	private final String MODEL;
	private final int YEAR;
	
	public AbstractVehicle(String reg, String make, String model, int year)
	{
		REG = reg;
		MAKE = make;
		MODEL = model;
		YEAR = year;
	}
	
	@Override
	public String getReg() 
	{
		return REG;
	}
	
	@Override
	public String getMake() 
	{
		return MAKE;
	}
	
	@Override
	public String getModel() 
	{
		return MODEL;
	}
	
	@Override
	public int getYear() 
	{
		return YEAR;
	}
	
	@Override
	public String toString()
	{
		return String.format("Reg_Number: %s, Make: %s, Model: %s, Year: %d", 
				REG, MAKE, MODEL, YEAR);
	}
}