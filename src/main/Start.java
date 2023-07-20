package main;


class Start
{	
	public static void main(String args[])
	{
		try
		{
			final String response = new HttpRequest("192.168.178.76/status.html", "admin", "admin").fire();
			
			SolarValues values = new SolarValues(response);
			
			System.out.println("current Power: " + values.getCurrentPower() + " W");
			System.out.println("Heute: " + values.getYieldToday() + " kWh");
			System.out.println("Total: " + values.getYieldTotal() + " kWh");
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
