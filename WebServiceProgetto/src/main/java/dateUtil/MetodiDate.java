package dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetodiDate {
	
	String dateInString = "01-10-2016 10:20:56";
	//--------------------	   DA STRING A DATE     ------------------------------
	public Date ConvertiStringADate(String dateInString){	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			Date data = null;
			try {
				data = sdf.parse(dateInString);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			//System.out.println(data);
			return data;
	}
}
