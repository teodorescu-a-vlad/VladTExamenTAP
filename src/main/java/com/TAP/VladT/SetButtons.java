package com.TAP.VladT;

import javax.swing.*;
import java.awt.*;

public class SetButtons {
    static JPanel rpanel = new JPanel();
    static ButtonGroup g = new ButtonGroup();
    public static JPanel setGroup(String[] elem){


        rpanel.removeAll();
        JRadioButton rb[] = new JRadioButton[elem.length];
        rpanel.setLayout(new GridLayout(elem.length,1));
        //rb[1].setText("Test1");


        for (String str:elem) {
            int i = 0;
            JRadioButton x = new javax.swing.JRadioButton();
            x.setActionCommand(Integer.toString(i));
            x.setText(str);
            g.add(x);
            rpanel.add(x);
            i=i+1;
        }


        rpanel.revalidate();
        rpanel.repaint();

        return rpanel;

    }

    public static void clearJpanel(){
        rpanel.removeAll();
        rpanel.revalidate();
        rpanel.repaint();
    }

    public static String getButtonVal(){
        return g.getSelection().getActionCommand();
    }


}
