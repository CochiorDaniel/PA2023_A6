import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel extends JPanel implements ActionListener {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        resetBtn.addActionListener(this::resetGame);
        saveBtn.addActionListener(this);
        loadBtn.addActionListener(this);


    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void resetGame(ActionEvent e) {
        frame.canvas.redesenare();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveBtn){
            Date d = new Date(frame.canvas.listaLinii);
            try {
                d.save();
            }catch (IOException f){
                System.out.println("Din pacate nu s-a putut salva progresul jocului! Ofofof saracul graf =(");
            }
        }
        if(e.getSource() == loadBtn){
            Date d = new Date(frame.canvas.listaLinii);
            try {
                frame.canvas.listaLinii = d.load().getLinies();
                frame.canvas.loadedGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



}