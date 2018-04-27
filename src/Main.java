import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Contains call to create host or client
		System.out.println("Welcome to the Web Chat program");
		System.out.println("Type [Host] to create a host, [Client] to connect to a host");
		String service;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		service = reader.readLine();

		DataInputStream input;


		if(service.equals("host")||service.equals("Host")) {
			Host Chat = new Host();
			Chat.HostCreate(9000);

		}



		else if (service.equals("client")||service.equals("Client")){

			Client user = new Client();
			System.out.println("[local] for local host, else enter ip");


			service = reader.readLine();
			if(service.equals("local")||service.equals("Local")) {
				System.out.println("Conecting to local host...");
				user.ClientConnect("localhost", 9000);
			}

			else {
				System.out.println("Connecting to host: "+ service);
				user.ClientConnect(service,9000);

			}


		}

	}

}
