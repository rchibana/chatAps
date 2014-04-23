package br.com.unip.aps.controller;

import java.awt.event.ActionEvent;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerChatHome extends AbstractController{

	public ControllerChatHome(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see br.com.unip.aps.controller.AbstractController#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		System.out.println(e.getActionCommand());
		System.out.println("teste");
	}
	
}
