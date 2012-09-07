

import java.awt.*; //importerar Graphics, Font, Color
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
	Font f;

	// f�rger, se sid 43 i boken
	// grafiska metoder, sid 248 i boken
	public void paintComponent(Graphics g) { // f�r att vara s�ker p� att
												// "super"-klassen g�r sitt
												// anropar vi den metoden, innan
												// vi skriver eller ritar
		super.paintComponent(g);
		g.drawLine(185, 10, 195, 40); // x1,y1 till x2,y2
		g.drawLine(200, 10, 200, 40);
		g.drawLine(215, 10, 205, 40);
		g.setColor(Color.white);
		g.fillOval(50, 30, 300, 150); // x,y,b,h (x,y f�r � v h)
		g.setColor(Color.red);
		g.drawArc(100, 100, 200, 50, 180, 180); // x,y,b,h,s,l
		g.setColor(Color.yellow);
		g.fillRect(200, 100, 30, 30);
		g.fill3DRect(150, 50, 30, 50, true); // true upph�jd figur
		g.fill3DRect(250, 50, 30, 50, true);
		// skriv ut en textstr�ng, samt ange l�get i avst�ndet fr�n
		// �vre v�nstra h�rnet i x-led �t h�ger och i y-led ner�t
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
		setTitle("Mitt LEK f�nster");
		setSize(400, 300); // (bredd,h�jd)
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
