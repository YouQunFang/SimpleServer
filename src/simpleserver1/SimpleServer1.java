/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youqunfang
 */
public class SimpleServer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            while(true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                Scanner fromClient = new Scanner(clientSocket.getInputStream());
                String response = "";
                    if(fromClient.hasNextLine()){
                        response = fromClient.nextLine();
                        
                    }
                    
                    toClient.println(response);
                    toClient.flush();
                    clientSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(SimpleServer1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
