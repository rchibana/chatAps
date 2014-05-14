package br.com.unip.aps.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;

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
	private String name;
	
	private AbstractController controller;
	
	public ChatHome(Font font, String name, AbstractController controller) {
		
		this.font = font;
		this.name = name;
		
		init();
	}
	
	private void init(){
		//Initialize all attributes from chathome class
//		this.getContentPane().setLayout(new GridBagLayout());
		
		this.setResizable(false);
		this.setSize(500,500);
		this.setTitle("Chat");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.setVisible(true);
		
		
	}
	
	public void setInterface(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().setSize(panel.getWidth(), panel.getHeight());
        getContentPane().validate();
        getContentPane().repaint();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }
	
}
