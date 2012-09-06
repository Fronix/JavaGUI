package se.fronix.calculator;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;

public class Calc {
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		JFrame myWindow = new TextInWindow();
	}
}

class TextInWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextInWindow() {
		setTitle("text i vårt fönster + 3 knappar");
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

class MyPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NumberFormat nf = NumberFormat.getInstance();
	JButton buttonAddition;
	JButton buttonSubtraktion;
	JButton buttonMultiplikation;
	JButton buttonDivision;
	JButton rensa;
	
	JLabel resultat;
	JLabel header;
	JLabel ruta1Label;
	JLabel ruta2Label;
	JLabel antaldecLabel;
	
	JTextField antaldec;
	JTextField ruta1;
	JTextField ruta2;


	public MyPanel() {
		/************************************************************
		 * Stäng av layoutmanager'n, dvs ingen automatisk utplacering av
		 * komponenter.
		 ************************************************************/
		this.setLayout(null);

		buttonAddition = new JButton("Addition");
		buttonSubtraktion = new JButton("Subtraktion");
		buttonMultiplikation = new JButton("Multiplikation");
		buttonDivision = new JButton("Division");
		rensa = new JButton("Rensa");
		
		ruta1 = new JTextField(20);
		ruta2 = new JTextField(20);	
		antaldec = new JTextField(10);
		
		ruta1Label = new JLabel("Tal 1");
		ruta2Label = new JLabel("Tal 2");
		antaldecLabel = new JLabel("AntalDec");
		header = new JLabel("Skriv in två tal och välj räknesätt");
		resultat = new JLabel(""); //Den ska endast visa resultat alltså ingeting i början

		add(buttonAddition);
		add(buttonSubtraktion);
		add(buttonMultiplikation);
		add(buttonDivision);
		add(rensa);
		add(ruta1);
		add(ruta2);
		add(ruta1Label);
		add(ruta2Label);
		add(antaldec);
		add(antaldecLabel);
		add(resultat);
		add(header);
		/************************************************************
		 * För varje komponent som vi lägger till måste vi sätta storlek och
		 * placering. x-koordinat, y-koordinat(uppefrån), bredd på komponent,
		 * höjd på komponent.
		 ************************************************************/
		buttonAddition.setBounds(30, 100, 110, 30);
		buttonSubtraktion.setBounds(30, 140, 110, 30);
		buttonMultiplikation.setBounds(30, 180, 110, 30);
		buttonDivision.setBounds(30, 220, 110, 30);
		rensa.setBounds(30, 300, 100, 30);
		
		ruta1.setBounds(200, 140, 120, 20);
		ruta2.setBounds(350, 140, 120, 20);
		antaldec.setBounds(500, 140, 50, 20);
		
		ruta1Label.setBounds(200, 120, 40, 20);
		ruta2Label.setBounds(350, 120, 40, 20);
		antaldecLabel.setBounds(500, 120, 100, 20);
		resultat.setBounds(210, 170, 300, 20);
		header.setBounds(200, 80, 200, 20);

		buttonAddition.addActionListener(this);
		buttonSubtraktion.addActionListener(this);
		buttonMultiplikation.addActionListener(this);
		buttonDivision.addActionListener(this);
		rensa.addActionListener(this);

	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		nf.setMaximumFractionDigits(5);
		/* Hämta texten från ruta1 och 2 och gör om dessa till int */
		
		if (source == rensa) {
			resultat.setText("");
			ruta1.setText("");
			ruta2.setText("");
		}else{
			try {
				//int dec = Integer.parseInt(antaldec.getText());
				double tal1 = Double.parseDouble(ruta1.getText());
				double tal2 = Double.parseDouble(ruta2.getText());
				double summa;

				if (source == buttonAddition) {
					summa = tal1+tal2;
					resultat.setText(nf.format(tal1) + " + " + nf.format(tal2) + " = " + nf.format(summa));
				} else if (source == buttonSubtraktion) {
					summa = tal1-tal2;
					resultat.setText(tal1 + " - " + tal2 + " = "+ summa);
				} else if (source == buttonMultiplikation) {
					summa = tal1*tal2;
					resultat.setText(tal1 + " * " + tal2 + " = "+ summa);
				} else if (source == buttonDivision) {
					if(tal2 == 0){
						resultat.setText("Du kan inte dela med noll!");
					}else{
						summa = tal1/tal2;
						resultat.setText(tal1 + " / " + tal2 + " = "+ summa);
					}
				}
			}
			catch(NumberFormatException nFE) {
			    resultat.setText("Du måste skriva siffror!");
			}
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
