/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PemrogramanII;

/**
 *
 * @author SB601-06
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Tugas_PraktikumPemrograman2 extends JFrame {
    public Tugas_PraktikumPemrograman2(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent we){
               String ObjButtons[] = {"Ya","Tidak"};

                int PromptResult = JOptionPane.showOptionDialog(null,
                "Anda yakin akan keluar?", "Peringatan",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                ObjButtons,ObjButtons[1]);
                if(PromptResult==0)
                {
                    System.exit(0);
                }
           } 
        });
        
        JLabel labelInput = new JLabel("Input Nama : ");
        labelInput.setBounds(15,40,350,10);
        
        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);
        
        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15,100,350,10);
        
        JRadioButton radioButton = new JRadioButton("Laki-Laki", true);
        radioButton.setBounds(15,115,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,140,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
        bg.add(radioButton2);
        
        JLabel labelNomor = new JLabel("Nomor HP : ");
        labelNomor.setBounds(15,180,350,10);
        
        JTextField textField2 = new JTextField();
        textField2.setBounds(15,200,350,30);
        
        JLabel labelAlamat = new JLabel("Alamat : ");
        labelAlamat.setBounds(15,220,350,10);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,240,350,70);
        
        JButton button = new JButton("Klik");
        button.setBounds(15,330,100,40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,390,350,200);
        
        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama = textField.getText();
                String jenisKelamin = "";
                if(radioButton.isSelected()){
                    jenisKelamin = radioButton.getText();
                } if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }
                
                String noHP = textField2.getText();
                String alamat = txtOutput.getText();
                
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(Tugas_PraktikumPemrograman2.this,"Nama tidak boleh kosong");
                }else if(textField2.getText().equals("")){
                    JOptionPane.showMessageDialog(Tugas_PraktikumPemrograman2.this,"No HP tidak boleh kosong");
                }else if(txtOutput.getText().equals("")){
                    JOptionPane.showMessageDialog(Tugas_PraktikumPemrograman2.this,"Alamat tidak boleh kosong");
                }else{
                    tableModel.add(new ArrayList<>(Arrays.asList(nama, jenisKelamin, noHP, alamat)));
                }
            }
            
            
        });
        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(labelInput);
        this.add(labelNomor);
        this.add(labelAlamat);
        this.add(txtOutput);
        this.add(radioButton);
        this.add(radioButton2);
        this.add(scrollableTable);
        
        this.setSize(450,700);
        this.setLayout(null);
    }
    
     public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                Tugas_PraktikumPemrograman2 t = new Tugas_PraktikumPemrograman2();
                t.setVisible(true);
            }
        });
    }
}
