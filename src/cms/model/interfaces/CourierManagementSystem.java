package cms.model.interfaces;

public interface CourierManagementSystem 
{
	void addVehicle(Vehicle vehicle);
	
	void removeVehicle(String reg);
	
	Vehicle getVehicle(String reg);
	
	void displayVehicleInfo(String reg);
	
	void displayAllVehicles();
	
	void serviceVehicle(String reg);
	
	boolean scheduleJob(double distance, String reg);
	
	void displayAllJobs();
}