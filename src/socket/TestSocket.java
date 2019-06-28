package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class TestSocket {

	public static void main(String[] args) throws IOException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		String title = ip.substring(0, ip.lastIndexOf('.') + 1);
		List<String> accessIps = new ArrayList<>();
		for(int i = 1; i < 256; i++) {
			String testIp = title + String.valueOf(i);
			System.out.printf("尝试连接" + testIp + ": ");
			Process p = Runtime.getRuntime().exec("ping " + testIp + " -n 1");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			String line = null;
			boolean success = false;
			while((line = br.readLine()) != null) {
				if(line.contains("字节=32")) {
					success = true;
					accessIps.add(testIp);
					break;
				}
			}
			if (success) {
				System.out.printf("成功\n");
			} else {
				System.out.printf("失败\n");
			}
		}
		System.out.println("本网段可用Ip:");
		for (String aip : accessIps) {
			System.out.println(aip);
		}
	}
}
