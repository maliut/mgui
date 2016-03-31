package mgui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mgui.component.Component;
import mgui.component.Panel;

public class ButtonListener extends AbstractListener implements ActionListener {

	public ButtonListener(Panel panel) {
		super(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.onClick((Component) e.getSource());
	}

}
