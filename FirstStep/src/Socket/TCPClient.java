package Socket;


import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("hello server");
		dos.flush();
		dos.close();
		s.close();
		
	}

}
