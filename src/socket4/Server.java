package socket4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) {
		try {
			ExecutorService threadPool = Executors.newFixedThreadPool(100);
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("服务器正在8888端口监听...");
			while(true) {
				Socket s = ss.accept();
				System.out.println("接收到新的socket" + s);
				threadPool.execute(new Runnable() {
					public void run() {
						new SendThread(s).start();
						new RecieveThread(s).start();
					}
				});
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
