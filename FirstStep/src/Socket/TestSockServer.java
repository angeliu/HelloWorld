package Socket;

import java.io.*;

import java.net.*;

public class TestSockServer 
{
	public static void main(String[] args)
	{
		InputStream in = null;
		OutputStream out = null;
		try
		{
			ServerSocket ss = new ServerSocket(5888);
			Socket s1 = ss.accept();
			in = s1.getInputStream();
			out = s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			String s = null;
			if((s=dis.readUTF()) != null)
			{
				System.out.println(s);
				System.out.println("from: " + s1.getInetAddress());
				System.out.println("port: " + s1.getPort());
				
			}
			dos.writeUTF("hi,hello");
			dis.close();
			dos.close();
			s1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
