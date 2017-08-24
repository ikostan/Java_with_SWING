import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSlider;


public class MainComponents extends JFrame{
	
	private JPanel panel;
	private JLabel lblMainSwingComponents, lblRadioGroups, lblUserId, lblPswd;
	private ButtonGroup radioGrp;
	private JRadioButton radioThue, radioFri, radioSat;
	private JCheckBox chckbxRed, chckbxGreen, chckbxBlue;
	private JLabel lblColorChoices, lblSlider;
	private JTextField textID, textPWD;
	private JButton btnSubmit;
	private JSlider slider;
	
	
	//Constructor
	public MainComponents() {
		
		setMainWindow();
		setWindowTitle();
		setRadioGrp();
		setColorChoices();
		setUserID();
		setUserPswd();
		setSliderObj();
		setSubmitBtn();
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}

	
	private void setMainWindow(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Components");
		this.setResizable(false);
		this.setSize(400, 370);
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel, BorderLayout.CENTER);
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

		radioThue = new JRadioButton("Thursday");
		radioThue.setBounds(26, 99, 109, 23);
		panel.add(radioThue);
		
		radioFri = new JRadioButton("Friday");
		radioFri.setBounds(26, 125, 109, 23);
		panel.add(radioFri);
		
		radioSat = new JRadioButton("Saturday");
		radioSat.setBounds(26, 151, 109, 23);
		panel.add(radioSat);
		
		radioGrp = new ButtonGroup();
		radioGrp.add(radioThue);
		radioGrp.add(radioFri);
		radioGrp.add(radioSat);
	}
	
	
	private void setColorChoices(){
		
		lblColorChoices = new JLabel("Color Choices:");
		lblColorChoices.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorChoices.setBounds(228, 66, 89, 20);
		panel.add(lblColorChoices);
		
		chckbxRed = new JCheckBox("Red");
		chckbxRed.setBounds(220, 99, 97, 23);
		panel.add(chckbxRed);
		
		chckbxGreen = new JCheckBox("Green");
		chckbxGreen.setBounds(220, 125, 97, 23);
		panel.add(chckbxGreen);
		
		chckbxBlue = new JCheckBox("Blue");
		chckbxBlue.setBounds(220, 151, 97, 23);
		panel.add(chckbxBlue);
	}
	
	
	private void setUserID(){
		
		lblUserId = new JLabel("User ID:");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(230, 202, 46, 14);
		panel.add(lblUserId);
		
		textID = new JTextField();
		textID.setBounds(286, 199, 86, 20);
		panel.add(textID);
		textID.setColumns(10);
	}
	
	
	private void setUserPswd(){
		
		lblPswd = new JLabel("Password:");
		lblPswd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPswd.setBounds(212, 233, 64, 14);
		panel.add(lblPswd);
		
		textPWD = new JTextField();
		textPWD.setBounds(286, 230, 86, 20);
		panel.add(textPWD);
		textPWD.setColumns(10);
	}
	
	
	private void setSliderObj(){
		
		lblSlider = new JLabel("Slider:");
		lblSlider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSlider.setBounds(27, 198, 46, 20);
		panel.add(lblSlider);
		
		slider = new JSlider();
		slider.setBounds(10, 224, 200, 26);
		panel.add(slider);		
	}	
	
	
	private void setSubmitBtn(){
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(26, 295, 89, 23);
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
						
		});
		panel.add(btnSubmit);
	}
	
	
	//END
}
