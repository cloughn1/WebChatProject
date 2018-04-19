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
		System.out.println("Welcome");
		String service;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		service = reader.readLine();

		DataInputStream input;


		if(service.equals("host")||service.equals("Host")) {
			Host Chat = new Host();
			Chat.HostCreate(9000);

		}



		else if (service.equals("client")||service.equals("Client")){

			System.out.println("Nooooo");


		}

	}

}
