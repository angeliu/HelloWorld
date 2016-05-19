package Socket;

import java.io.*;
import java.net.*;


public class TestSockClient 
{
	public static void main(String[] args)
	{
		InputStream is = null;
		OutputStream os = null;
		try
		{
			Socket s1 = new Socket("127.0.0.1",5888);
			is = s1.getInputStream();
			os = s1.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hey");
			String s = null;
			if((s=dis.readUTF()) != null)
			{
				System.out.println(s);
				dos.close();
				dis.close();
				s1.close();
			}
			
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		}  catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
