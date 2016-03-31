package mgui.component;

import javax.swing.JButton;

import mgui.listener.ButtonListener;
import mgui.style.Style;

public class Button extends JButton implements Component {

	private static final long serialVersionUID = 1L;
	//private Panel panel;
	//private Component thisButton = this;
	
	/** add a button in the area of x,y,w,h of the component with gui content<br>
	 *  component usually use `this`<br>
	 *  x,y,w,h < 1 use % */
	public Button(Panel panel, double x, double y, double width, double height, String text, Style style) {
		super(text);
		style.apply(this, panel, x, y, width, height);
		// set listener
		addActionListener(new ButtonListener(panel));
	}
	
	public Button(Panel panel, double x, double y, double width, double height, String text) {
		this(panel, x, y, width, height, text, Style.create(Style.EMPTY));  // use default style of swing
	}
	
	public Button(Panel panel, double x, double y, double width, double height, Style style) {
		this(panel, x, y, width, height, "", style);
	}

}
