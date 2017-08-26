import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Desktop;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Main extends JFrame{
	

	private final String TAG = Main.class.getName();
	
	private JComboBox combo;
	private DefaultComboBoxModel comboModel;
	private String[] names;
	private String[] descriptions;
	private JTextPane paneDescription;
	private JButton btnRun;
	
	private static Path currentRelativePath;
	private static String rootFolder;
	private JScrollPane scrollPane;

	
	//Main method
	public static void main(String[] args) {
		
		Main test = new Main();
	}
	
	
	//Constructor
	public Main() {
		
		System.out.println(TAG + " class called");
		
		this.setTitle(TAG);
		this.setSize(250, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentRelativePath = Paths.get(""); //relative path
		rootFolder = currentRelativePath.toAbsolutePath().toString(); //absolute path
				
		setFilesName();
		setSpinner();	
		setDescription();
		setRunBtn();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	private void setSpinner(){
				
		comboModel= new DefaultComboBoxModel(names);		
		combo = new JComboBox(comboModel);
		combo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				paneDescription.setText(descriptions[combo.getSelectedIndex()]);
			}			
			
		});
		getContentPane().add(combo, BorderLayout.NORTH);		
	}
	
	
	private void setDescription(){
				
		paneDescription = new JTextPane();
		paneDescription.setText(descriptions[combo.getSelectedIndex()]);
		
		scrollPane = new JScrollPane(paneDescription);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	
	private void setRunBtn(){
		
		btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String fileName = combo.getSelectedItem().toString();
					openFile(fileName);

				}
				catch (Exception ex){
					
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		getContentPane().add(btnRun, BorderLayout.SOUTH);
	}
	
	
	//Opens jar file
	private static void openFile(String fileName){
		
		//Folder name with jar files
		String jarFolder = rootFolder + "\\src\\executable\\";

		try{
			//Open the file
			Desktop.getDesktop().open(new File(jarFolder + fileName));
		} 
		catch (IOException ex) {
			//Error
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception ex) {
			//Error
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}			
	}
	
	
	private void setFilesName(){
		
		names = new String[]{"FirstRun.jar", 
						"Lists.jar", 
						"ListDemo.jar",
						"MenuExample.jar", 
						"BoxLayoutExample.jar", 
						"MainComponents.jar",
						"ItemListenerExample.jar",
						"EventExample.jar",
						"FinalProject.jar"};
		
		descriptions = new String[]{"FirstRun.java class: buttons, lables, title.",
									"Lists.java: lists.", 
									"ListDemo.java: aditional list example.",
									"MenuExample.java: menu examples.", 
									"BoxLayoutExample.java: different layouts presentation.", 
									"MainComponents.java: main GUI components presentation.",
									"ItemListenerExample.java: ItemListener with multiple source items implementation.",
									"EventExample.java: EventListener example",
									"FinalProject.class: Final Project"};
	}
	

	//END
}
