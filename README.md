# MGUI

An easy encapsulation of Java Swing for myself.

## Example

``` java
// This code shows how to add buttons on a panel.
// (in your panel extends mgui.component.Panel)
Button btn1 = new Button(this, 0, 0, 100, 50, "say hello");

public void onClick(Component c) {
	if (c == btn1) {
		System.out.println("Hello world!");
	}
}
```

For more usage please see the wiki.

## How to Use

1. Download mgui.jar
2. Add External JARs in Java Build Path
3. Enjoy
