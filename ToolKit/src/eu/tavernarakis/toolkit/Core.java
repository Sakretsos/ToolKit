package eu.tavernarakis.toolkit;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Core {
	
	static boolean checkAFM(String input){
		if(!input.matches("^[0-9]{9}") || input.equals("000000000"))
			return false;
		else {
			int multiplier = 1;
			int sum = 0;
			
			for (int i = 7; i >= 0; i--){
				multiplier *= 2;
				sum += Integer.parseInt(input.substring(i, i+1))*multiplier;
			}
			return (sum % 11 % 10) == Integer.parseInt(input.substring(8,9));
		}
	}
	
	static boolean checkCC(String input){
		if(!input.matches("^[0-9]{16}") || input.equals("0000000000000000"))
			return false;
		else {
			int sum = 0;
			boolean alternate = false;
			
			for (int i = 15; i >= 0; i--){
				int n = Integer.parseInt(input.substring(i, i + 1));
				if (alternate){
					n *= 2;
					if (n > 9){
						n = (n % 10) + 1;
					}
				}
				sum += n;
				alternate = !alternate;
			}
			return (sum % 10 == 0);
		}
	}
	
	static void CheckSite(String input){
		if(input.matches("^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
			try {
				Socket CheckSite = new Socket(input, 80);
				System.out.println("Site: " + input + " is UP !.");
				CheckSite.close();
			} catch (UnknownHostException e){
				System.err.println("Site: " + input + " is DOWN !.");
			} catch (SocketException e){
				System.err.println("Site: " + input + " is DOWN !.");
			} catch (IOException e){
				System.err.println("Site: " + input + " is DOWN !.");
			}
		} else {
			System.err.println("Site: Please Use Domain Format Only !.");
		}
	}
	
	static void CheckCPort(String input, int port){
		if(input.matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5]):([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$")){
			/*if(input.matches("^0.0.0.0:([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$")){
				System.err.println("IP: " + input + " is not valid IP");
			}*/
			try {
				String[] parts = input.split(":");
				String ip = parts[0];
				port = Integer.parseInt(parts[1]);
				Socket CheckCPort = new Socket(ip, port);
				System.out.println("IP: " + ip + " on Port: " + port + " is UP !.");
				CheckCPort.close();
			} catch (UnknownHostException e){
				System.err.println("IP: " + input + " is DOWN !.");
			} catch (SocketException e){
				System.err.println("IP: " + input + " is DOWN !.");
			} catch (IOException e){
				System.err.println("IP: " + input + " is DOWN !.");
			} catch (ArrayIndexOutOfBoundsException e){
				System.err.println("IP: Please Use IP:Port Format Only !.");
			}
		} else {
			System.err.println("IP: Please Use IP:Port Format Only !.");
		}
	}
}