package com.TAP.VladT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class gui {
    static boolean stepNr = false;
    static int resp;
    static int a,b,c,i;
    public static void main(String args[]) {





        //Creating the Frame
        JFrame frame = SetFrame.initFrame();



        //somePanel.revalidate()
        //board.repaint();
    }

    public static void  setStepNumber(boolean nr){
        stepNr=nr;

    }
    public static void  nextStepNumber(){
        stepNr=false;
    }

    public static String getStep(){
        return Boolean.toString(stepNr);
    }

    public static void  setResp(int respArg){
        resp=respArg;
    }

    public static int  getResp(){
        return resp;
    }

    public static void  setA(int respArg){
        a=respArg;
    }
    public static void  setB(int respArg){
        b=respArg;
    }
    public static void  setC(int respArg){
        c=respArg;
    }
    public static void  setI(int respArg){
        i=respArg;
    }

}