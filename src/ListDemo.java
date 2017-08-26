import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ListDemo extends JFrame{

	private final String TAG = ListDemo.class.getName();
	
	private JList list;
	private JTextField txtField;
	private JPanel panel; 
	private JButton btnRemove, btnAdd;
	private DefaultListModel listModel;
	
	//Main method
	public static void main(String[] args) {

		ListDemo test = new ListDemo();
	}
	
	
	//Constructor
	public ListDemo(){
		
		System.out.println(TAG + " class called");
		
		setGUI();
		setList();
		setBottomPanel();
		
		this.setVisible(true);
	}
	
	
	private void setGUI(){
		
		this.setTitle(TAG);
		this.setResizable(false);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
	}
	
	
	private void setList(){
		
		listModel = new DefaultListModel();
		
		list = new JList();
		list.setModel(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	
	private void setBottomPanel(){
		
		panel = new JPanel();
		
		setRemoveBtn();
		setInputField();
		setAddBtn();
		
		getContentPane().add(panel, BorderLayout.SOUTH);
	}
	
	
	private void setAddBtn(){
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String item = txtField.getText().toString().trim();
				
				if(!item.equals("") && item != null){
					
					boolean isExist = false;
												
					for(int i = 0; i < listModel.size(); i++){
						
						if(item.equals(listModel.getElementAt(i))){
							
							isExist = true;
							System.out.println("Duplicate found: " + item);
							break;
						}
					}					
					
					if(!isExist){
						
						listModel.addElement(item);
						txtField.setText("");
						btnAdd.setEnabled(false);
						System.out.println("A new item added: " + item);
					}
					else{
						
						String error = "Duplicates are not allowed";
						showError(error);
					}

				}
				else{

					String error = "Empty strings is not allowed";
					showError(error);
				}
			}			
			
		});
		
		btnAdd.setEnabled(false);
		panel.add(btnAdd);
	}
	
	
	private void setRemoveBtn(){
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(list.getSelectedIndex() != -1){
					
					listModel.removeElement(list.getSelectedValue());
				}
				else{
					
					String error = "Please select an item first";
					showError(error);
				}
			}
					
		});
		panel.add(btnRemove);
	}
	
	
	private void showError(String error){
		
		JOptionPane.showMessageDialog(ListDemo.this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	private void setInputField(){
		
		txtField = new JTextField();
		txtField.addKeyListener(new KeyAdapter() {
			
	        public void keyReleased(KeyEvent e) { //watch for key strokes
	        	
	        	enableDddBtn();
	        }
	 });
		
		panel.add(txtField);
		txtField.setColumns(10);
	}

	
	private void enableDddBtn(){
		
		System.out.println("Text field object is activated");
		
		if(!txtField.getText().toString().trim().equals("")){
			
			btnAdd.setEnabled(true);

		}
		else{
			
			btnAdd.setEnabled(false);
		}
	}
	
	
	//END
}
