package socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("服务器正在8888端口监听...");
			while(true) {
				Socket s = ss.accept();
				System.out.println("接收到新的socket" + s);
				new Thread(new Runnable() {
					public void run() {
						new SendThread(s).start();
						new RecieveThread(s).start();
					}
				}).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
