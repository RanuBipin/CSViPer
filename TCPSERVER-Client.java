import java.io.*;
import java.net.*;
public class TCPServer
{
public static void main(String[] args)
{
try
{
ServerSocket serverobj=new ServerSocket(6600);
System.out.println("server is started");
Socket sobj=serverobj.accept();
System.out.println("client connected to server");
DataInputStream dis=new DataInputStream(sobj.getInputStream());
String str=(String)dis.readUTF();
System.out.println("message from client is: "+str);
sobj.close();
serverobj.close();
}
catch(Exception ex)
{
System.out.println(ex.getMessage());
}
}
}
--------------------------------------------------------------------------Server Program----------------------------------------------------------------------------
import java.io.*;
import java.net.*;
import java.util.*;
public class TCPClient
{
public static void main(String[] args)
{
try
{
Socket sktobj=new Socket("localhost",6600);
DataOutputStream dos=new DataOutputStream(sktobj.getOutputStream());
System.out.println("Enter message to be sent to server");
Scanner sc=new Scanner(System.in);
String read=sc.nextLine();
dos.writeUTF(read);
dos.flush();
sktobj.close();
dos.close();
}
catch(Exception ex)
{
System.out.println(ex.getMessage());
}
}
}
-----------------------------------------------------------------------------Client Program-----------------------------------------------------------------------
