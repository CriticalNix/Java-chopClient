package com.chopnix.ircbot;

import java.io.*;
import java.net.Socket;

public class InputOutput {

	BufferedReader br;

	BufferedWriter bw;

	public InputOutput(Socket s) throws IOException {
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	}

	public BufferedReader br(PrintStream printStream) {
		return br;
	}

	public BufferedWriter bw() {
		return bw;
	}
}
