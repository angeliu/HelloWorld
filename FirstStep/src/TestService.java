

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class TestService {
	public String test()
	{
		return "Hello World";
	}
	public byte[] test1(String arg) throws IOException
	{
		Map<Object, Object> map = new HashMap<Object,Object>();
		map.put("≤‚ ‘", arg);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream  oos = new ObjectOutputStream(baos);
		oos.writeObject(map);
		return baos.toByteArray();
	}
}
