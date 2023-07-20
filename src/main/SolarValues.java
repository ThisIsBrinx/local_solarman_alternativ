package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolarValues
{
	String text = "";
	
	public SolarValues(String text)
	{
		this.text = text;
	}
	
	public String getCurrentPower()
	{
		return getValue("webdata_now_p");
	}
	
	public String getYieldToday()
	{
		return getValue("webdata_today_e");
	}
	
	public String getYieldTotal()
	{
		return getValue("webdata_total_e");
	}
	
	private String getValue(String value)
	{	
	    // Die RegEx zum Extrahieren der Zahl
	    String regex = value + " = \"([^\"]+)";
	
	    // Das Pattern-Objekt erstellen
	    Pattern pattern = Pattern.compile(regex);
	
	    // Den Matcher initialisieren
	    Matcher matcher = pattern.matcher(text);	

	    matcher.find();
	    
        return matcher.group(1);
	}
}
