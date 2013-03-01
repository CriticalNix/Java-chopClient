package com.chopnix.ircbot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;
import com.dsg.irc.DSG;

public class Gui extends Client implements Runnable, ActionListener{

	private JButton btnSend;
	
	public JTextArea textarea = new JTextArea();
	//JButton btnSend = new JButton("Send");
	JTextField input = new JTextField();
	JTextField txtSendRaw = new JTextField();
	
	
	@Override
	public void run() {
		JFrame f = new JFrame("DSG JAVABOT - SNAPSHOT 0.0.0.5");
		f.setSize(690, 520);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 400);
		f.getContentPane().add(scrollPane);
	
		//set TextBox Input
		input.setVisible(true);
		input.setBounds(10, 420, 550, 20);
		input.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DSG.SendMessage(input.getText());
				System.out.println(getNick() + " )> " + input.getText());
				input.setText("");
			}
		});
		input.addActionListener(this);
		f.getContentPane().add(input);
		
		//set Send button
		btnSend = new JButton("Send");
		btnSend.setVisible(true);
		btnSend.setBounds(565, 420, 100, 20);
		btnSend.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent ae){
				DSG.SendMessage(input.getText());
				System.out.println(getNick() + " )> " + input.getText());
				input.setText("");
			}
		});
		f.getContentPane().add(btnSend);
		btnSend.addActionListener(this);
		
		
		//set RAW textBox
		txtSendRaw.setVisible(true);
		txtSendRaw.setBounds(10, 450, 550, 20);
		txtSendRaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DSG.SendRaw(txtSendRaw.getText());
				System.out.println("RAW )> " + txtSendRaw.getText());
				txtSendRaw.setText("");
			}
			
		});
		txtSendRaw.addActionListener(this);
		f.getContentPane().add(txtSendRaw);
		
		//set RAW button
		JButton sendRAW = new JButton("Send RAW");
		sendRAW.setVisible(true);
		sendRAW.setBounds(565, 450, 100, 20);
		sendRAW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DSG.SendRaw(txtSendRaw.getText());
				System.out.println("RAW )> " + txtSendRaw.getText());
				txtSendRaw.setText("");
			}
		});
		f.getContentPane().add(sendRAW);
		sendRAW.addActionListener(this);
				
		// StreamReaderInput
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		PrintStream printStream = new PrintStream(new CustomOutputStream(
				textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		// System.setIn(NULL);
	}

	
	public static void main(String args[]) {
		new Gui().run();
	}

	public static void Close(){
		System.exit(0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
}
