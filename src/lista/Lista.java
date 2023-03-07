package lista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Lista extends JFrame{

    public Lista()
    {
        initComponents();
    }
    public void initComponents()
    {
        
        this.setTitle("Lista");
        this.setBounds(300, 320, 400, 200);
        //String [] nazwa = new String[]{"lala", "przykład"};
        
        listaPrzedmiotow.setVisibleRowCount(3);
        //listaPrzedmiotow.setFixedCellHeight(25);
        //listaPrzedmiotow.setFixedCellWidth(100);
        listaPrzedmiotow.setSelectionBackground(Color.lightGray);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN);
        //listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP);
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Zmieniłem się"+(++i));
                
                if(e.getValueIsAdjusting())
                    System.out.println("Trzymam button myszy");
                else
                    System.out.println("Puściłem button myszy");
                
                if(!e.getValueIsAdjusting())
                {
                    Object[] wartosciWLiscie = ((JList)e.getSource()).getSelectedValues();
                    
                    String przedmioty = "";
                    
                    for(i=0; i<wartosciWLiscie.length; i++)
                        przedmioty +=(String)wartosciWLiscie[i] + " ";
                    
                    System.out.println(przedmioty);
                    
                    komunikat.setText("Nie lubie następujących przedmiotów: " + przedmioty);
                }
            }
        });
        
        DefaultListModel modelListy = new DefaultListModel();
        
        String[] tekst = new String[]{"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"};
        for(i=0; i<tekst.length; i++)
            modelListy.addElement(tekst[i]);
        
        modelListy.addElement("k");
        modelListy.addElement("g");
        modelListy.addElement("h");
        
        JList lista2 = new JList(modelListy);
        
        lista2.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                modelListy.removeAllElements();
            }
        });
        
        panelListy.add(scrollListy);
        panelKomunikatu.add(komunikat);
        
        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.getContentPane().add(lista2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(3);
    }
    
    private int i = 0;
    private JList listaPrzedmiotow = new JList(new String[]{"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"});
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel("test");
    
    public static void main(String[] args) {
        new Lista().setVisible(true);
    }
    
}
