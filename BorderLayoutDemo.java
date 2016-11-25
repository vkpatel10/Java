import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class BorderLayoutDemo implements ActionListener,ItemListener{
	private JPanel pane[] = new JPanel[5];
	private	JButton jbtn[] = new JButton[5];
	private JCheckBox jcbx[] = new JCheckBox[5];
	
	public void addComponents(Container content){
		for(int i=0 ; i<pane.length ;i++){
			pane[i] = new JPanel();
			pane[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			pane[i].setPreferredSize(new Dimension(80,80));
			pane[i].setBackground(Color.WHITE);
		}
		
		pane[0].setLayout(new FlowLayout());
		
		String [] color = {"RED","GREEN","BLUE","YELLOW","PINK"};
		for(int i=0 ; i<5 ;i++){
			jbtn[i] = new JButton(color[i]);
			jbtn[i].setName(color[i]);
			jbtn[i].addActionListener(this);
			pane[0].add(jbtn[i]);
			
		}
		for(int i=0 ; i<5 ;i++){
			jcbx[i] = new JCheckBox(color[i]);
			jcbx[i].setName(color[i]);
			pane[i].add(jcbx[i]);
			jcbx[i].addItemListener(this);
		}
		
		content.add(pane[0],BorderLayout.WEST);
		content.add(pane[1],BorderLayout.EAST);
		content.add(pane[2],BorderLayout.SOUTH);
		content.add(pane[3],BorderLayout.NORTH);
		content.add(pane[4],BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event){
		JComponent cmp = (JComponent) event.getSource();
		
		if(cmp.getName().equals("RED")){
			pane[4].setBackground(Color.RED);
		}
		else if(cmp.getName().equals("YELLOW")){
			pane[4].setBackground(Color.YELLOW);
		}
		else if(cmp.getName().equals("GREEN")){
			pane[4].setBackground(Color.GREEN);
		}
		else if(cmp.getName().equals("BLUE")){
			pane[4].setBackground(Color.BLUE);
		}
		else{
			pane[4].setBackground(Color.PINK);
		}
	}
	public void itemStateChanged(ItemEvent e){
		Object source = e.getItemSelectable();
		
		if(source == jcbx[0]){
			if(jcbx[0].isSelected()){
				pane[0].setBackground(Color.RED);
			}
			else{
				pane[0].setBackground(Color.WHITE);
			}
		}
		else if (source == jcbx[1]){
			if(jcbx[1].isSelected()){
				pane[1].setBackground(Color.GREEN);
			}
			else{
				pane[1].setBackground(Color.WHITE);
			}
		}
		else if (source == jcbx[2]){
			if(jcbx[2].isSelected()){
				pane[2].setBackground(Color.BLUE);
			}
			else{
				pane[2].setBackground(Color.WHITE);
			}
		}
		else if (source == jcbx[3]){
			if(jcbx[3].isSelected()){
				pane[3].setBackground(Color.YELLOW);
			}
			else{
				pane[3].setBackground(Color.WHITE);
			}
		}
		else{
			if(jcbx[4].isSelected()){
				pane[4].setBackground(Color.PINK);
			}
			else{
				pane[4].setBackground(Color.WHITE);
			}
		}
	}
}