package JavaProject;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.text.LabelView;
import javax.xml.transform.Result;

import java.awt.*;
import java.awt.event.*;

class Myframe extends JFrame implements ActionListener {
    private Container c;
    private JLabel label1, label2, Result;
    private JTextField t1, t2, Re;
    private JButton add, minus, div, mul;

    Myframe() {
        setTitle("Simple Calculator");
        setSize(500, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("first Element :");
        label1.setBounds(10, 20, 100, 20);
        c.add(label1);

        t1 = new JTextField();
        t1.setBounds(120, 20, 100, 20);
        c.add(t1);

        label2 = new JLabel("second Element : ");
        label2.setBounds(10, 50, 100, 20);
        c.add(label2);

        t2 = new JTextField();
        t2.setBounds(120, 50, 100, 20);
        c.add(t2);

        /************************** */
        // Buttons
        add = new JButton("+");
        add.setBounds(10, 80, 50, 30);
        c.add(add);

        minus = new JButton("-");
        minus.setBounds(100, 80, 50, 30);
        c.add(minus);

        div = new JButton("/");
        div.setBounds(200, 80, 50, 30);
        c.add(div);

        mul = new JButton("X");
        mul.setBounds(300, 80, 50, 30);
        c.add(mul);

        // Result Label
        Result = new JLabel("Result : ");
        Result.setBounds(10, 120, 500, 30);
        c.add(Result);

        Re = new JTextField();
        Re.setBounds(80, 120, 150, 30);
        c.add(Re);

        add.addActionListener(this);
        minus.addActionListener(this);
        div.addActionListener(this);
        mul.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == add) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a + b;
                Re.setText("  " + c);
            }
            if (e.getSource() == minus) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a - b;
                Re.setText("  " + c);
            }
            if (e.getSource() == div) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a / b;
                Re.setText("  " + c);
            }
            if (e.getSource() == mul) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a * b;
                Re.setText("  " + c);
            }

        } catch (Exception e1) {
            Re.setText("Pls Enter Valid Integer");
        } catch (ArithmeticException e2) {
            Re.setText("ArithmeticException occur");
        }

    }
}

public class SimpleCal {
    public static void main(String[] args) {
        // System.out.println("hello");
        Myframe frame = new Myframe();
        // System.out.println(frame); 

    }

}
