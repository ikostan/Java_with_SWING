import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FirstRun extends JFrame{
		
	private final String TAG = FirstRun.class.getName();
	
	private JPanel panel;
	private JLabel lblLabel;
	private JButton btnButton, btnHeader;
	private final String defaultTitle = "First run", newTitle = "New Title";
	
	public FirstRun() {
		
		setResizable(false);
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(defaultTitle);
		this.setSize(285, 200);
			
		setPanel();
		setLabel();
		setClickMeButton();
		setChangeHeaderBtn();
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
		
		System.out.println(TAG + " class called");
	}
	
	
	private void setPanel(){
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
	
	
	private void setLabel(){
		
		lblLabel = new JLabel("");
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblLabel.setBounds(50, 27, 175, 40);
		panel.add(lblLabel);
	}
	
	
	private void setClickMeButton(){
		
		btnButton = new JButton("Click me");
		btnButton.setBounds(50, 78, 175, 25);
		btnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(lblLabel.getText().toString().equals("")){
					
					lblLabel.setText("Hello World!");
				}
				else{
					
					lblLabel.setText("");
				}
			}
			
		});
		panel.add(btnButton);
	}
	
	
	private void setChangeHeaderBtn(){
		
		btnHeader = new JButton("Change Header");
		btnHeader.setBounds(50, 125, 175, 23);
		btnHeader.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(getWindowTitle().equals(defaultTitle)){
					
					 setWindowTitle(newTitle);
				}
				else{
					
					 setWindowTitle(defaultTitle);
				}
			}
			
		});
		panel.add(btnHeader);
	}
	
	
	private String getWindowTitle(){
		
		return this.getTitle().toString();
	}
	
	
	private void setWindowTitle(String title){
		
		this.setTitle(title);
	}
	
	
	//END
}
