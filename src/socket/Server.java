package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while(true) {
				String clientMsg = dis.readUTF();
				System.out.println("Server--接收到Client:" + clientMsg);
				String msg = sc.next();
				dos.writeUTF(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
