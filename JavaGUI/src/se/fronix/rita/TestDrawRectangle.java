package se.fronix.rita;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel implements ActionListener {
	// Till vår panel måste vi koppla en händelselyssnare,därav"implements
	// ActionListener" ovan.
	// Vi måste deklarera våra knappar
	JButton redButton;
	JButton yellowButton;
	JButton greenButton;
	// deklarera globala variabler
	int x = 100, y = 200, w = 20, h = 100;
	Color color = getBackground();

	// Vi måste skapa en egen konstruktor för vår panel, som ju körs endast
	// när vi skapar ett objekt av denna klass. Vi vill ju att när vi skapar
	// panelen ska också knappar skapas automatiskt.
	public MyPanel() {
JLabel etikett = new JLabel("Rita en rektangel genom att trycka på knapparna");
//Skapa knapparna
redButton = new JButton("Röd liten");
yellowButton = new JButton("Gul mellan");
greenButton = new JButton("Grön stor");
//lägg till dom till det här panelobjektet
add(redButton);
add(yellowButton);
add(greenButton);
//koppla på panelens händelselyssnare
redButton.addActionListener(this);
yellowButton.addActionListener(this);
greenButton.addActionListener(this);
}

	// Ifall något händer dvs vi klickar på någon av knapparna, så går ett
	// meddelande till till vår ActionListener. OM detta inträffar så måste
	// vi ju ta hand om detta och göra något. Vi skriver en metod för det.
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource(); // hämta händelsekälla
		// Testa vilken av knapparna vi tryckte på och
		// ge variabeln color en färg och rektangelbredden ett värde
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
		// för att vara säker på att "super"-klassen gör sitt
		// anropar vi den metoden, innan vi skriver eller ritar
		super.paintComponent(g);
		// skriv ut en textsträng, samt ange läget i avståndet från
		// övre vänstra hörnet i x-led åt höger och i y-led neråt
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
		setSize(screenWidth / 2, screenHeight / 2); // (bredd,höjd)
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