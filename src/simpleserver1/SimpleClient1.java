/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author youqunfang
 */
public class SimpleClient1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 2222);
        PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream());
        Scanner fromServer = new Scanner(clientSocket.getInputStream());
        String request ="youqun fang";
        System.out.println("client sending String =" + request);
        toServer.println(request);
        toServer.flush();
        while(fromServer.hasNextLine()){
            System.out.println("server sending String = " + fromServer.nextLine());
        }
        clientSocket.close();
    }
}
