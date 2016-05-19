package Socket;

import java.io.*;
import java.net.*;

public class TalkServer 
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(6666);
			Socket s1 =  ss.accept();
			BufferedReader  is = new BufferedReader(new  InputStreamReader(s1.getInputStream()));
			PrintWriter os = new PrintWriter(s1.getOutputStream());
			BufferedReader sin =  new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Client:" + is.readLine());
			String line;
			line = sin.readLine();
			while (!line.equals("bye"))
			{
				os.println(line);
				os.flush();
				System.out.println("Server: " + line);
				System.out.println("Client: " + is.readLine());
				line = sin.readLine();
				
			}
			
			is.close();
			os.close();
			s1.close();
			ss.close();
		
		} catch ( IOException e)
		{
			e.printStackTrace();
			
		}
		
	}

}
