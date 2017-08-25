import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JScrollPane;

public class MenuExample extends JFrame{

	private final String TAG = MenuExample.class.getName();

	JMenuBar menuBar;
	JMenu menu1, menu2;
	JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	JTextPane textPane;
	private JScrollPane scrollPane;
	
	public MenuExample(){
		
		System.out.println(TAG + " class called");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TAG);
		this.setSize(470, 270);
		this.setResizable(false);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		setMenuBar();
		setTextArea();
		
		this.setVisible(true);
	}
	
	private void setTextArea(){
		
		textPane = new JTextPane();
		scrollPane = new JScrollPane(textPane);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	
	private void setMenuBar(){
		
		menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		setMenu1();
		setMenu2();
	}
	
	
	private void setMenu1(){
		
		menu1 = new JMenu("File");
		menuBar.add(menu1);
		
		menuItem1 = new JMenuItem("New menu item");
		menu1.add(menuItem1);
		
		menuItem2 = new JMenuItem("New menu item");
		menu1.add(menuItem2);
	}
	
	
	private void setMenu2(){
		
		menu2 = new JMenu("Edit");
		menuBar.add(menu2);
		
		menuItem3 = new JMenuItem("New menu item");
		menu2.add(menuItem3);
		
		menuItem4 = new JMenuItem("New menu item");
		menu2.add(menuItem4);
	}
	
	
}
