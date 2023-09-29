package com.sbszc.employeemanager.view;

import com.sbszc.employeemanager.presenter.IEmployeePresenter;
import com.sbszc.employeemanager.presenter.dto.AccountantDto;
import com.sbszc.employeemanager.presenter.dto.CourierDto;
import com.sbszc.employeemanager.presenter.dto.EmployeeDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeFrame extends JFrame {
    private final IEmployeePresenter employeePresenter;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtCommission;
    private JButton btnSearch;
    private JButton btnSave;
    private JButton deleteButton;
    private JComboBox<String> cmbType;
    private JPanel panel;

    public EmployeeFrame(IEmployeePresenter employeePresenter) throws HeadlessException {
        this.employeePresenter = employeePresenter;

        cmbType.setSelectedItem("Courier");
        txtCommission.setEnabled(false);

        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cmbType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbType.getSelectedItem().equals("Accountant")) {
                    txtCommission.setEnabled(true);
                } else {
                    txtCommission.setText("");
                    txtCommission.setEnabled(false);
                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
    }

    private void search() {
        try {
            long id = Long.parseLong(txtId.getText());
            EmployeeDto foundEmployeeDto = employeePresenter.findById(id);
            if (foundEmployeeDto != null) {
                txtId.setText(String.valueOf(foundEmployeeDto.getId()));
                txtName.setText(foundEmployeeDto.getName());
                txtSalary.setText(String.valueOf(foundEmployeeDto.getSalary()));
                if (foundEmployeeDto instanceof AccountantDto accountantDto) {
                    cmbType.setSelectedItem("Accountant");
                    txtCommission.setText(String.valueOf(accountantDto.getCommission()));
                } else if (foundEmployeeDto instanceof CourierDto courierDto) {
                    cmbType.setSelectedItem("Courier");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Employee doesn't exist");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bad id");
        }
    }

    private void save() {
        try {
            long id = Long.parseLong(txtId.getText());
            String name = txtName.getText();
            int salary = Integer.parseInt(txtSalary.getText());

            EmployeeDto employeeDto = null;
            if (cmbType.getSelectedItem().equals("Accountant")) {
                int commission = Integer.parseInt(txtCommission.getText());
                employeeDto = new AccountantDto(id, name, salary, commission);
            } else if (cmbType.getSelectedItem().equals("Courier")) {
                employeeDto = new CourierDto(id, name, salary);
            }

            if (employeePresenter.save(employeeDto)) {
                JOptionPane.showMessageDialog(this, "Employee saved");
                txtId.setText("");
                txtName.setText("");
                txtSalary.setText("");
                cmbType.setSelectedItem("Courier");
            } else {
                JOptionPane.showMessageDialog(this, "Employee already exists");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bad field");
        }

    }

    private void delete() {
        try {
            long id = Long.parseLong(txtId.getText());
            EmployeeDto foundEmployeeDto = employeePresenter.findById(id);
            if (foundEmployeeDto != null) {
                if (employeePresenter.deleteById(id)) {
                    txtId.setText("");
                    txtName.setText("");
                    txtSalary.setText("");
                    txtCommission.setText("");
                    cmbType.setSelectedItem("Courier");
                    JOptionPane.showMessageDialog(this, "Employee was deleted");
                } else {
                    JOptionPane.showMessageDialog(this, "Employee was not deleted");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Employee doesn't exist");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bad id");
        }
    }
}
