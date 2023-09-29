package com.sbszc.employeemanager.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiPantalla extends JFrame {
    private JTextField txtEdad;
    private JTextField textField2;
    private JPanel miPanel;
    private JButton button1;

    public MiPantalla() throws HeadlessException {
        setTitle("MiPantalla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(miPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String edadString = txtEdad.getText();
                    int edad = Integer.parseInt(edadString);
                    System.out.println(edad);
                } catch (NumberFormatException exception) {
                    System.out.println("Revise los datos ingresado");
                    JOptionPane.showMessageDialog(MiPantalla.this, "Revise los datos");
                }

            }
        });
    }
}
