import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;


public class BoxLayoutExample extends JFrame {
	
	private final String TAG = BoxLayoutExample.class.getName();
	JPanel panelBorder, panelCard , panelBox, cards;
	
	
	static public void main(String args[]){
		
		BoxLayoutExample test =  new BoxLayoutExample();
	}
	
	
	//Constructor
	public BoxLayoutExample(){
		
		System.out.println(TAG + " class called");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setTitle(TAG);
		this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		setBorderLayout();
		setCardLayout();
		setBoxLayout();		
		
		this.getContentPane().add(panelBorder);	
		this.getContentPane().add(panelCard);
		this.getContentPane().add(panelBox);
		this.setVisible(true);

		this.pack();
		
	}
	
	
	private void setBorderLayout(){
		
		BorderLayout bLayout = new BorderLayout(4, 4);
		
		panelBorder = new JPanel();
		panelBorder.setBackground(Color.WHITE);
		panelBorder.setLayout(bLayout);
		panelBorder.setBorder(BorderFactory.createTitledBorder("Border Layout Example"));
				
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.YELLOW);
		panelBorder.add(panelNorth, bLayout.NORTH);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.BLUE);
		panelBorder.add(panelSouth, bLayout.SOUTH);
			
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.RED);
		panelBorder.add(panelCenter, bLayout.CENTER);
		panelCenter.setVisible(true);
			
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.BLACK);
		panelBorder.add(panelWest, bLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.GREEN);
		panelBorder.add(panelEast, bLayout.EAST);
		
		panelBorder.revalidate();
		panelBorder.repaint();
	}
	
	
	private void setCardLayout(){
		
		panelCard = new JPanel();
		panelCard.setBackground(Color.WHITE);
		panelCard.setBorder(BorderFactory.createTitledBorder("Card Layout Example"));
		
		JPanel card1 =new JPanel();
        card1.add(new JLabel("Label 1"));
        card1.add(new JLabel("Label 2"));
        card1.add(new JLabel("Label 3"));
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField 1", 20));
        card2.add(new JTextField("TextField 2", 20));
        card2.add(new JTextField("TextField 3", 20));

        cards = new JPanel(new CardLayout());
        cards.add(card1, "Show Labels") ; 
        cards.add(card2, "Show Text Fields");   
		
		CardLayout cl = (CardLayout)(cards.getLayout());
		
		
		JPanel combo = new JPanel();
		String[] str = new String[]{"Show Labels", "Show Text Fields"};
		JComboBox comboBox = new JComboBox(str);
		comboBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				
				if(comboBox.getSelectedItem().toString().equals("Show Labels")){
					
					cl.show(cards, "Show Labels");
				}
				else{

					cl.show(cards, "Show Text Fields");
				}
			}
					
		});
		FlowLayout fl_panelCard = new FlowLayout(FlowLayout.LEADING, 5, 5);
		panelCard.setLayout(fl_panelCard);
		combo.add(comboBox);	
		
	        
	    panelCard.add(combo);
		panelCard.add(cards);
	}
	
	
	private void setBoxLayout(){
		
		panelBox = new JPanel();
		//panelBox.setSize(600, 50);
		panelBox.setBackground(Color.CYAN);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.X_AXIS));
		panelBox.setBorder(BorderFactory.createTitledBorder("Box Layout Example"));

		
		JButton btnNewButton = new JButton("New button");
		panelBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelBox.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panelBox.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panelBox.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panelBox.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panelBox.add(btnNewButton_5);
	}
	

}
