import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleWindow extends JFrame {

    SimpleWindow(){
        super("Fractal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1300, 600);
        setResizable(false);
        setLocationRelativeTo(null); // фрейм по центру экрана
        setLayout(new BorderLayout()); // задаем менеджер компаноки BorderLayout

        final DrawPanel drawPanel = new DrawPanel(); // создаем панель для рисования
        JPanel buttonPanel = new JPanel(); // создаем панель для кнопок
        buttonPanel.setLayout(new FlowLayout());

// добавляем панели на фрейм
        add(drawPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(new JLabel(""));
        final JTextField x1 = new JTextField("", 8);
        x1.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x1);

        JButton buttonA = new JButton("A");
        buttonPanel.add(buttonA);

        buttonPanel.add(new JLabel(""));
        final JTextField x2 = new JTextField("", 8);
        x2.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x2);

        JButton buttonT = new JButton("T");
        buttonPanel.add(buttonT);

        buttonPanel.add(new JLabel(""));
        final JTextField x3 = new JTextField("", 3);
        x3.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x3);

        JButton buttonY = new JButton("Corner");
        buttonPanel.add(buttonY);

        buttonPanel.add(new JLabel(""));
        final JTextField x4 = new JTextField("", 3);
        x4.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x4);

        JButton buttonP = new JButton("Step");
        buttonPanel.add(buttonP);

        buttonPanel.add(new JLabel(""));
        final JTextField x5 = new JTextField("", 4);
        x5.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x5);

        JButton buttonX = new JButton("X");
        buttonPanel.add(buttonX);

        buttonPanel.add(new JLabel(""));
        final JTextField x6 = new JTextField("", 4);
        x6.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x6);

        JButton buttonY1 = new JButton("Y");
        buttonPanel.add(buttonY1);

        buttonPanel.add(new JLabel(""));
        final JTextField x7 = new JTextField("", 3);
        x7.setHorizontalAlignment(JTextField.RIGHT);
        buttonPanel.add(x7);

        JButton buttonL = new JButton("Length");
        buttonPanel.add(buttonL);

        JButton buttonDraw = new JButton("Draw");
        buttonPanel.add(buttonDraw);

        buttonDraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.setDrawMode(1);
                drawPanel.setA(String.valueOf(x1.getText()));
                drawPanel.setRule(String.valueOf(x2.getText()));
                drawPanel.seta(Double.valueOf(x3.getText()));
                drawPanel.setn(Integer.valueOf(x4.getText()));
                drawPanel.setX(Integer.valueOf(x5.getText()));
                drawPanel.setY(Integer.valueOf(x6.getText()));
                drawPanel.setD(Integer.valueOf(x7.getText()));
                drawPanel.repaint();
            }
        });

        setVisible(true);
    }
}
