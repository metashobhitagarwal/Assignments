import javax.jws.WebMethod;
import javax.jws.WebService;

//Web Service
@WebService
public class TempConvertor {

	//Method to convert forenhite to calcus
	@WebMethod
	public double forenhiteToCalcus(double fahrenheit) {
        double celsius = (fahrenheit-32) * (5 / 9.0);
        return celsius;
	}
}
