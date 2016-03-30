package mgui.style;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JComponent;

import mgui.component.Button;
import mgui.component.Component;
import mgui.component.Panel;

public class Style {  // 设置和设置的主体分离，可复用

	public static final int EMPTY = 0, PANEL = 1, BUTTON = 2;
	
	private Boolean opaque, borderPainted, contentAreaFilled;
	private Color background, foreground;
	private Font font;
	private Icon icon, rolloverIcon, pressedIcon;

	private Style() {
		
	}
	
	public static Style create() {
		return create(EMPTY);
	}
	
	public static Style create(int base) {
		Style ret = new Style();
		switch (base) {
		case EMPTY:
			break;
		case BUTTON:
			ret.borderPainted = false;
			ret.contentAreaFilled = false;
			ret.background = new Color(0,0,0,0);
			break;
		case PANEL:
			ret.opaque = false;
			ret.background = new Color(0,0,0,0);
			break;
		}
		return ret;
	}
	
	/** set the component in certain area */
	public void apply(Component me, Panel parent, double x, double y, double width, double height) {
		JComponent jme = (JComponent) me;
		// in mgui layout is always null
		jme.setLayout(null);
		// set the location
		int x_ = (int) ((x > 1) ? x : x * parent.getWidth());
		int y_ = (int) ((y > 1) ? y : y * parent.getHeight());
		int w_ = (int) ((width > 1) ? width : width * parent.getWidth());
		int h_ = (int) ((height > 1) ? height : height * parent.getHeight());
		jme.setBounds(x_, y_, w_, h_);
		// set all the attribute
		if (opaque != null) jme.setOpaque(opaque);
		if (background != null) jme.setBackground(background);
		if (foreground != null) jme.setForeground(foreground);
		if (font != null) jme.setFont(font);
		if (me instanceof Button) {
			Button btme = (Button) me;
			if (borderPainted != null) btme.setBorderPainted(borderPainted);
			if (contentAreaFilled != null) btme.setContentAreaFilled(contentAreaFilled);
			if (icon != null) btme.setIcon(icon);
			if (rolloverIcon != null) btme.setRolloverIcon(rolloverIcon);
			if (pressedIcon != null) btme.setPressedIcon(pressedIcon);
		}//  else if...
		// let it show
		jme.setVisible(true);
		parent.add(jme);
		parent.repaint();
	}

	public Boolean getOpaque() {
		return opaque;
	}

	public void setOpaque(Boolean opaque) {
		this.opaque = opaque;
	}

	public Boolean getBorderPainted() {
		return borderPainted;
	}

	public void setBorderPainted(Boolean borderPainted) {
		this.borderPainted = borderPainted;
	}

	public Boolean getContentAreaFilled() {
		return contentAreaFilled;
	}

	public void setContentAreaFilled(Boolean contentAreaFilled) {
		this.contentAreaFilled = contentAreaFilled;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Icon getRolloverIcon() {
		return rolloverIcon;
	}

	public void setRolloverIcon(Icon rolloverIcon) {
		this.rolloverIcon = rolloverIcon;
	}

	public Icon getPressedIcon() {
		return pressedIcon;
	}

	public void setPressedIcon(Icon pressedIcon) {
		this.pressedIcon = pressedIcon;
	}

}
