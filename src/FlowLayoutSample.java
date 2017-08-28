import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutSample extends JFrame{

	
	private FlowLayout layout;
	private Container container;
	private JButton btnLeft, btnCenter, btnTraling, btnRight, btnLeading;
	private final String TITLE = "FlowLayoutSample";
	
	
	public static void main(String[] args) {

		FlowLayoutSample test = new FlowLayoutSample(); 
	}

	
	public FlowLayoutSample(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
		this.setSize(450, 150);

		
		layout = new FlowLayout();
	
		setBtnLeft();
		setBtnCenter();
		setBtnTraling();
		setBtnLeading();
		setBtnRight();	
		
		layout.setVgap(this.getHeight() / 2 - 40);
		container = this.getContentPane();
		
		this.setLayout(layout);
		this.setVisible(true);
	}
	
	
	private void setBtnLeading() {
		
		btnLeading = new JButton("Leading");
		btnLeading.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				layout.setAlignment(FlowLayout.CENTER);
				layout.layoutContainer(container);
			}
		});
		
		this.add(btnLeading);	
	}


	private void setBtnCenter(){
		
		btnCenter = new JButton("Center");
		btnCenter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				layout.setAlignment(FlowLayout.CENTER);
				layout.layoutContainer(container);
			}
		});
		
		this.add(btnCenter);				
	}
	
	
	private void setBtnLeft(){
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				layout.setAlignment(FlowLayout.LEFT);
				layout.layoutContainer(container);
			}
		});
		
		this.add(btnLeft);				
	}
	
	
	private void setBtnTraling(){
		
		btnTraling = new JButton("Traling");
		btnTraling.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				layout.setAlignment(FlowLayout.TRAILING);
				layout.layoutContainer(container);
			}
		});
	
		this.add(btnTraling);				
	}

	
	private void setBtnRight(){
	
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			layout.setAlignment(FlowLayout.RIGHT);
			layout.layoutContainer(container);
		}
	});
	
	this.add(btnRight);				
}
	
	
	//END
}
