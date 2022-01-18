import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Admin implements ActionListener, Runnable {
    private Semaphore sem;
    Util util = new Util();
    JFrame janela;

    public Admin(Semaphore sem, Util util) {
        this.sem = sem;
        this.util = util;
    }

    public void menu() {
        janela = new JFrame("Admin");

        // define layout para janela
        janela.getContentPane().setLayout(new FlowLayout());

        JButton botaoA = new JButton("A");
        JButton botaoF = new JButton("F");


        // define listeners para botões
        botaoA.addActionListener(this);
        botaoF.addActionListener(this);


        // adiciona botões à janela
        janela.add(botaoA);
        janela.add(botaoF);


        janela.setSize(300, 400);
        // janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        // este código pode ser melhorado
        if (action.equals("A")) {
            util.setButton("A");
            sem.release();
        } else {
            util.setButton("F");
            sem.release();
        }
    }

    @Override
    public void run() {
        menu();
    }
}
