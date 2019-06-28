package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true) {
				String msg = sc.next();
				dos.writeUTF(msg);
				String serverMsg = dis.readUTF();
				System.out.println("Client--接收到Server:" + serverMsg);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
