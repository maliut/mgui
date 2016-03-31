package mgui.component;

import java.awt.Color;
import java.awt.Image;
import java.util.Stack;

import javax.swing.JFrame;

/** base class for a frame */
public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Stack<Panel> scenes;
	private Panel defaultPanel, emptyPanel;  // default panel
	// default panel is used as the father of your user-defined panels
	// you should put other components(buttons, labels, etc) on your user-defined panels
	// and put your user-defined panels on default panel
	// (pushScene() just put the scene(panel) on default panel(not directly on the frame))
	// 注：增加默认层是为了 panel 和 button、label 等其他 component 中构造方法中的一堆东西可以抽出成为 behavior，增强重用性
	
	public Frame(int width, int height, String title, Image icon) {
		scenes = new Stack<Panel>();
		// frame settings
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		if (icon != null) setIconImage(icon);
		// set default panel
		emptyPanel = new Panel();
		defaultPanel = new Panel();
		defaultPanel.setBounds(0, 0, width, height);
		defaultPanel.setOpaque(false);
		defaultPanel.setLayout(null);
		defaultPanel.setBackground(new Color(0,0,0,0));
		defaultPanel.setVisible(true);	
		add(defaultPanel);
		// show
		setVisible(true);
	}
	
	public Frame(int width, int height, String title) {
		this(width, height, title, null);
	}
	
	public Frame(int width, int height) {
		this(width, height, "", null);
	}
	
	public void pushScene(Panel scene) {
		scenes.push(scene);
		//defaultPanel.add(scene);  // implemented in style.java
		defaultPanel.setComponentZOrder(scene, 0);
		defaultPanel.repaint();
	}
	
	public Panel getCurrentScene() {
		return scenes.isEmpty() ? emptyPanel : scenes.peek();
	}
	
	public Panel popScene() {
		Panel s = scenes.pop();
		defaultPanel.remove(s);
		defaultPanel.repaint();
		return s;
	}
	
	public Panel getDefaultPanel() {
		return defaultPanel;
	}

}
