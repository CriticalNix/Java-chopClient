package com.dsg.irc;

public class StreamInputDecoder {

	public static String Decoder(String Output){
		
		
		if(Output.toUpperCase().startsWith("PING")){
			return Output;
		}
		
		
		//:Nixsy!Nixsy@yob-E9633353.bb.sky.com KICK #chopnixserver DSG_Bot :Nixsy
		//:DSG_Bot!DeStilleGa@yob-7B44560.cm-7-2c.dynamic.ziggo.nl JOIN :#chopnixserver
		//:Munrek!6d0b1e82@yob-E97AAB5F.mibbit.com QUIT :Quit: http://www.mibbit.com ajax IRC Client


		
		if(Output.toUpperCase().contains("JOIN")){
			String tmparr[] = Output.split(":");
			if(tmparr[1].contains("JOIN")){
				String ExtractNick[] = tmparr[1].split("!");
				String IRCnick = ExtractNick[0];
		
				StringBuilder a = new StringBuilder();
				
				a.append("[INFO]> ");
				a.append(IRCnick);
				a.append(" has joined ");
				a.append(DSG.IRC_Channel);
				
				return a.toString();
				
			}
			//return Output; 
		}
		
		if(Output.toUpperCase().contains("KICK")){
			String tmparr[] = Output.split(":");
				if(tmparr[1].contains("KICK")){
					String ExtractNick[] = tmparr[1].split("!");
					String IRCnick = ExtractNick[0];
					String KickMessage = tmparr[2];
					
					String[] Kicked = tmparr[1].split(DSG.IRC_Channel);
					
					StringBuilder a = new StringBuilder();
					
					a.append("[INFO]> ");
					a.append(IRCnick);
					a.append(" has kicked ");
					a.append(Kicked[1]);
					a.append(" for reason '");
					a.append(KickMessage);
					a.append("'");
					
					return a.toString();
				}
		}
		
		if(Output.toUpperCase().contains("NICK")){
			String tmparr[] = Output.split(":");
			
			if(tmparr[1].contains("NICK")){
			
			String ExtractNick[] = tmparr[1].split("!");
			String IRCnick = ExtractNick[0];
		
			String newNick = tmparr[2];
			
			StringBuilder a = new StringBuilder();
			
			a.append("[INFO]> ");
			a.append(IRCnick);
			a.append(" has changed nickname to: ");
			a.append(newNick);
			
			return a.toString();
			}
			//return Output;
		}
		
		
		//:DSG_bot!DeStilleGa@yob-7B44560.cm-7-2c.dynamic.ziggo.nl NICK :DSG_Bot

		
		if(Output.contains("PRIVMSG " + DSG.IRC_Channel + " :")){
			String tmparr[] = Output.split(":");
			String ExtractNick[] = tmparr[1].split("!");
			String IRCnick = ExtractNick[0];
		
			//String ExtractMessage[] = tmparr[1].split(":");
			
			String IrcMSG[] = Output.split(DSG.IRC_Channel + " :");
			String OutputReturn = IRCnick + " )> " + IrcMSG[1];
		
			return OutputReturn;
		}
		
		if(Output.contains("PRIVMSG " + DSG.IRC_name + " :")){
			String tmparr[] = Output.split(":");
			String ExtractNick[] = tmparr[1].split("!");
			String IRCnick = ExtractNick[0];
		
			//String ExtractMessage[] = tmparr[1].split(":");
			
			String IrcMSG[] = Output.split(DSG.IRC_name + " :");
			String OutputReturn = "[PrivateMessage]) " + IRCnick + " )> " + IrcMSG[1];
		
			return OutputReturn;
		}
		
		return Output;
		//  :CNBot!MinecraftB@yob-180AB306 PRIVMSG #chopnixserver :<*Server> Save Complete
		//	:DeStilleGast!DeStilleGa@yob-7B44560.cm-7-2c.dynamic.ziggo.nl PRIVMSG SNAPSHOT_PMtest :www.google.nl

	}
	
}
