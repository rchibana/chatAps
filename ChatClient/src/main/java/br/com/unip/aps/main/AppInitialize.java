package br.com.unip.aps.main;

import java.awt.Font;

import br.com.unip.aps.view.ChatHome;
import br.com.unip.aps.view.ChatLogin;

public class AppInitialize {

	public static void main(String[] args) {
		
		Font font = new Font("Arial", Font.PLAIN, 14);
		
		ChatLogin cl = new ChatLogin(font);
		cl.setVisible(true);;
		
		
	}
	
}
