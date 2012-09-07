package se.fronix.rita;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel implements ActionListener {
	// Till v�r panel m�ste vi koppla en h�ndelselyssnare,d�rav"implements
	// ActionListener" ovan.
	// Vi m�ste deklarera v�ra knappar
	JButton redButton;
	JButton yellowButton;
	JButton greenButton;
	// deklarera globala variabler
	int x = 100, y = 200, w = 20, h = 100;
	Color color = getBackground();

	// Vi m�ste skapa en egen konstruktor f�r v�r panel, som ju k�rs endast
	// n�r vi skapar ett objekt av denna klass. Vi vill ju att n�r vi skapar
	// panelen ska ocks� knappar skapas automatiskt.
	public MyPanel() {
JLabel etikett = new JLabel("Rita en rektangel genom att trycka p� knapparna");
//Skapa knapparna
redButton = new JButton("R�d liten");
yellowButton = new JButton("Gul mellan");
greenButton = new JButton("Gr�n stor");
//l�gg till dom till det h�r panelobjektet
add(redButton);
add(yellowButton);
add(greenButton);
//koppla p� panelens h�ndelselyssnare
redButton.addActionListener(this);
yellowButton.addActionListener(this);
greenButton.addActionListener(this);
}

	// Ifall n�got h�nder dvs vi klickar p� n�gon av knapparna, s� g�r ett
	// meddelande till till v�r ActionListener. OM detta intr�ffar s� m�ste
	// vi ju ta hand om detta och g�ra n�got. Vi skriver en metod f�r det.
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource(); // h�mta h�ndelsek�lla
		// Testa vilken av knapparna vi tryckte p� och
		// ge variabeln color en f�rg och rektangelbredden ett v�rde
		if (source == redButton) {
			color = Color.red;
			w = 50;
		} else if (source == yellowButton) {
			color = Color.yellow;
			w = 200;
		} else if (source == greenButton) {
			color = Color.green;
			w = 400;
		}
		repaint(); // rita om aktuell panel
	}

	public void paintComponent(Graphics g) {
		// f�r att vara s�ker p� att "super"-klassen g�r sitt
		// anropar vi den metoden, innan vi skriver eller ritar
		super.paintComponent(g);
		// skriv ut en textstr�ng, samt ange l�get i avst�ndet fr�n
		// �vre v�nstra h�rnet i x-led �t h�ger och i y-led ner�t
		g.setColor(color);
		g.fillRect(x, y, w, h);
	}
}

class TextInWindow extends JFrame {
	public TextInWindow() {
		setTitle("Rita en rektangel");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(screenWidth / 2, screenHeight / 2); // (bredd,h�jd)
		setLocation(screenWidth / 4, screenHeight / 4);
		Container contentPane = getContentPane();
		MyPanel p = new MyPanel();
		contentPane.add(p);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class TestDrawRectangle {
	public static void main(String args[]) {
		JFrame myWindow = new TextInWindow();
	}
}