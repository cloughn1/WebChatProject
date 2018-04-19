import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    //ClientConnect is meant to be run with the input of the ip and port of the host
    //ClientConnect will open a stream, and create a new thread to accept any an all input from the host
    public void ClientConnect(String ip, int Port) throws java.io.IOException{
        Socket Client;

        Client = new Socket(ip, Port);





    }
}
