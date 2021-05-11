/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import util.FileUtility;

/**
 *
 * @author dell
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a port number: ");
        int port = sc.nextInt();
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter the directory for saving the file: ");
            String fileName = s.nextLine();
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            byte[] arr = util.FileUtility.readMessage(dis);
            FileUtility.writeBytes(fileName, arr);
            System.out.println("File successfully transfered!");
        }
    }

}
