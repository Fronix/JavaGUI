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

class TextInWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	JButton graph;
	private static final long serialVersionUID = 1L;

	public TextInWindow() {
		this.setLayout(null);
		graph = new JButton("Rita Graf");
		add(graph);
		graph.addActionListener(this);
		
		setTitle("text i vårt fönster + 3 knappar");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(screenWidth / 2, screenHeight / 2); // (bredd,höjd)
		setLocation(screenWidth / 4, screenHeight / 4);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if(source != graph){
			MyPanel p = new MyPanel();
			Container contentPane = getContentPane();
			contentPane.add(p);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}else{
			graphPanel g = new graphPanel();
			Container contentPane = getContentPane();
			contentPane.add(g);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}

class MyPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		 * Stäng av layoutmanager'n, dvs ingen automatisk utplacering av
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
		add(graphPanel);
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
		/* Hämta texten från ruta1 och 2 och gör om dessa till int */
		
		if(source == rensa) {
			resultat.setText("");
			ruta1.setText("");
			ruta2.setText("");
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

	class graphPanel extends JPanel implements ActionListener {

		
		JLabel testText;
		
		public graphPanel(){
			this.setLayout(null);
			
			testText = new JLabel("En test text till grafen.");
			add(testText);
			testText.setBounds(30, 300, 100, 30);
		}
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			testText.setText("TEST");
		 repaint();
		}
		
		public void paintComponent(Graphics g){
			super.paintChildren(g);
		}
		
	}
