import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
        final MainFrame frame;
        final static int W = 800, H = 600;
        static int tura = 0;
        private int numVertices;
        private double edgeProbability;
        private int[] x, y;
        protected List<Linie> listaLinii = new ArrayList<>();
        BufferedImage image; //the offscreen image
        Graphics2D graphics; //the tools needed to draw in the image
        public DrawingPanel(MainFrame frame) {
            this.frame = frame;
            createOffscreenImage();
            initPanel();
            //createBoard();
        }
        private void initPanel() {
            setPreferredSize(new Dimension(W, H));
            setBorder(BorderFactory.createEtchedBorder());
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int xMouse = e.getX();
                    int yMouse = e.getY();
                    Color c;
                    if(tura%2==0)
                        c = Color.RED;
                    else
                        c = Color.BLUE;

                    for (int i=0; i<numVertices; i++){
                        for (int j=0; j<numVertices; j++){
                           float m = (float)(y[j]-y[i])/(x[j]-x[i]);
                           if(((yMouse-y[i] <= m*(xMouse-x[i]) +5) && (yMouse-y[i] >= m*(xMouse-x[i]) -5)) ||
                                   ((Math.abs(x[j]-x[i]) <=3) && (xMouse <= x[i]+8 && xMouse >= x[j]-8) && (yMouse >= y[i] && yMouse <= y[j]))) {
                               Linie l = new Linie();
                               l.setX1(x[i]);
                               l.setY1(y[i]);
                               l.setX2(x[j]);
                               l.setY2(y[j]);
                               l.setC(Color.BLACK);
                               if(listaLinii.contains(l)) {
                                   graphics.setColor(c);
                                   graphics.drawLine(x[i], y[i], x[j], y[j]);
                                   repaint();
                                   for(int k=0; k<listaLinii.size(); k++){
                                       if(listaLinii.get(k).equals(l))
                                           listaLinii.get(k).setC(c);
                                   }
                                   checkWinner();
                                   tura++;
                               }
                           }
                        }
                    }
                }
            });
        }
        public void createOffscreenImage() {
            image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, 800, 600);
        }
        final void createBoard() {
            numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
            edgeProbability = Double.parseDouble((String) frame.configPanel.linesCombo.getSelectedItem());
            createOffscreenImage();
            createVertices();
            drawLines();
            drawVertices();
            repaint();
        }
        private void createVertices() {
            int x0 = W / 2; int y0 = H / 2; //middle of the board
            int radius = H / 2 - 10; //board radius
            double alpha = 2 * Math.PI / numVertices; // the angle
            x = new int[numVertices];
            y = new int[numVertices];
            for (int i = 0; i < numVertices; i++) {
                x[i] = x0 + (int) (radius * Math.cos(alpha * i));
                y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            }
        }
        private void drawLines() {
            Random rand = new Random();
            for (int i=0; i<numVertices; i++){
                for (int j=0; j<numVertices; j++){
                    if(rand.nextFloat() <= edgeProbability){
                        graphics.setColor(Color.BLACK);
                        graphics.drawLine(x[i],y[i],x[j],y[j]);
                        Linie l = new Linie();
                        l.setX1(x[i]);
                        l.setY1(y[i]);
                        l.setX2(x[j]);
                        l.setY2(y[j]);
                        l.setC(Color.BLACK);
                        listaLinii.add(l);
                    }
                }
            }
        }
        private void drawVertices() {
            for(int i=0; i<numVertices; i++){
                graphics.setColor(Color.BLACK);
                graphics.drawOval(x[i], y[i], 8, 8);
                graphics.fillOval(x[i],y[i],8,8);
            }
        }
        @Override
        public void update(Graphics g) { }

        @Override
        protected void paintComponent(Graphics graphics) {
            graphics.drawImage(image, 0, 0, this);
        }

        public void redesenare(){
            for(Linie l:frame.canvas.listaLinii){
                graphics.setColor(Color.BLACK);
                graphics.drawLine(l.getX1(),l.getY1(),l.getX2(),l.getY2());
                repaint();
            }
        }

    public void loadedGame(){
        for(Linie l:frame.canvas.listaLinii){
            graphics.setColor(l.getC());
            graphics.drawLine(l.getX1(),l.getY1(),l.getX2(),l.getY2());
            repaint();
        }
    }

    public void checkWinner() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i+1; j < numVertices; j++) {
                if(listaLinii.get(i).getX1() == listaLinii.get(j).getX1() && listaLinii.get(i).getY1() == listaLinii.get(j).getY1())
                     for (int k = j+1; k < numVertices; k++) {
                            if(listaLinii.get(k).getX1() == listaLinii.get(j).getX1() && listaLinii.get(k).getY1() == listaLinii.get(j).getY1()) {
                                if (listaLinii.get(k).getC() == listaLinii.get(j).getC() && listaLinii.get(k).getC() == listaLinii.get(i).getC()
                                    && listaLinii.get(k).getC() == Color.RED)
                                    System.out.println("Jucatorul cu culoarea ROSIE castiga");
                                if (listaLinii.get(k).getC() == listaLinii.get(j).getC() && listaLinii.get(k).getC() == listaLinii.get(i).getC()
                                        && listaLinii.get(k).getC() == Color.BLUE)
                                    System.out.println("Jucatorul cu culoarea ALBASTRA castiga");
                            }
                     }
            }
        }
    }


}