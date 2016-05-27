/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrazyBall;

/**
 *
 * @author Pavel Kovalev
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CrazyBall extends JPanel {

	Ball ball = new Ball(this);
	Plate racquet = new Plate(this);
	int speed = 1;
         
	private int getScore() {
		return speed - 1;
	}

	public CrazyBall() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);

	}

	private void movehere() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
                super.setBackground(Color.black);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
                g2d.setColor(Color.white);
 
		g2d.setFont(new Font("Arial", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()),this.getWidth()-40, 30);
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
        
     

	public static void main(String[] args) throws InterruptedException {
                
                Thread.sleep(2000);
		JFrame mainFrame = new JFrame("Crazy Ball by Pavel Kovalev");
		CrazyBall game = new CrazyBall();
		mainFrame.add(game);
                mainFrame.pack();
		mainFrame.setSize(300, 400);
                mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
                mainFrame.setResizable(false);
                mainFrame.setBackground(Color.black);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   JOptionPane.showMessageDialog(mainFrame, "Press ok to start game");
                   game.repaint();
		while (true) {
                        
                       
			game.movehere();
			game.repaint();
                        Thread.sleep(10);
                        
		}
	}
}