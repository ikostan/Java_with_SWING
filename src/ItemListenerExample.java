import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;

public class ItemListenerExample extends JFrame implements ItemListener{

	private final String TAG = ItemListenerExample.class.getName();

	private JCheckBox chckBox_1, chckBox_2, chckBox_3;
	private JPanel panelChk, panelList;
	
	private JList list;
	private JScrollPane scrollPane;
	private DefaultListModel model;
	
	//Main method
	public static void main(String[] args) {

		ItemListenerExample test = new ItemListenerExample();
	}

	
	//Constructor
	public ItemListenerExample(){
		
		System.out.println(TAG + " class called");

		setGUI();
		setChkBoxes();
		setList();
		
		this.setVisible(true);
	}
	
	
	private void setList(){
		
		panelList = new JPanel();
		
		model = new DefaultListModel();
		list = new JList();	
		list.setModel(model);
		scrollPane = new JScrollPane(list);
		panelList.add(scrollPane);
		
		this.getContentPane().add(panelList, BorderLayout.SOUTH);

	}
	
	
	private void setChkBoxes(){
		
		panelChk = new JPanel();
		getContentPane().add(panelChk, BorderLayout.CENTER);
		panelChk.setLayout(new GridLayout(3, 2, 0, 0));
		
		chckBox_1 = new JCheckBox("Check box 1");
		chckBox_1.addItemListener(this);
		panelChk.add(chckBox_1);
		
		chckBox_2 = new JCheckBox("Check box 2");
		chckBox_2.addItemListener(this);
		panelChk.add(chckBox_2);
		
		chckBox_3 = new JCheckBox("Check box 3");
		chckBox_3.addItemListener(this);
		panelChk.add(chckBox_3);
	}
	
	
	private void setGUI(){
		
		this.setTitle(TAG);
		this.setSize(350, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		Object sourceObj = arg0.getItemSelectable();
		String element = null;
		
		if(sourceObj == chckBox_1){
			
			element = "Check box 1";
			
			if(chckBox_1.isSelected()){
				
				element += " is checked";
			}
			else{
				
				element += " is unchecked";
			}
		}
		else if(sourceObj == chckBox_2){
			
			element = "Check box 2";
			
			if(chckBox_2.isSelected()){
				
				element += " is checked";
			}
			else{
				
				element += " is unchecked";
			}
		}
		else if(sourceObj == chckBox_3){
			
			element = "Check box 3";
			
			if(chckBox_3.isSelected()){
				
				element += " is checked";
			}
			else{
				
				element += " is unchecked";
			}
		}
			
		model.addElement(element);
		System.out.println(element);
		
		//Show last row
		int lastIndx = list.getModel().getSize() - 1;		
		if(lastIndx >= 0){
			
			list.ensureIndexIsVisible(lastIndx);
		}
	}


	
	//END
}
