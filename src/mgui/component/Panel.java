package mgui.component;

import javax.swing.JPanel;

import mgui.style.Style;

/** every component except panel is on a panel */
public class Panel extends JPanel implements Component {

	private static final long serialVersionUID = 1L;

	/** users should not use it outside */
	public Panel() {
	}
	
	public Panel(Frame frame, double x, double y, double width, double height, Style style) {
		super();
		style.apply(this, frame.getDefaultPanel(), x, y, width, height);
		frame.pushScene(this);
	}
	
	public Panel(Frame frame, double x, double y, double width, double height) {
		this(frame, x, y, width, height, Style.create(Style.PANEL));
	}
	
	public void onClick(Component c) {
		
	}

}
