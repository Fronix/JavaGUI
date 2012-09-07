

import java.awt.*; //importerar Graphics, Font, Color
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
	Font f;

	// färger, se sid 43 i boken
	// grafiska metoder, sid 248 i boken
	public void paintComponent(Graphics g) { // för att vara säker på att
												// "super"-klassen gör sitt
												// anropar vi den metoden, innan
												// vi skriver eller ritar
		super.paintComponent(g);
		g.drawLine(185, 10, 195, 40); // x1,y1 till x2,y2
		g.drawLine(200, 10, 200, 40);
		g.drawLine(215, 10, 205, 40);
		g.setColor(Color.white);
		g.fillOval(50, 30, 300, 150); // x,y,b,h (x,y för ö v h)
		g.setColor(Color.red);
		g.drawArc(100, 100, 200, 50, 180, 180); // x,y,b,h,s,l
		g.setColor(Color.yellow);
		g.fillRect(200, 100, 30, 30);
		g.fill3DRect(150, 50, 30, 50, true); // true upphöjd figur
		g.fill3DRect(250, 50, 30, 50, true);
		// skriv ut en textsträng, samt ange läget i avståndet från
		// övre vänstra hörnet i x-led åt höger och i y-led neråt
		g.drawString("** Tjenare kompis !! **", 20, 20);
		f = new Font("Arial", Font.BOLD, 30);
		setBackground(Color.cyan);
		g.setFont(f);
		g.setColor(new Color(255, 175, 175));
		g.drawString("YEEEEEEEES!!", 100, 250);
	}
}

class GraphicsWindow extends JFrame {
	public GraphicsWindow() { // Konstruktor
		setTitle("Mitt LEK fönster");
		setSize(400, 300); // (bredd,höjd)
		setLocation(200, 200);
		Container contentPane = getContentPane();
		MyPanel p = new MyPanel();
		contentPane.add(p);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class TestGraphicsWindow {
	public static void main(String args[]) {
		GraphicsWindow myWindow = new GraphicsWindow();
	}
}
