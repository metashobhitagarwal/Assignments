import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import DefaultNamespace.TempConvertorServiceLocator;

/**
 * Servlet implementation class MyConvertor
 */
@WebServlet("/MyConvertor")
public class MyConvertor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyConvertor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double tempInF = Double.parseDouble(request.getParameter("tempInF"));
		
		TempConvertorServiceLocator  tempService = new TempConvertorServiceLocator();
		double outData = -1;
		try {
			outData = tempService.getTempConvertor().forenhiteToCalcus(tempInF);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		request.setAttribute("outputTemp", outData);
		RequestDispatcher rd=request.getRequestDispatcher("/convertor.jsp");
		rd.forward(request, response);
	}

}
