package src.project01am.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            int port = 3000; // default port number
            if (args.length > 0){
                port = Integer.parseInt(args[0]);
            }
            ServerSocket server = new ServerSocket(port);
            System.out.printf("Waiting for connection on port %d\n", port);
            Socket sock = server.accept();
            System.out.println("Got a new connection\n");
                        //open input and output stream
            OutputStream os = sock.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            InputStream is = sock.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);


            String fromClient = "a";
            Calculator calculator = new Calculator();
            while(!fromClient.equalsIgnoreCase("exit")){
                fromClient = br.readLine();
                System.out.printf("Command: %s\n",fromClient);
                if (fromClient.equalsIgnoreCase("exit")){
                    System.out.println("Server closing");
                    break;
                }
                System.out.printf("The last result is: %d\n",calculator.getLastResult());
                int result = calculator.calculate(fromClient);
                bw.write(Integer.toString(result));
                bw.newLine();
                bw.flush();
            }
            bw.close();
            br.close();
            server.close();
        }catch(IOException ex){
            ex.printStackTrace();}
    }
}
