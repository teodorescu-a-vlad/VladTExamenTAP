package com.TAP.VladT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.TAP.VladT.SetButtons.getButtonVal;
import static com.TAP.VladT.SetButtons.setGroup;
import static com.TAP.VladT.gui.*;

public class SetFrame {

    public static JFrame initFrame(){
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);


        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Back");
        JMenuItem m12 = new JMenuItem("Reset");
        m1.add(m11);
        m1.add(m12);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output

        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");


        JButton reset = new JButton("Reset");

        //panel.add(tf);
        panel.add(send);
        panel.add(reset);
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        JPanel rpanel= setGroup(new String[]{"Variabila de iesire!","Variabila de intrare!","Variabila intermediara!"});

        frame.getContentPane().add(BorderLayout.CENTER, rpanel);
        frame.setVisible(true);


        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    String[] step = {"Variabila de iesire!", "Variabila de intrare!", "Variabila intermediara!"};

                    frame.remove(rpanel);
                    JPanel rpanel = SetButtons.setGroup(step);
                    frame.getContentPane().add(BorderLayout.CENTER, rpanel);
                    frame.repaint();
                    frame.setVisible(true);
                    setStepNumber(true);




            }
        });

        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (getStep()=="false") {
                    String[] step = {"v←v", "v←v+1", "v←v-1", "IF v≠0 goto L"};

                    setResp(Integer.getInteger(getButtonVal()));

                    if (getResp()==0){
                        setC(getResp());
                    } else{
                        JDialog dial = new JDialog(frame);
                        dial.setVisible(true);
                        if (getResp()==1) {

                    }
                    }

                    frame.remove(rpanel);
                    JPanel rpanel = SetButtons.setGroup(step);
                    frame.getContentPane().add(BorderLayout.CENTER, rpanel);
                    frame.repaint();
                    frame.setVisible(true);

                    nextStepNumber();


                }

            }
        });



        return frame;

    }



}
