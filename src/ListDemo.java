import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

public class ListDemo extends JFrame{

	private final String TAG = Main.class.getName();
	
	private JList list;
	private JTextField txtField;
	private JPanel panel; 
	private JButton btnButton, btnRemove;
	
	
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
		
		list = new JList();
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
		
		btnRemove = new JButton("Add");
		btnRemove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}			
			
		});
		panel.add(btnRemove);
	}
	
	
	
	private void setRemoveBtn(){
		
		btnButton = new JButton("Remove");
		btnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
					
		});
		panel.add(btnButton);
	}
	
	
	private void setInputField(){
		
		txtField = new JTextField();
		panel.add(txtField);
		txtField.setColumns(10);
	}

	
	//END
}
