package axis2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;



public class TestAxisClient {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		String serviceAddr = "http://localhost:8080/axis2/services/TestService";
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference taReference = new EndpointReference(serviceAddr); 
		options.setTo(taReference);
		Object[] entry = new Object[]{"test"};
		Class[] classes = new Class[]{byte[].class};
		QName opAddEntyr = new QName("http://ws.apache.org/axis2", "test1");
		
		Object[] obj = serviceClient.invokeBlocking(opAddEntyr, entry, classes);
		Map<Object, Object> res = null;
		if(null != obj && obj.length>0)
		{
			byte[] buffer =(byte[])obj[0];
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
			res = (Map<Object, Object>)ois.readObject();
			System.out.println(res.get("≤‚ ‘"));
		}
		else{
			res = null;
		}
		
		
		
		
		
		
		
	}
}
