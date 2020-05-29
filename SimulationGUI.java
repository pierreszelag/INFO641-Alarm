package com.pierre.cours;

import com.pierre.cours.listener.*;
import com.pierre.cours.monitor.*;
import com.pierre.cours.sensor.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationGUI extends JFrame implements ActionListener {
    MonitorA monA = new MonitorA();
    MonitorB monB = new MonitorB();

    private JComboBox<String> alarmType = new JComboBox<>();
    private JTextField location = new JTextField("");
    private JComboBox<Integer> criticality = new JComboBox<>();
    private JButton launch = new JButton("Launch");

    public SimulationGUI() {
        this.setTitle("Alarm Simulation");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(300, 250);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setForm();
        this.setVisible(true);
    }

    public void setForm(){
        JPanel alarmPanel = new JPanel();
        JLabel alarmLabel = new JLabel("Alarm type :");
        alarmType.addItem("Fire");
        alarmType.addItem("Gaz");
        alarmType.addItem("Radiation");
        alarmPanel.add(alarmLabel);
        alarmPanel.add(alarmType);

        JPanel locationPanel = new JPanel();
        JLabel locationLabel = new JLabel("Location :");
        location.setColumns(10);
        locationPanel.add(locationLabel);
        locationPanel.add(location);

        JPanel criticalityPanel = new JPanel();
        JLabel criticalityLabel = new JLabel("Criticality :");
        criticality.addItem(1);
        criticality.addItem(2);
        criticality.addItem(3);
        criticalityPanel.add(criticalityLabel);
        criticalityPanel.add(criticality);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(launch);

        this.getContentPane().add(alarmPanel);
        this.getContentPane().add(locationPanel);
        this.getContentPane().add(criticalityPanel);
        this.getContentPane().add(buttonPanel);

        launch.setActionCommand("launch");
        launch.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String type = "";
        int criticality = 0;
        String location = "";

        if (actionEvent.getActionCommand().equals("launch"))
        {
            type = this.alarmType.getSelectedItem().toString();
            criticality = (this.criticality.getSelectedIndex() + 1);
            location = this.location.getText();

            if(type.equals("Fire"))
            {

                FireSensor fireSensor = new FireSensor(location);
                fireSensor.listenerList.add(FireListener.class, monA);
                fireSensor.createFireAlarm(criticality);


            }

            else if(type.equals("Gaz"))
            {
                GazSensor gazSensor = new GazSensor(location);
                gazSensor.listenerList.add(GazListener.class, monA);
                gazSensor.listenerList.add(GazListener.class, monB);
                gazSensor.createGazAlarm(criticality);
            }

            else if(type.equals("Radiation"))
            {
                RadSensor radSensor = new RadSensor(location);
                radSensor.listenerList.add(RadListener.class, monB);
                radSensor.createRadAlarm(criticality);
            }
        }
    }
}
