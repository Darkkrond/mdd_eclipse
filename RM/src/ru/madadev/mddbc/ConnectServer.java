package ru.madadev.mddbc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectServer {
	private ServerSocket ss;
	private Socket soc;
	
	public ConnectServer(int port) {
		try {
			ss = new ServerSocket(port);
			
			soc = ss.accept();
			
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
