package genericUtlity;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This Method is used to generate random numbers within the range
	 * 
	 * @return
	 */
	public int toGetRandomNumber() {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}
	
	public String toGetSystemDateAndTime() {  //sat|feb|01
		Date d=new Date();
		String[] date = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate=day+" "+ month +" "+date1+" "+time+" "+year;
		return finalDate;
	}

}
