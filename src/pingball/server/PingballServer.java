package pingball.server;

import java.io.*;
import java.net.*;
import java.util.*;

import boardPhysics.Board;

public class PingballServer {
    
    //the server socket
    private final ServerSocket serverSocket;
    private final Board board;
    
    /**
     * Make a PingballServer that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     * @throws IOException
     */
    public PingballServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.board = board;
    }
    
    /**
     * Run the server, listening for client connections and handling them.
     * Never returns unless an exception is thrown.
     * 
     * @throws IOException if the main server socket is broken
     *                     (IOExceptions from individual clients do *not* terminate serve())
     */
    public void serve() throws IOException {
        //TODO
    }
    
    /**
     * Handle multiple client connections. Returns when all client disconnect.
     * 
     * @param socket socket where the client is connected
     * @throws IOException if connection has an error or terminates unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException {
        //TODO
    }
    
    /**
     * Start a PingballServer using the given arguments.
     * 
     * Usage: PingballServer [--host HOST] [--port PORT] FILE
     * @param args argument provided by user (optional host, optional port, filename)
     */
    public static void main(String[] args) {
        //TODO
    }
    
    /**
     * Start a PingballServer running on the specified port, with a board loaded from a file.
     * 
     * @param file Start with a board loaded from the specified file, according to the input file format
     * defined in the pingball spec.
     * @param port The network port on which the server should listen.
     * @throws IOException
     */
    public static void runPingballServer(File file, int port) throws IOException{
        PingballServer server = new PingballServer(board, port);
        server.serve();
    }
}