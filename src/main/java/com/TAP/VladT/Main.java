package com.TAP.VladT;

import javax.swing.*; //Utilizat in iterfata grafica
import java.awt.*;//Utilizat in iterfata grafica
import java.awt.event.ActionEvent;//Folosit pentru a seta actiunea unui event
import java.awt.event.ActionListener;//Folosit pentru a captura un event
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;//Folosit pentru a seta actiunea unui event de tip keypress
import java.util.Objects;

class Main {



    public static void main(String[] args) {

        //Creating the Frame
        JFrame frame = new JFrame("Exercitiul 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);



        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel rezLb = new JLabel("Rezultatul este:");
        JButton send = new JButton("Calculeaza");
        JLabel errLb = new JLabel("");

        panel.add(send);

        panel.add(rezLb);
        panel.add(errLb);


        GridLayout horizontal = new GridLayout(0,1);

        JPanel mainpan=new JPanel(horizontal);

        JPanel panelmain0 = new JPanel();
        JLabel lbl0 = new JLabel("Ce valoare are eticheta L?");
        lbl0.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField valA=new JTextField("",5);



        valA.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                valA.setEditable(true);


                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    valA.setEditable(true);
                    errLb.setText("");
                } else {
                    valA.setEditable(false);
                    errLb.setText("* Enter only numeric digits(0-9)");
                    errLb.setForeground(Color.RED);
                }

            }
        });

        panelmain0.add(lbl0);
        panelmain0.add(valA);


        // Text Area at the Center
        JPanel panelmain1 = new JPanel();
        JPanel panelSec= new JPanel();
        JTextField valS=new JTextField(5);

        JLabel lbl1 = new JLabel("Ce tip de variabila avem?");
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelmain1.add(lbl1);

        String[] choices = { "Variabila de iesire","Variabila de intrare","Variabila de intermediara" };

        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelmain1.add(cb);

        cb.addItemListener(arg0 -> {
           if (Objects.requireNonNull(cb.getSelectedItem()).toString().equals("Variabila de iesire")){
               panelSec.setVisible(false);
               valS.setText("");

           }else {
               panelSec.setVisible(true);
           }
        });


        JLabel lbls = new JLabel("Introduceti indicele variabilei!");
        lbls.setAlignmentX(Component.CENTER_ALIGNMENT);


        valS.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                valS.setEditable(true);
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    valS.setEditable(true);
                    errLb.setText("");
                } else {
                    valS.setEditable(false);
                    errLb.setText("* Enter only numeric digits(0-9)");
                    errLb.setForeground(Color.RED);
                }

            }
        });
        panelSec.add(lbls);
        panelSec.add(valS);
        panelSec.setVisible(false);






        //

        JPanel panelmain2 = new JPanel();

        JLabel lbl2 = new JLabel("Ce instructiune folosim?");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelmain2.add(lbl2);

        String[] choices2 = { "v←v","v←v+1","v←v-1","IF v≠0 goto L" };

        final JComboBox<String> cb2 = new JComboBox<String>(choices2);

        cb2.setMaximumSize(cb2.getPreferredSize());
        cb2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelmain2.add(cb2);


        //


        JPanel panelmain3 = new JPanel();
        JLabel lbl3 = new JLabel("Introduceti L!");
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField valI=new JTextField(5);

        valI.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                valI.setEditable(true);
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    valI.setEditable(true);
                    errLb.setText("");
                } else {
                    valI.setEditable(false);
                    errLb.setText("* Enter only numeric digits(0-9)");
                    errLb.setForeground(Color.RED);
                }

            }
        });
        panelmain3.add(lbl3);
        panelmain3.add(valI);
        panelmain3.setVisible(false);

        cb2.addItemListener(arg0 -> {
            if (Objects.requireNonNull(cb2.getSelectedItem()).toString().equals("IF v≠0 goto L")){
                panelmain3.setVisible(true);

            }else {
                panelmain3.setVisible(false);
                valI.setText("");

            }
        });


        //"Variabila de iesire","Variabila de intrare","Variabila de intermediara"

        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int a=0, b = 0, c = 0, i, l;

                if (!valA.getText().isEmpty()) {
                    a=Integer.parseInt(valA.getText());
                }

                switch (cb.getSelectedItem().toString()) {
                    case "Variabila de iesire" -> {
                        c = 0;
                        errLb.setText("");

                    }
                    case "Variabila de intrare" -> {
                        if (valS.getText().isEmpty()) {
                            errLb.setText("* Completati Indicele!");
                            errLb.setForeground(Color.RED);
                            rezLb.setText("Rezultatul este:");
                        } else {
                            i = Integer.parseInt(valS.getText());
                            c = (2 * i) - 1;
                            errLb.setText("");
                        }
                    }
                    case "Variabila de intermediara" -> {
                        if (valS.getText().isEmpty()) {
                            errLb.setText("* Completati Indicele!");
                            errLb.setForeground(Color.RED);
                            rezLb.setText("Rezultatul este:");
                        } else {
                            i = Integer.parseInt(valS.getText());
                            c = 2 * i;
                            errLb.setText("");
                        }
                    }
                }

                switch (cb2.getSelectedItem().toString()) {
                    case "IF v≠0 goto L" -> {
                        if (valI.getText().isEmpty() || Integer.parseInt(valI.getText()) == 0) {
                            errLb.setText("* L trebuie sa fie un numar mai mare ca 0");
                            errLb.setForeground(Color.RED);
                            rezLb.setText("Rezultatul este:");
                        } else if (errLb.getText().equals("")) {
                            l = Integer.parseInt(valI.getText());
                            b = 2 + l;
                            errLb.setText("");
                        } else {
                            rezLb.setText("Rezultatul este:");

                        }
                    }
                    case "v←v-1" -> {
                        b = 2;
                    }
                    case "v←v+1" -> {
                        b = 1;
                    }
                    case "v←v" -> {
                        b = 0;
                    }
                }

                if (errLb.getText().equals("")){
                    rezLb.setText("Rezultatul este:"+fBiject(a,fBiject(b,c)));
                }


            }
        });


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        //frame.getContentPane().add(BorderLayout.NORTH,panelmain1 );
        mainpan.add(panelmain0);
        mainpan.add(panelmain1);
        mainpan.add(panelSec);
        mainpan.add(panelmain2);
        mainpan.add(panelmain3);
        frame.getContentPane().add(BorderLayout.CENTER, mainpan);

        frame.setVisible(true);





    }


    private static int fBiject(int a,int b) {
        int z;
        z = ((int) Math.pow(2, a) * ((2 * b) + 1)) - 1;
        return z;
    }




}