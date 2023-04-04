
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTextField polinom1;
    private JTextField polinom2;

    private Polynomial poly1;
    private Polynomial poly2;
    
    public MainFrame() {
        setFont(new Font("Dubai Medium", Font.BOLD, 14));
        setBackground(new Color(224, 255, 255));
        setForeground(new Color(224, 255, 255));
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 224));
        contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(85, 107, 47)));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        polinom1 = new JTextField();
        polinom1.setBackground(new Color(255, 250, 250));
        polinom1.setFont(new Font("Tahoma", Font.ITALIC, 12));
        polinom1.setHorizontalAlignment(SwingConstants.LEFT);
        polinom1.setBounds(10, 11, 300, 35);
        contentPane.add(polinom1);
        polinom1.setColumns(10);

        polinom2 = new JTextField();
        polinom2.setBackground(new Color(255, 250, 250));
        polinom2.setFont(new Font("Tahoma", Font.ITALIC, 12));
        polinom2.setHorizontalAlignment(SwingConstants.LEFT);
        polinom2.setColumns(10);
        polinom2.setBounds(10, 57, 300, 35);
        contentPane.add(polinom2);

        JLabel lblNewLabel = new JLabel("The 1st Polynomial");
        lblNewLabel.setForeground(new Color(106, 90, 205));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblNewLabel.setBounds(320, 11, 146, 35);
        contentPane.add(lblNewLabel);

        JLabel lblThendPolynom = new JLabel("The 2nd Polynomial");
        lblThendPolynom.setForeground(new Color(106, 90, 205));
        lblThendPolynom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblThendPolynom.setBounds(320, 57, 146, 35);
        contentPane.add(lblThendPolynom);

        JButton sub = new JButton("SUB");
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        sub.setBackground(new Color(240, 255, 255));
        sub.setForeground(new Color(184, 134, 11));
        sub.setFont(new Font("Tahoma", Font.BOLD, 12));
        sub.setBounds(404, 103, 120, 30);
        contentPane.add(sub);

        JButton sum = new JButton("SUM");
        sum.setForeground(new Color(184, 134, 11));
        sum.setFont(new Font("Tahoma", Font.BOLD, 12));
        sum.setBackground(new Color(240, 255, 255));
        sum.setBounds(284, 103, 120, 30);
        contentPane.add(sum);

        JButton divide = new JButton("DIVIDE");
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        divide.setForeground(new Color(184, 134, 11));
        divide.setFont(new Font("Tahoma", Font.BOLD, 12));
        divide.setBackground(new Color(240, 255, 255));
        divide.setBounds(284, 133, 120, 30);
        contentPane.add(divide);

        JButton multiply = new JButton("MULTIPLY");
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        multiply.setForeground(new Color(184, 134, 11));
        multiply.setFont(new Font("Tahoma", Font.BOLD, 12));
        multiply.setBackground(new Color(240, 255, 255));
        multiply.setBounds(404, 133, 120, 30);
        contentPane.add(multiply);

        JButton derive = new JButton("DERVIATION");
        derive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        derive.setForeground(new Color(184, 134, 11));
        derive.setFont(new Font("Tahoma", Font.BOLD, 12));
        derive.setBackground(new Color(240, 255, 255));
        derive.setBounds(284, 162, 120, 30);
        contentPane.add(derive);

        JButton integrate = new JButton("INTEGRATION");
        integrate.setForeground(new Color(184, 134, 11));
        integrate.setFont(new Font("Tahoma", Font.BOLD, 12));
        integrate.setBackground(new Color(240, 255, 255));
        integrate.setBounds(404, 162, 120, 30);
        contentPane.add(integrate);

        JTextArea resultBox = new JTextArea();
        resultBox.setBackground(new Color(248, 248, 255));
        resultBox.setFont(new Font("Calibri", Font.BOLD, 14));
        resultBox.setForeground(new Color(0, 0, 0));
        resultBox.setBounds(10, 203, 300, 70);
        contentPane.add(resultBox);

        JLabel lblTheResult = new JLabel("The Result!\r\n");
        lblTheResult.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTheResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblTheResult.setForeground(new Color(34, 139, 34));
        lblTheResult.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lblTheResult.setBounds(91, 162, 104, 38);
        contentPane.add(lblTheResult);

        JButton btnNewButton_2 = new JButton("CLEAR");
        btnNewButton_2.setBackground(new Color(128, 0, 128));
        btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 14));
        btnNewButton_2.setForeground(new Color(199, 21, 133));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	polinom1.setText("");
            	polinom2.setText("");
            	resultBox.setText("");
            }
        });
        btnNewButton_2.setBounds(352, 221, 89, 35);
        contentPane.add(btnNewButton_2);

        sub.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
             	Operations op = new Operations();
             	Polynomial poly1 = new Polynomial();
             	Polynomial poly2 = new Polynomial();
             	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
             	poly2.setPolynomial(op.parsePolynomial(polinom2.getText()));
                 if (poly1 != null && poly2 != null) {
                     Polynomial result = op.substract(poly1, poly2);
                    resultBox.setText(result.toString());
                 } 
             }
         });

        sum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Operations op = new Operations();
            	Polynomial poly1 = new Polynomial();
            	Polynomial poly2 = new Polynomial();
            	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
            	poly2.setPolynomial(op.parsePolynomial(polinom2.getText()));
                if (poly1 != null && poly2 != null) {
                    Polynomial result = op.add(poly1, poly2);
                   resultBox.setText(result.toString());
                } 
            }
        });

        multiply.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
              	Operations op = new Operations();
              	Polynomial poly1 = new Polynomial();
              	Polynomial poly2 = new Polynomial();
              	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
              	poly2.setPolynomial(op.parsePolynomial(polinom2.getText()));
                  if (poly1 != null && poly2 != null) {
                      Polynomial result = op.multiply(poly1, poly2);
                     resultBox.setText(result.toString());
                  } 
              }
          });


        divide.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
              	Operations op = new Operations();
              	Polynomial poly1 = new Polynomial();
              	Polynomial poly2 = new Polynomial();
              	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
              	poly2.setPolynomial(op.parsePolynomial(polinom2.getText()));
                  if (poly1 != null && poly2 != null) {
                      Polynomial result = op.divide(poly1, poly2);
                     resultBox.setText(result.toString());
                  } 
              }
          });


        derive.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
              	Operations op = new Operations();
              	Polynomial poly1 = new Polynomial();
              	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
                  if (poly1 != null) {
                      Polynomial result = op.derivative(poly1);
                     resultBox.setText(result.toString());
                  } 
              }
          });


        integrate.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
               	Operations op = new Operations();
               	Polynomial poly1 = new Polynomial();
               	poly1.setPolynomial(op.parsePolynomial(polinom1.getText()));
                   if (poly1 != null) {
                       Polynomial result = op.integrate(poly1);
                      resultBox.setText(result.toString()+ " + C");
                   } 
               }
           });

    }
}
