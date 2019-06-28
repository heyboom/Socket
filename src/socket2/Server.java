package socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("服务器正在8888端口监听...");
			Socket s = ss.accept();
			new RecieveThread(s).start();
			new SendThread(s).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
