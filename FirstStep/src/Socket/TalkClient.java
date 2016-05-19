package Socket;

import java.io.*;
import java.net.*;

public class TalkClient 
{
	public static void main(String[] args)
	{
		try
		{
			Socket s1 = new Socket("127.0.0.1",6666);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(s1.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			String line;
			line = sin.readLine();
			while(!line.equals("bye"))
			{
				os.println(line);
				os.flush();
				System.out.println("client:" + line);
				System.out.println("server:" + is.readLine());
				line = sin.readLine();
			}
			
			os.close();
			is.close();
			s1.close();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
