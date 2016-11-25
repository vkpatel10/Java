import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TestBorderLayout{
	public static void main(String args[]){	
		JFrame jf = new JFrame("BorderLayout Demo");
		Toolkit tk = jf.getToolkit();
		Dimension wSize = tk.getScreenSize();
		jf.setBounds(0,0,wSize.width,wSize.height-10);
		
		Container content = jf.getContentPane();
		content.setLayout(new BorderLayout());
		
		BorderLayoutDemo obj = new BorderLayoutDemo();
		obj.addComponents(content);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}