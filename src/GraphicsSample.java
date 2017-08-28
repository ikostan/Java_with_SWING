import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsSample extends JPanel {

	
	static String TAG = GraphicsSample.class.getSimpleName();
	int width = 400;
	int height = 400;

	
	public static void main(String[] args){
		
		GraphicsSample test = new GraphicsSample();
		
		JFrame frame = new JFrame();
		frame.setTitle(TAG);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.add(test);
		frame.setVisible(true);
	}
	
	
	//Paint method
	public void paintComponent(Graphics g){
		
		super.paintComponents(g);
		this.setBackground(Color.WHITE);	

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, width/4, height/4);
		
		g.setColor(new Color(190, 81, 215));
		g.fillRect(width/2, height/2, width/2, height/4);
		
		g.setColor(Color.RED);
		g.drawString("text text text", 65, 160);
	}

	
	//END
}
