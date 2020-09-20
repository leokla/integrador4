
package projeto.integrador.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Rafael Dal Prá
 * Data: 04/05/2015
 * 
 * Classe que mostra uma barra de progresso
 */
public class Progressbar extends JPanel{
    
    /**
     * Objeto JProgressBar cutomizado
     */
    private final JProgressBar progress2 = new JProgressBar() {
        @Override public void updateUI() {
            super.updateUI();
            setUI(new ProgressCircleUI());
            setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        }
    };
    
    /**
     * Construtor da classe
     */
    
    private static SwingWorker<String, Void> worker;
    
    public Progressbar(){
        
        super(new BorderLayout());// Layout do panel 
        progress2.setForeground(new Color(248,103,14));// Cor da barra de progresso
        progress2.setStringPainted(true);
       
        /**
         * Conta o tempo ao carregar a barra
         */
        worker = new Task() {
            @Override public void done() {

                frame.dispose();
                
            }
        };
        worker.addPropertyChangeListener(new ProgressListener(progress2));
        worker.execute();// Executa o contador de tempo
        
        JPanel p = new JPanel(new GridLayout(1, 2));
      
        p.add(progress2);
        p.setBackground(new Color(197, 197, 197));
        add(p);
        
        setPreferredSize(new Dimension(240, 200));
    }
    
    
    public static JDialog frame;// Frame para o JDialog
    
    public  void createAndShowGUI(JFrame f) {
        
        frame = new JDialog(f,"Carregando informações...", true);// Inicializa o JDialog
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// Nao permite o fechamento no botão X
        frame.getContentPane().add(new Progressbar());// Inicializa um objeto ProgressBar
        frame.pack();
        frame.setLocationRelativeTo(f);// Configura a localização do frame
        frame.getContentPane().setBackground(new Color(197, 197, 197));
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    /**
     * Método que encerra o frame 
     */
    public static void closeClock(){
        
        
        //frame.setVisible(false);
        frame.dispose();
    }
    
    
    private static int count = 0;
    
    public static void setCount(int c){
        
        count = c;
        
    }
    
    static int getCount(){
        
        return count++;
    }
    
}

/**
 * 
 * @author Rafael Dal Prá
 * Data: 04/05/2015
 * Classe representando o objeto JProgressBar circular
 */
class ProgressCircleUI extends BasicProgressBarUI {
    @Override public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);
        int v = Math.max(d.width, d.height);
        d.setSize(v, v);
        return d;
    }
    @Override public void paint(Graphics g, JComponent c) {
        
        Insets b = progressBar.getInsets(); 
        int barRectWidth  = progressBar.getWidth()  - b.right - b.left;
        int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double degree = 360 * progressBar.getPercentComplete();
        double sz = Math.min(barRectWidth, barRectHeight);
        double cx = b.left + barRectWidth  * .5;
        double cy = b.top  + barRectHeight * .5;
        double or = sz * .5;

        double ir = or * .5;
        Shape inner  = new Ellipse2D.Double(cx - ir, cy - ir, ir * 2, ir * 2);
        Shape outer  = new Ellipse2D.Double(cx - or, cy - or, sz, sz);
        Shape sector = new Arc2D.Double(cx - or, cy - or, sz, sz, 90 - degree, degree, Arc2D.PIE);

        Area foreground = new Area(sector);
        Area background = new Area(outer);
        Area hole = new Area(inner);

        foreground.subtract(hole);
        background.subtract(hole);

        g2.setPaint(Color.WHITE);
        g2.fill(background);

        g2.setPaint(progressBar.getForeground());
        g2.fill(foreground);
        g2.dispose();

      
        if (progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
        }
    }
}

/**
 * 
 * @author Rafael dal Prá
 * Data: 04/05/2015
 * Classe que executa a contagem do tempo da barra de progresse
 */



class Task extends SwingWorker<String, Void> {
    private final Random rnd = new Random();
    @Override public String doInBackground() {
        int current = 0;
        int lengthOfTask = 100;
        while (current <= lengthOfTask && !isCancelled()) {
            try {
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException ie) {
                return "Interrupted";
            }
            setProgress(100 * current / lengthOfTask);
            current++;
            
        }
        return "Done";
    } 
}

/**
 * 
 * @author Rafael Dal Prá
 * Data: 04/05/2015
 * Classe de listener para atualizar o progresso da barra
 */
class ProgressListener implements PropertyChangeListener {
    private final JProgressBar progressBar;
    ProgressListener(JProgressBar progressBar) {
        this.progressBar = progressBar;
        this.progressBar.setValue(0);
    }
    @Override public void propertyChange(PropertyChangeEvent evt) {
        String strPropertyName = evt.getPropertyName();
        if ("progress".equals(strPropertyName)) {
            progressBar.setIndeterminate(false);
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
        }
    }
}

