import javax.swing.ImageIcon;

import mgui.component.Button;
import mgui.component.Component;
import mgui.component.Frame;
import mgui.component.Panel;
import mgui.style.Style;

public class Demo {

	public static Frame f;
	public static Panel scene1, scene2;
	
	public static void main(String[] args) {
		f = new Frame(544, 416, "MGUI Demo");
		scene1 = new TestPanel(f,0,0,544,416);
		//scene2 = new TestPanel2(f,0,0,544,416,Style.create(0));
	}
}

class TestPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public TestPanel(Frame f, double x, double y, double width, double height) {
		super(f, x, y, width, height);
	}
	
	public TestPanel(Frame f, double i, double j, double k, double l, Style create) {
		super(f,i,j,k,l,create);
	}

	Button btn1, btn2;
	{
		Style style = Style.create(Style.BUTTON);
		style.setIcon(new ImageIcon("1.gif"));
		btn1 = new Button(this, 0.5, 0.5, 100, 50, "test", style);
		btn2 = new Button(this, 0, 0, 100, 50, "test2");
		//repaint();
	}
	
	public void onClick(Component c) {
		if (c == btn1) {
			System.out.println("btn1 clicked");
		} else if (c == btn2) {
			new TestPanel2(Demo.f,0,0,544,416);
		}
	}

}

class TestPanel2 extends Panel {
	
	private static final long serialVersionUID = 1L;

	public TestPanel2(Frame f, double x, double y, double width, double height) {
		super(f, x, y, width, height);
	}
	
	public TestPanel2(Frame f, double i, double j, double k, double l, Style create) {
		super(f,i,j,k,l,create);
	}

	Button btn1 = new Button(this, 0.2, 0.2, 100, 50, "test");
	//Button btn2 = new Button(this, 0, 0, 100, 50, "test2");
	
	public void onClick(Component c) {
		Demo.f.popScene();
	}

}