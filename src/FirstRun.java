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
	public FirstRun() {
		setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("First run");
		this.setSize(285, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLabel = new JLabel("");
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblLabel.setBounds(50, 45, 175, 40);
		panel.add(lblLabel);
		
		JButton btnButton = new JButton("Click me");
		btnButton.setBounds(50, 115, 175, 25);
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
		
		this.setVisible(true);
	}
}
