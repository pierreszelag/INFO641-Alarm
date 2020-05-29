package com.pierre.cours;

import com.pierre.cours.alarm.Alarm;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonitorGUI extends JFrame implements ActionListener, ListSelectionListener {
    JList<String> jAlarmList = new JList<String>();
    ArrayList<Alarm> alarmList = new ArrayList<Alarm>();

    public MonitorGUI(){
        this.setTitle("Alarm Monitor");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(300, 500);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setMonitor();
        this.setVisible(true);
    }

    public void setMonitor(){
        JPanel list = new JPanel();
        this.jAlarmList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jAlarmList.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

    }
}
