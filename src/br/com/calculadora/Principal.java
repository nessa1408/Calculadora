package br.com.calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.math.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txv1;
	private JTextField txv2;
	private JTextField txresultado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("CALCULADORA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox <String> comboBox = new JComboBox<String>();
		preenchercombobox(comboBox);
		comboBox.setBounds(173, 25, 229, 30);
		contentPane.add(comboBox);
		
		txv1 = new JTextField();
		txv1.setBounds(173, 80, 229, 30);
		contentPane.add(txv1);
		txv1.setColumns(10);
		
		txv2 = new JTextField();
		txv2.setBounds(173, 126, 229, 30);
		contentPane.add(txv2);
		txv2.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex()==1) {
					txresultado.setText("%.2f" + String.valueOf(Somar(txv1.getText(),txv2.getText())));
					
				}else 
					if (comboBox.getSelectedIndex()==2) {
					txresultado.setText(String.valueOf(Subtrair(txv1.getText(),txv2.getText())));
				}else 
					if (comboBox.getSelectedIndex()==3) {
					txresultado.setText(String.valueOf(Multiplicar(txv1.getText(),txv2.getText())));
				}else 
					if (comboBox.getSelectedIndex()==4) {
					txresultado.setText(String.valueOf(Dividir(txv1.getText(),txv2.getText())));
				}else {
					txresultado.setText(null);
				}
		}});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(301, 170, 101, 30);
		contentPane.add(btnNewButton);
		
		txresultado = new JTextField();
		txresultado.setBounds(289, 215, 113, 30);
		contentPane.add(txresultado);
		txresultado.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Operação:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(101, 24, 78, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor 1");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(117, 80, 62, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor 2");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(117, 124, 62, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Resultado");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(219, 215, 78, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Apagar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txresultado.setText(null);
				txv1.setText(null);
				txv2.setText(null);
			}
		});
		btnNewButton_1.setBounds(170, 170, 85, 30);
		contentPane.add(btnNewButton_1);
	}
	
	public static void preenchercombobox(JComboBox combo) {
		combo.addItem("");
		combo.addItem("Somar");
		combo.addItem("Subtrair");
		combo.addItem("Multiplcar");
		combo.addItem("Dividir");
		
	}
	
	public static double Somar(String v1, String v2) {
		return (Double.parseDouble(v1)+ Double.parseDouble(v2));
	}
	public static double Subtrair(String v1, String v2) {
		return (Double.parseDouble(v1) - Double.parseDouble(v2));
	}
	public static double Multiplicar(String v1, String v2) {
		return (Double.parseDouble(v1) * Double.parseDouble(v2));
	}
	public static double Dividir(String v1, String v2) {
		return (Double.parseDouble(v1) / Double.parseDouble(v2));
	}
}
