import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;


public class Lists extends JFrame{
	
	private final static String TAG = Lists.class.getName();
	
	JScrollPane logScroll;
	JTextArea logsArea;
	HashMap<String, Color> colorSet;
	String[] list;
	int listSize;
	DefaultListModel leftModel, rightModel;
	Color[] colors;
	JList listRight, listLeft;
	JButton btnLeft, btnRight;
	private JButton btnNewButton;
	
	
	static public void main(String args[]){
		
		Lists test =  new Lists();
	}
	
	public Lists() {
				
		System.out.println(TAG + " class called");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setTitle("JList");
		this.setSize(400, 280);
		
		setColors();
		setLeftList();
		setRightList();
		setBtnLeft();
		setBtnRight();
		setBtnColor();
		setLogList();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	//Set colors
	private void setColors(){
		
		list = new String[]{"white", "blue", "yellow", "red", "green", "orange", "grey", "black"};	
		listSize = list.length;		
		colors = new Color[]{Color.WHITE, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.ORANGE, Color.GRAY, Color.BLACK};
		colorSet = new HashMap<>();

		for(int i = 0; i < list.length; i++){
			
			colorSet.put(list[i], colors[i]);
		}
		
	}
	
	
	//Create a List object
	private void setLeftList(){
		
		leftModel = new DefaultListModel();
		
		for(String str : list){
			
			leftModel.addElement(str);
		}
		
		listLeft = new JList(leftModel);
		listLeft.setBounds(155, 116, 61, 128);
		listLeft.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listLeft.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				displayLogs("LEFT LIST activated");
			}
		});
		
		JScrollPane leftScroll = new JScrollPane(listLeft);
		leftScroll.setLocation(52, 40);
		leftScroll.setSize(80, 72);
		getContentPane().add(leftScroll);	
	}
	
	
	private void setRightList(){
			
		rightModel = new DefaultListModel();
		
		listRight = new JList(rightModel);
		listRight.setBounds(155, 116, 61, 128);
		listRight.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listRight.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				displayLogs("RIGHT LIST activated");
			}
		});
		
		JScrollPane  rightScroll = new JScrollPane(listRight);
		rightScroll.setLocation(267, 40);
		rightScroll.setSize(80, 72);
		getContentPane().add(rightScroll);
	}
	
	
	private void setLogList(){
		
		logsArea = new JTextArea("");
		logsArea.setBounds(52, 141, 295, 72);
		logsArea.setLineWrap(true);
		logsArea.setWrapStyleWord(true);
		logsArea.setEditable(false);
        
		logScroll = new JScrollPane(logsArea);
		logScroll.setLocation(52, 142);
		logScroll.setSize(295, 72);
		getContentPane().add(logScroll);		
	}
	
	
	private void displayLogs(String action){
		
		logsArea.append(action + "\n");
	}
	
	
	private void setBtnLeft(){
		
		btnLeft = new JButton("<<<");
		btnLeft.setBounds(155, 38, 89, 23);
		btnLeft.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				displayLogs("LEFT button clicked");

				if(listRight.getSelectedIndices() != null){
					
					int[] selected = listRight.getSelectedIndices();
					displayLogs("Selected Items: " + selected.length);

						if(selected.length > 0){
					
						String[] items = new String[selected.length];
						listRight.getSelectedValuesList().toArray(items);
					
						for(String str : items){
							
							leftModel.addElement(str);
							rightModel.removeElement(str);
						}			
					
						displayLogs("Items: " + Arrays.toString(items));
					}

				}
				
			}
			
		});
		getContentPane().add(btnLeft);
	}
	
	
	private void setBtnRight(){ 
		
		btnRight = new JButton(">>>");
		btnRight.setBounds(155, 61, 89, 23);
		btnRight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				displayLogs("RIGHT button clicked");
				
				if(listLeft.getSelectedIndices() != null){
					
					int[] selected = listLeft.getSelectedIndices();
					displayLogs("Selected Items: " + selected.length);

					if(selected.length > 0){
						
						String[] items = new String[selected.length];
						listLeft.getSelectedValuesList().toArray(items);
						
						for(String str : items){
							
							rightModel.addElement(str);
							leftModel.removeElement(str);
						}		
						
						displayLogs("Items: " + Arrays.toString(items));
					}
										
				}
				
			}
			
		});
		getContentPane().add(btnRight);	
	}
	
	
	private void setBtnColor(){
		
		btnNewButton = new JButton("Set Color");
		btnNewButton.setBounds(155, 89, 89, 23);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				displayLogs("COLOR button clicked");

				if(listLeft.getSelectedIndices() != null){
					
					if(listLeft.getSelectedIndices().length > 0){
						
						String colorStr = leftModel.getElementAt(listLeft.getSelectedIndices()[0]).toString();
						Color color = colorSet.get(colorStr);
						
						if(getContentPane().getBackground() != color){
							
							setBgColor(color);
							displayLogs("New background color: " + color);
						}
						else{
							
							displayLogs("Background color remains the same: " + color);
						}
						
					}					

				}									
				
			}
			
		});
		getContentPane().add(btnNewButton);
	}
	
	
	//Set background color
	private void setBgColor(Color color) {
		
		this.getContentPane().setBackground(color);
	}
	
	//END OF CLASS
}
