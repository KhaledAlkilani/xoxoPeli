import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//Khaled teki
public class xoxoPeli implements ActionListener {

    Random random = new Random();
    JFrame runko = new JFrame();
    JPanel otsikko_Paneeli = new JPanel();
    JPanel button_paneeli = new JPanel();
    JLabel tekstikenta = new JLabel();
    JButton[] buttonit = new JButton[9];
    boolean pelaaja1_vuoro;

    // Khaled teki
    xoxoPeli() {
        runko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runko.setSize(800, 800);
        runko.getContentPane().setBackground(Color.GRAY);
        runko.setLayout(new BorderLayout());
        runko.setVisible(true);

        tekstikenta.setBackground(Color.WHITE);
        tekstikenta.setForeground(Color.GREEN);
        tekstikenta.setFont(new Font("Ink Free", Font.BOLD, 75));
        tekstikenta.setHorizontalAlignment(JLabel.CENTER);
        tekstikenta.setText("XOXO Peli");
        tekstikenta.setOpaque(true);

        otsikko_Paneeli.setLayout(new BorderLayout());
        otsikko_Paneeli.setBounds(0, 0, 800, 100);

        button_paneeli.setLayout(new GridLayout(3, 3));
        button_paneeli.setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++) {
            buttonit[i] = new JButton();
            button_paneeli.add(buttonit[i]);
            buttonit[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttonit[i].setFocusable(false);
            buttonit[i].addActionListener(this);

        }

        otsikko_Paneeli.add(tekstikenta);
        runko.add(otsikko_Paneeli, BorderLayout.NORTH);
        runko.add(button_paneeli);

        ensiVuoro();

    }

    // Khaled teki
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttonit[i]) {
                if (pelaaja1_vuoro) {
                    if (buttonit[i].getText() == "") {
                        buttonit[i].setForeground(Color.BLUE);
                        buttonit[i].setText("X");
                        pelaaja1_vuoro = false;
                        tekstikenta.setText("O vuoro");
                        tarkista();
                    }
                } else {
                    if (buttonit[i].getText() == "") {
                        buttonit[i].setForeground(Color.ORANGE);
                        buttonit[i].setText("O");
                        pelaaja1_vuoro = true;
                        tekstikenta.setText("X vuoro");
                        tarkista();
                    }
                }
            }
        }
    }

    // Arshiya teki
    public void ensiVuoro() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            pelaaja1_vuoro = true;
            tekstikenta.setText("X vuoro");
        } else {
            pelaaja1_vuoro = false;
            tekstikenta.setText("O Vuoro");
        }
    }

    // Arshiya teki
    public void tarkista() {

        if ((buttonit[0].getText() == "X") && (buttonit[1].getText() == "X") && (buttonit[2].getText() == "X")) {
            xVoita(0, 1, 2);
        }
        if ((buttonit[3].getText() == "X") && (buttonit[4].getText() == "X") && (buttonit[5].getText() == "X")) {
            xVoita(3, 4, 5);
        }
        if ((buttonit[6].getText() == "X") && (buttonit[7].getText() == "X") && (buttonit[8].getText() == "X")) {
            xVoita(6, 7, 8);
        }
        if ((buttonit[0].getText() == "X") && (buttonit[3].getText() == "X") && (buttonit[6].getText() == "X")) {
            xVoita(0, 3, 6);
        }
        if ((buttonit[1].getText() == "X") && (buttonit[4].getText() == "X") && (buttonit[7].getText() == "X")) {
            xVoita(1, 4, 7);
        }
        if ((buttonit[2].getText() == "X") && (buttonit[5].getText() == "X") && (buttonit[8].getText() == "X")) {
            xVoita(2, 5, 8);
        }
        if ((buttonit[0].getText() == "X") && (buttonit[4].getText() == "X") && (buttonit[8].getText() == "X")) {
            xVoita(0, 4, 8);
        }
        if ((buttonit[2].getText() == "X") && (buttonit[4].getText() == "X") && (buttonit[6].getText() == "X")) {
            xVoita(2, 4, 6);
        }
        if ((buttonit[0].getText() == "O") && (buttonit[1].getText() == "O") && (buttonit[2].getText() == "O")) {
            oVoita(0, 1, 2);
        }
        if ((buttonit[3].getText() == "O") && (buttonit[4].getText() == "O") && (buttonit[5].getText() == "O")) {
            oVoita(3, 4, 5);
        }
        if ((buttonit[6].getText() == "O") && (buttonit[7].getText() == "O") && (buttonit[8].getText() == "O")) {
            oVoita(6, 7, 8);
        }
        if ((buttonit[0].getText() == "O") && (buttonit[4].getText() == "O") && (buttonit[8].getText() == "O")) {
            oVoita(0, 4, 8);
        }
        if ((buttonit[2].getText() == "O") && (buttonit[4].getText() == "O") && (buttonit[6].getText() == "O")) {
            oVoita(2, 4, 6);
        }
    }

    // Arshiya teki
    public void xVoita(int a, int b, int c) {

        buttonit[a].setBackground(Color.CYAN);
        buttonit[b].setBackground(Color.CYAN);
        buttonit[c].setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++) {
            buttonit[i].setEnabled(false);
        }
        tekstikenta.setText("X voitti");
    }

    // Arshiya teki
    public void oVoita(int a, int b, int c) {

        buttonit[a].setBackground(Color.CYAN);
        buttonit[b].setBackground(Color.CYAN);
        buttonit[c].setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++) {
            buttonit[i].setEnabled(false);
        }
        tekstikenta.setText("O voitti");
    }
}