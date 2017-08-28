import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class ColorPicker extends JFrame{

	
	private final String TAG = ColorPicker.class.getSimpleName();
	
	private JButton btnClr;
	private Color color;
	private JPanel panel, panelClr;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	
	//Main method
	public static void main(String[] args) {

		ColorPicker test = new ColorPicker();
	}
	
	
	//Constructor
	public ColorPicker(){
		
		System.out.println(TAG + " class called");
	
		setPanel();
		
		panelClr = new JPanel();
		panel.add(panelClr);
		
		setLogPanel();
		setClrBtn();
		
		this.setTitle(TAG);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	
	private void setPanel(){
		
		color = Color.WHITE;
		
		panel = new JPanel();
		panel.setBackground(color);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.getContentPane().add(panel, BorderLayout.CENTER);	
	}
	
	
	private void setLogPanel(){
		
		textArea = new JTextArea();		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
	}
	
	
	private void setClrBtn(){
		
		btnClr = new JButton("Choose a color");
		btnClr.setAlignmentX(0.5f);
		btnClr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//position, title, color
				color = JColorChooser.showDialog(null, "Pick your color", color);
				
				if(color != null){
					
					textArea.append("\n" + color.toString());				
					panelClr.setBackground(color);
					panelClr.repaint();
				}
				else{
					
					textArea.append("\n" + "No color selected");				
				}
			}
		});
		
		this.getContentPane().add(btnClr, BorderLayout.SOUTH);
	}
	
	//END
}
