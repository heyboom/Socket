package socket2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{

	private Socket s;
	
	public SendThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);
			while(true) {
				String msg = sc.next();
				dos.writeUTF(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
