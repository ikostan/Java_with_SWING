import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class MainComponents extends JFrame{
	
	private JPanel panel;
	private JLabel lblMainSwingComponents, lblRadioGroups;
	private ButtonGroup radioGrp;
	private JRadioButton radioButton1, radioButton2, radioButton3;
	
	
	//Constructor
	public MainComponents() {
		
		setMainWindow();
		setWindowTitle();
		setRadioGrp();
	}

	
	private void setMainWindow(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Components");
		this.setResizable(false);
		this.setSize(400, 300);
		this.panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	private void setWindowTitle(){
	
		lblMainSwingComponents = new JLabel("Main SWING Components");
		lblMainSwingComponents.setBounds(102, 11, 190, 19);
		lblMainSwingComponents.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblMainSwingComponents);
	}
	
	
	private void setRadioTitle(){
		
		JLabel lblRadioGroup = new JLabel("Radio group:");
		lblRadioGroup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRadioGroup.setBounds(26, 66, 75, 20);
		panel.add(lblRadioGroup);
	}
	
	
	private void setRadioGrp(){
		
		setRadioTitle();

		radioButton1 = new JRadioButton("Thursday");
		radioButton1.setBounds(26, 99, 109, 23);
		panel.add(radioButton1);
		
		radioButton2 = new JRadioButton("Friday");
		radioButton2.setBounds(26, 125, 109, 23);
		panel.add(radioButton2);
		
		radioButton3 = new JRadioButton("Saturday");
		radioButton3.setBounds(26, 151, 109, 23);
		panel.add(radioButton3);
		
		radioGrp = new ButtonGroup();
		radioGrp.add(radioButton1);
		radioGrp.add(radioButton2);
		radioGrp.add(radioButton3);
	}
	
	
	//END
}
