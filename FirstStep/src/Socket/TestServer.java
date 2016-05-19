package Socket;

import java.net.*;
import java.io.*;

public class TestServer 
{
	public static void main(String[] main)
	{
		try
		{
			ServerSocket ss = new ServerSocket(8888);
			while(true)
			{
				Socket s1 = ss.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("hello," + s1.getInetAddress() + "p"
						+ "ort#" +s1.getPort() + "bye-bye");
				
				dos.close();
				s1.close();
				
			}	
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("程序运行出错：" + e);
			}
		
	}

}
