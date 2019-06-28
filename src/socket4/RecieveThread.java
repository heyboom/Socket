package socket4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RecieveThread extends Thread{

	private Socket s;
	
	public RecieveThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true) {
				String msg = dis.readUTF();
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
