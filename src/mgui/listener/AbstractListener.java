package mgui.listener;

import mgui.component.Panel;

public abstract class AbstractListener {

	protected Panel panel;  // the panel to deal with the mouse/keyboard/button... events
	
	protected AbstractListener(Panel panel) {
		this.panel = panel;
	}
}
