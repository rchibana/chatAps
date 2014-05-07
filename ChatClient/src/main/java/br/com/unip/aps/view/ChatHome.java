package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.unip.aps.controller.AbstractController;
import br.com.unip.aps.controller.ControllerChatHome;
import br.com.unip.aps.controller.ControllerChatLogin;


public class ChatHome extends JFrame{

	private static final long serialVersionUID = 1L;
	private Font font;
	
	private AbstractController chatHome;
	
	public ChatHome() {
		
		font = new Font("Arial", Font.PLAIN, 14);
		chatHome = new ControllerChatHome();
		
		ChatLogin login = new ChatLogin(font, new ControllerChatLogin());
		setInterface(login);
		
		init();
	}
	
	private void init(){
		//Initialize all attributes from chathome class
		this.setResizable(false);
		this.setSize(500,500);
		this.setTitle("Chat");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
		this.setResizable(false);
        this.setVisible(true);
		
		
	}
	
	public void setInterface(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(BorderLayout.CENTER, panel);
        getContentPane().validate();
        getContentPane().repaint();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }
	
}
