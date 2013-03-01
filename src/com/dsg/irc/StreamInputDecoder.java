package com.dsg.irc;

public class StreamInputDecoder {

	public static String Decoder(String Output){
		if(Output.toUpperCase().startsWith("PING")){
			return Output;
		}
		
		if(Output.toUpperCase().startsWith("JOIN")){
			return Output;
		}
		
		if(Output.toUpperCase().startsWith("KICK")){
			return Output;
		}
		
		if(Output.contains("PRIVMSG " + DSG.IRC_Channel + " :")){
			String tmparr[] = Output.split(":");
			String ExtractNick[] = tmparr[1].split("!");
			String IRCnick = ExtractNick[0];
		
			//String ExtractMessage[] = tmparr[1].split(":");
			
			String IrcMSG[] = Output.split(DSG.IRC_Channel + " :");
			String OutputReturn = IRCnick + " )> " + IrcMSG[1];
		
			return OutputReturn;
		}
		
		return Output;
		//  :CNBot!MinecraftB@yob-180AB306 PRIVMSG #chopnixserver :<*Server> Save Complete

	}
	
}
