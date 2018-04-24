import java.io.DataInputStream;
import java.io.IOException;

public class ChatThread extends Thread {
    DataInputStream input = null;

    ChatThread(DataInputStream input){
        this.input=input;
    }
    public void run(){
        System.out.println("Running");
        try {
            read();
        }
        catch (java.io.IOException e){
            System.out.println(e);
        }

    }
    public void read() throws java.io.IOException{
        String temp=null;

        System.out.println("Reader created, type [exit] in order to quit");
        temp =input.readLine();
        while (true){
            System.out.println(temp);

            temp =input.readLine();
            if(temp.equals("Server: EXIT")||temp.equals("Server: Exit")||temp.equals("Server: exit"))break;

        }



    }
}
