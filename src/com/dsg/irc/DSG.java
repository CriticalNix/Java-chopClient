package com.dsg.irc;

import java.io.IOException;
import com.chopnix.ircbot.Client;
import com.chopnix.ircbot.IRCConnection;



public class DSG extends Client{
	public static String IRC_Channel = "";
	public static boolean IRC_connected = false;
	
	
	public static void SendMessage(String SendText) {
		try{
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
	
	
}

