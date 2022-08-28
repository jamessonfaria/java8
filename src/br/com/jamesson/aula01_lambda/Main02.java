package br.com.jamesson.aula01_lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main02 {

    public static void main(String[] args) {

        // Java 7
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ola mundo...");
            }
        });

        // Java 8
        JButton jButton2 = new JButton();
        jButton2.addActionListener(e -> System.out.println("Ola mundo..."));
    }

}
