import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventExample extends JFrame implements ActionListener{

	private final String TAG = EventExample.class.getName();

	private final int SIZE = 90;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	
	//Main method
	public static void main(String[] args) {

		EventExample test = new EventExample();
	}

	
	//Constructor
	public EventExample(){
		
		System.out.println(TAG + " class called");

		setGUI();
		setButtons();
				
		this.setVisible(true);
	}
	

	private void setButtons() {
		
		btn1 = new JButton("1");
		btn1.setBackground(new Color(211, 211, 211));
		btn1.addActionListener(this);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn1.setBounds(10, 11, SIZE, SIZE);
		getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(new Color(211, 211, 211));
		btn2.addActionListener(this);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn2.setBounds(110, 11, SIZE, SIZE);
		getContentPane().add(btn2);		
		
		btn3 = new JButton("3");
		btn3.setBackground(new Color(211, 211, 211));
		btn3.addActionListener(this);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn3.setBounds(210, 11, SIZE, SIZE);
		getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBackground(new Color(211, 211, 211));
		btn4.addActionListener(this);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn4.setBounds(10, 112, SIZE, SIZE);
		getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(new Color(211, 211, 211));
		btn5.addActionListener(this);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn5.setBounds(110, 112, SIZE, SIZE);
		getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(new Color(211, 211, 211));
		btn6.addActionListener(this);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn6.setBounds(210, 112, SIZE, SIZE);
		getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBackground(new Color(211, 211, 211));
		btn7.addActionListener(this);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn7.setBounds(10, 213, SIZE, SIZE);
		getContentPane().add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(new Color(211, 211, 211));
		btn8.addActionListener(this);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn8.setBounds(110, 213, SIZE, SIZE);
		getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(new Color(211, 211, 211));
		btn9.addActionListener(this);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn9.setBounds(210, 213, SIZE, SIZE);
		getContentPane().add(btn9);		
	}


	private void setGUI(){
		
		this.getContentPane().setLayout(null);
		this.setTitle(TAG);
		this.setSize(317, 342);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	
	//Returns color
	private Color returnColor(String num){
		
		Color clr = null;
		int caseNumber = Integer.parseInt(num);
		System.out.println("caseNumber: " + caseNumber);
		
		switch(caseNumber){
		
		case 1:
			clr = Color.BLUE;
			break;
		case 2:
			clr = Color.CYAN;
			break;
		case 3:
			clr = Color.RED;
			break;
		case 4:
			clr = Color.GREEN;
			break;
		case 5:
			clr = Color.ORANGE;
			break;
		case 6:
			clr = Color.PINK;
			break;
		case 7:
			clr = Color.YELLOW;
			break;
		case 8:
			clr = Color.WHITE;
			break;
		case 9:
			clr = Color.GRAY;
			break;
		default:	
			clr = Color.BLACK;
			break;
		}
		
		return clr;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object srcObj = arg0.getSource();
		System.out.println("Button clicked");
		
		if(srcObj == btn1){
			
			setBtnBgClr(btn1);
		}
		else if(srcObj == btn2){
			
			setBtnBgClr(btn2);
		}
		else if(srcObj == btn3){
				
			setBtnBgClr(btn3);
		}
		else if(srcObj == btn4){
					
			setBtnBgClr(btn4);
		}
		else if(srcObj == btn5){
				
			setBtnBgClr(btn5);
		}
		else if(srcObj == btn6){
				
			setBtnBgClr(btn6);
		}
		else if(srcObj == btn7){
					
			setBtnBgClr(btn7);
		}
		else if(srcObj == btn8){
		
			setBtnBgClr(btn8);
		}
		else if(srcObj == btn9){
				
			setBtnBgClr(btn9);
		}
		
	}
	
	
	private void setBtnBgClr(JButton btn){
		
		Color defaultClr = new Color(211, 211, 211);
		
		if(btn.getBackground().toString().equals(defaultClr.toString())){
			
			btn.setBackground(returnColor(btn.getText()));
			System.out.println("Settinga new background");
		}
		else{
			
			btn.setBackground(defaultClr);
			System.out.println("Setting back default background");
		}	
	}
	
	
	//END
}
