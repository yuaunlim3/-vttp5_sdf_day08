package src.project01am.day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            int port = 3000; // default port number
            if (args.length > 0){
                port = Integer.parseInt(args[0]);
            }
            Socket sock = new Socket("localhost",port);

            //open input and output stream
            OutputStream os = sock.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            InputStream is = sock.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            Console cons = System.console();
            String cmd = "a";
            while(!cmd.equalsIgnoreCase("exit")){
                cmd = cons.readLine(">>>");
                bw.write(cmd);
                bw.newLine();
                bw.flush();
                if (cmd.equalsIgnoreCase("exit")){
                    System.out.println("Exiting the program");
                    break;
                }

                String fromServer = br.readLine();
                System.out.printf("From the server: %s\n",fromServer);
            }
            bw.close();


        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
