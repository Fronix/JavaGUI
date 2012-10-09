package se.fronix.calculator;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.text.NumberFormat;

import javax.swing.*;

import se.fronix.rita.PositiveCartesian;

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
		setTitle("Miniräknare");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		MyPanel p = new MyPanel();
		Container contentPane = getContentPane();
		contentPane.add(p);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(screenWidth / 2, screenHeight / 2); // (bredd,h�jd)
		setLocation(screenWidth / 4, screenHeight / 4);
	}

}

class grafPanel extends JPanel implements ActionListener {
	PositiveCartesian cartesian;
	public grafPanel() {
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
        cartesian = new PositiveCartesian(100, 100);
		cartesian.setNumbersOfCordinateNumbers(5, 5);
		cartesian.setDistanceOfCartesianFromPanel(200, 200);
        cartesian.populateAxisWithAdditionalNumbers(true);
        cartesian.drawCartesian(g);
        
        g2.draw(new Line2D.Double(100, 300, 100, 300));
	}
	
}

class MyPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x1 = 200, y1 = 300, ctrlx = 300, ctrly = 300, x2 = 500, y2 = 300;
	
	JButton buttonAddition;
	JButton buttonSubtraktion;
	JButton buttonMultiplikation;
	JButton buttonDivision;
	JButton rensa;
	JButton graphPanel;
	
	
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
		 * St�ng av layoutmanager'n, dvs ingen automatisk utplacering av
		 * komponenter.
		 ************************************************************/
		this.setLayout(null);

		buttonAddition = new JButton("Addition");
		buttonSubtraktion = new JButton("Subtraktion");
		buttonMultiplikation = new JButton("Multiplikation");
		buttonDivision = new JButton("Division");
		rensa = new JButton("Rensa");
		graphPanel = new JButton("Rita Graf");
		
		ruta1 = new JTextField(20);
		ruta2 = new JTextField(20);	
		antaldec = new JTextField("2");
		
		ruta1Label = new JLabel("Tal 1");
		ruta2Label = new JLabel("Tal 2");
		antaldecLabel = new JLabel("AntalDec");
		header = new JLabel("Skriv in två tal och välj räknesätt");
		resultat = new JLabel(""); //Den ska endast visa resultat allts� ingeting i b�rjan

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
		add(graphPanel);
		/************************************************************
		 * F�r varje komponent som vi l�gger till m�ste vi s�tta storlek och
		 * placering. x-koordinat, y-koordinat(uppefr�n), bredd p� komponent,
		 * h�jd p� komponent.
		 ************************************************************/
		buttonAddition.setBounds(30, 100, 110, 30);
		buttonSubtraktion.setBounds(30, 140, 110, 30);
		buttonMultiplikation.setBounds(30, 180, 110, 30);
		buttonDivision.setBounds(30, 220, 110, 30);
		rensa.setBounds(30, 300, 100, 30);
		graphPanel.setBounds(10, 10, 100, 50);
		
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
		graphPanel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		NumberFormat nf = NumberFormat.getInstance();
		/* H�mta texten fr�n ruta1 och 2 och g�r om dessa till int */
		
		if(source == rensa) {
			resultat.setText("");
			ruta1.setText("");
			ruta2.setText("");
		}else if (source == graphPanel) {
			setVisible(false);
			
			
		}else{
			try {
				//int dec = Integer.parseInt(antaldec.getText());
				double tal1 = Double.parseDouble(ruta1.getText());
				double tal2 = Double.parseDouble(ruta2.getText());
				int dec = Integer.parseInt(antaldec.getText());
				double summa;

				nf.setMaximumFractionDigits(dec);
				
				if (source == buttonAddition) {
					summa = tal1+tal2;
					resultat.setText(nf.format(tal1) + " + " + nf.format(tal2) + " = " + nf.format(summa));
				} else if (source == buttonSubtraktion) {
					summa = tal1-tal2;
					resultat.setText(nf.format(tal1) + " - " + nf.format(tal2) + " = "+ nf.format(summa));
				} else if (source == buttonMultiplikation) {
					summa = tal1*tal2;
					resultat.setText(nf.format(tal1) + " * " + nf.format(tal2) + " = "+ nf.format(summa));
				} else if (source == buttonDivision) {
					if(tal2 == 0){
						resultat.setText("Du kan inte dela med noll!");
					}else{
						summa = tal1/tal2;
						resultat.setText(nf.format(tal1) + " / " + nf.format(tal2) + " = "+ nf.format(summa));
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
