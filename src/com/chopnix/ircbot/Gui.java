package com.chopnix.ircbot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.PrintStream;
import javax.swing.*;

import com.dsg.irc.DSG;
import com.dsg.irc.frmColors;

public class Gui extends Client implements Runnable, ActionListener{

	private JButton btnSend;
	private int Xas = 0;
	private int Yas = 0;
	
	public JTextArea textarea = new JTextArea();
	//JButton btnSend = new JButton("Send");
	JTextField input = new JTextField();
	JTextField txtSendRaw = new JTextField();
	
	
	public void run() {
		JFrame f = new JFrame("DSG JAVABOT - SNAPSHOT 0.1.5");
		f.setSize(690, 550);
		f.setResizable(false);
		f.setVisible(true);
		f.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				try{
					StringBuilder byeMessage = new StringBuilder();
					byeMessage.append("Client was closed manuel, greetzzz ");
					byeMessage.append(getNick());
					
					DSG.Close(byeMessage.toString());
				}catch (Exception ex){
					
				}
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		f.setLocation(DSG.GetScreenSizeX(f)/2 - (ImageObserver.WIDTH/2), DSG.GetScreenSizeY(f)/2 - (ImageObserver.HEIGHT/2));
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 660, 400);
		f.getContentPane().add(scrollPane);
	
		//set TextBox Input
		input.setVisible(true);
		input.setBounds(10, 420, 550, 20);
		input.addActionListener(new ActionListener(){

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
				
		//set Nickname button
		JButton ChangNick = new JButton("Change nick");
		ChangNick.setVisible(true);
		ChangNick.setBounds(10, 480, 120, 20);
		ChangNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NewNick = JOptionPane.showInputDialog(null , "Please enter new nickname");
				if(NewNick != null){
					DSG.SendRaw("nick " + NewNick);
				}
				nick = NewNick;
			}
		});
		f.getContentPane().add(ChangNick);
		ChangNick.addActionListener(this);
		
		//set Check
		JCheckBox actAsBot = new JCheckBox("Act as bot");
		actAsBot.setVisible(true);
		actAsBot.setBounds(140, 480, 120, 20);
		actAsBot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				DSG.ActAsBot =! DSG.ActAsBot;
			}
		});
		f.getContentPane().add(actAsBot);
		actAsBot.addActionListener(this);
		
		//Add ColorChar button
		/*JButton ColorButton = new JButton("Color");
		ColorButton.setVisible(true);
		ColorButton.setBounds(140, 480, 120, 20);
		ColorButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String CurrentText;
			char ColorChar = 3;
			
			CurrentText = input.getText();
			input.setText(CurrentText + ColorChar);
			
		}});
		f.getContentPane().add(ColorButton);
		ColorButton.addActionListener(this);*/
		
		
		
		
		// StreamReaderInput
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false); //People are not allowed to change the chat
		textArea.setForeground(Color.CYAN);
		
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		// System.setIn(NULL);
		
		Xas = f.getX();
		Yas = f.getY();
	}

	
	public static void main(String args[]) {
		new Gui().run();
		new frmColors().run();
	}

	public static void Close(){
		DSG.Close("GuiTest is ok =)");
		JOptionPane.showMessageDialog(null, "GuiTest", "GuiTest", JOptionPane.OK_OPTION);
		System.exit(0);
	}

	public int getXas(){
		return Xas;
	}
	
	public int getYas(){
		return Yas;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
}
