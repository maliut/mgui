package mgui;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Frame(int width, int height) {
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/** set the title of frame */
	public void setTitle(String title) {
		super.setTitle(title);
	}
	
	// 还没想好初始设置图标和标题的方式。配置文件？

}
