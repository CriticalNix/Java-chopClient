package com.chopnix.ircbot;

import java.io.IOException;
import java.net.Socket;

//import com.DSG.IRC.DSG_ReturnCommands;
import com.dsg.irc.DSG;
import com.dsg.irc.DSG_ReturnCommands;
import com.dsg.irc.StreamInputDecoder;

public class IRCConnection extends Client implements Runnable {

	public static InputOutput io;

	Socket s;

	public IRCConnection() throws java.net.UnknownHostException {
		try {
			s = new Socket(getServ(), getPort());
			io = new InputOutput(s);
		} catch (IOException ioe) {
			System.out.println(ioe);

		}
	}
	
	public void run() {
		String l = "";
//		String line = (l);

		try {
			new IRCConnection();
			io.bw().write("NICK " + getNick() + "\r\n");
			io.bw().write("USER " + getNick() + " 8 * :DSG_NIXBOT\r\n");
			io.bw().flush();

			while ((l = io.br(null).readLine()) != null) {
				
				if(DSG.IRC_connected){
					l = StreamInputDecoder.Decoder(l);
				}
					
				System.out.println(l);
				
				
				if (l.startsWith("PING")) {
					io.bw().write("PONG " + l.substring(5) + "\r\n");
					io.bw().flush();
				}
				
				if (l.contains("Your host is:")){
					System.out.println(l);
				}

				if (l.contains("MOTD File is missing")) {
					io.bw().write("JOIN " + getChan() + "\r\n");
					//io.bw().write("PRIVMSG " + getChan() + " " + getGreet() + "\r\n");
					io.bw().flush();
					DSG.IRC_Channel = getChan();
				}
				
				if (l.contains(getNick() + " " + getChan() +" :End of /NAMES list.")){
					DSG.IRC_connected= true;
					System.out.println("Succesfull connected =D");
					System.out.println("Decoder is activated !!!");
				}
				
				/*if (l.contains("!Usage")){
					System.out.println("Joined channel successfully.");
					io.bw().flush();
				}*/
				
				if(l.contains(",,close")){
					io.bw().write("QUIT :Bot was Turned off.\r\n");
					io.bw().flush();
					Gui.Close();
				}
				
				String DSG_art = DSG_ReturnCommands.BotCommands(l) ;
					
				if(DSG_art != "***"){
					io.bw().write("PRIVMSG " + getChan() + " " + DSG_art + "\r\n");
					io.bw().flush();
				}
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private String getLine(String in) {
		String lines[] = in.split(" :");
		if (lines.length > 2) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < lines.length - 1; i++) {
				sb.append(lines[i] + " :");
			}
			return sb.toString();
		} else {
			return lines[1];
		}
	}
}