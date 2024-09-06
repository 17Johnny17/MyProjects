import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame implements ActionListener{
	GamePanel game;
	JButton button;
	
	//CREATE A BUTTON METHOD
	public Component button() {
		game.setLayout(null);
		button = new JButton("Restart");
		button.addActionListener(this);
		//button.setSize(new Dimension(250,400));
		button.setBounds(500, 0, 500 / 5, 100 / 5);
		return button;
	}
	
	GameFrame(){
		game = new GamePanel();
		game.setLayout(null);
		//button = new JButton("Reset");
		//button.addActionListener(this);
		//button.setSize(new Dimension(250,400));
		//button.setLayout(null);
		//button.setBounds(500, 180, 500 / 5, 500 / 5);
		this.setTitle("My Cool Snake Game!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		game.add(button());
		
		//button.setVisible(true);
		this.add(game);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.getRunning() == false) {
			if(e.getSource() == button) {
				this.remove(game);
				game = new GamePanel();
				this.add(game);
				game.add(button());
				game.requestFocusInWindow();
				SwingUtilities.updateComponentTreeUI(this);
			}
		}
	}
	
	
}
