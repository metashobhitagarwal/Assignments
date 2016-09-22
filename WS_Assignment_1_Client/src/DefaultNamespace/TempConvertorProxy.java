package DefaultNamespace;

public class TempConvertorProxy implements DefaultNamespace.TempConvertor {
  private String _endpoint = null;
  private DefaultNamespace.TempConvertor tempConvertor = null;
  
  public TempConvertorProxy() {
    _initTempConvertorProxy();
  }
  
  public TempConvertorProxy(String endpoint) {
    _endpoint = endpoint;
    _initTempConvertorProxy();
  }
  
  private void _initTempConvertorProxy() {
    try {
      tempConvertor = (new DefaultNamespace.TempConvertorServiceLocator()).getTempConvertor();
      if (tempConvertor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tempConvertor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tempConvertor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tempConvertor != null)
      ((javax.xml.rpc.Stub)tempConvertor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.TempConvertor getTempConvertor() {
    if (tempConvertor == null)
      _initTempConvertorProxy();
    return tempConvertor;
  }
  
  public double forenhiteToCalcus(double fahrenheit) throws java.rmi.RemoteException{
    if (tempConvertor == null)
      _initTempConvertorProxy();
    return tempConvertor.forenhiteToCalcus(fahrenheit);
  }
  
  
}