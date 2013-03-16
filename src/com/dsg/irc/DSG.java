package com.dsg.irc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import com.chopnix.ircbot.Client;
import com.chopnix.ircbot.IRCConnection;



public class DSG extends Client{
	public static String IRC_Channel = "";
	public static String IRC_name = "";
	public static boolean IRC_connected = false;
	public static boolean ActAsBot = false;
	
	static Client client;
	
	public static void SendMessage(String SendText) {
		try{
			char ColorChar = 3; //ColorSuport for server
			char replaceCC = 59; //;
			
			SendText = SendText.replace(replaceCC, ColorChar);
			
				IRCConnection.io.bw().write("PRIVMSG " + IRC_Channel + " :" + SendText + "\r\n");
				IRCConnection.io.bw().flush();			
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
 
	public static void SendRaw(String RAWText){
		try{
			IRCConnection.io.bw().write(RAWText + "\r\n");
			IRCConnection.io.bw().flush();			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}	
	

	public static void Close(String CloseMessage){
		try{
			IRCConnection.io.bw().write("QUIT :"+ CloseMessage + "\r\n");
			IRCConnection.io.bw().flush();			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}	
	
	public static int GetScreenSizeX(Window window){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 
		int w = window.getSize().width;
		int x = (dim.width-w);
		return x;
	}
	
	public static int GetScreenSizeY(Window window){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 
		int h = window.getSize().height;
		int y = (dim.height-h);
		return y;
	}
	
	
}

