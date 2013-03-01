package com.dsg.irc;

public class DSG_ReturnCommands {

	public static String BotCommands(String chatline){
		
		
		if(chatline.toLowerCase().contains("smoke")){
			return "(________(_(_)";
		}
	           

	        if(chatline.toLowerCase().contains("diamond")) {
	            return "***";//"OOooOO Diamonds OOooOO";
	             
	       }

	        if(chatline.toLowerCase().contains("stuff")) {
	            return "***";//"Everyone likes stuff !!!";
	            		
	             
	       }

	        if(chatline.toLowerCase().contains("smile")) {
	            return".;,,;.";
	             
	       }

	        if(chatline.toLowerCase().contains("coffee")) {
	            return "[_]D";
	             
	       }
	        if(chatline.toLowerCase().contains("tea")) {
	            return "[_]P"; 
	             
	       }

	        if(chatline.toLowerCase().contains("fish")) {
	            return "<()<";
	             
	       }

	        if(chatline.toLowerCase().contains("burnt to a crisp")){
	            return "Time to cool you down";
	       }
		
		return "***";
	}
	
	
	
	
}
