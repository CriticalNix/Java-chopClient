package com.chopnix.ircbot;

import javax.swing.JOptionPane;

public class Client {

	static String MSGnick;
	
	public static void main(String[] args) throws java.net.UnknownHostException {
		MSGnick = JOptionPane.showInputDialog(null , "Please enter your nickname");
		if(MSGnick == null){
			JOptionPane.showMessageDialog(null, "You need to input a nickname, closing client", "No nickname!!", JOptionPane.OK_OPTION);
			Gui.Close();
		}		
		new Thread(new IRCConnection()).start();
		new Thread(new Gui()).start();
	}

	
	String server = "irc.chopnix.com";

	int port = 6667;

	String nick = "SNAPSHOT_" + MSGnick; //"DSG_JAVABOT";

	String channel = "#chopnixserver";
	
	String greets = "Hello all, DSG wordart bot here";

	public String getServ() {
		return server;
	}

	public int getPort() {
		return port;
	}

	public String getNick() {
		return nick;
	}

	public String getChan() {
		return channel;
	}
	
	public String getGreet() {
		return greets;
	}
}