import java.awt.*;

public class HelloWorld3 {
	public static void main (String args[]) {
		HelloWorldFrame frame = new HelloWorldFrame();
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
class HelloWorldFrame extends java.awt.Frame {
	public HelloWorldFrame(){
		this.setTitle("Hello MCU ITE");
	}
}