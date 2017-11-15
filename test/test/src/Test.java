    import javax.swing.*;  
    import java.awt.event.*; 
    import java.awt.*;   
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JPanel;
    import javax.swing.JFrame;
    import java.awt.EventQueue;
    
    
    
    
    public class Test extends JPanel implements ActionListener
    {  
    
        static JFrame f=new JFrame();
    Test(JFrame f,Surface m)
    {  
        
        JMenu file,edit,colour;
        JMenuItem open,save,add,delete,move,choose,white;
        JMenuBar mb=new JMenuBar(); 
        file = new JMenu("File");
        edit = new JMenu("Edit");
        colour = new JMenu("Colour");
        open = new JMenuItem("Open");  
        save = new JMenuItem("Save");
        add = new JMenuItem("Add");
        delete = new JMenuItem("Delete");
        move = new JMenuItem("Move");
        choose = new JMenuItem("Choose");
        white = new JMenuItem("White");
        file.add(open);file.add(save);
        edit.add(add);edit.add(delete);edit.add(move);
        colour.add(choose);colour.add(white);
        mb.add(file);mb.add(edit);mb.add(colour);
        
        
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
            }
        });
        
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color c=JColorChooser.showDialog(null,"Choose",Color.CYAN);
                m.ChangeColor(c);
            }
        });
        
        
        white.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //something.setColor(white);
            }
        });
        
        
        
        //f= new JFrame("2D and 3D Shapes");  
        //f.addWindowListener(this);
        f.setJMenuBar(mb);
        //f.setSize(600, 600);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setVisible(true);
        //JOptionPane.showMessageDialog(f,"Hello, Welcome to 2D and 3D Shape program.");
        
        
        
    }
    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    public void actionPerformed(ActionEvent e){  
    //Color c=JColorChooser.showDialog(this,"Choose",Color.CYAN);
    
    }
    
    
     
    public static void main(String[] args) {  
        Surface m=new Surface();
        //DisplayGraphics a=new DisplayGraphics();
         
        f.getContentPane().add(m);
        //f.add(a);
        f.add(m);
        f.pack();
        f.setSize(600,600); 
        f.setLocationByPlatform(true);
        //f.setLayout(null);  
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        new Test(f,m);
    }     

    }







/*import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Test extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 700;
   private static final Color SHAPE_COLOR = new Color(255, 100, 100);
   private Path2D myShape = new Path2D.Double();

   public Test() {
      myShape.append(new Ellipse2D.Double(150, 50, 200, 200), true);
      myShape.append(new Rectangle2D.Double(150, 150, 200, 400), true);
      myShape.append(new Ellipse2D.Double(350, 250, 150, 150), true);
      myShape.append(new Ellipse2D.Double(150, 450, 200, 200), true);

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      if (myShape != null) {
         g2.setColor(SHAPE_COLOR);
         g2.fill(myShape);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   class MyMouseAdapter extends MouseAdapter {
      private boolean pressed = false;
      private Point point;

      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }

         if (myShape != null && myShape.contains(e.getPoint())) {
            pressed = true;
            this.point = e.getPoint();
         }
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (pressed) {
            int deltaX = e.getX() - point.x;
            int deltaY = e.getY() - point.y;           
            myShape.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
            point = e.getPoint();
            repaint();
         }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         pressed = false;
      }
   }

   private static void createAndShowGui() {
      Test mainPanel = new Test();

      JFrame frame = new JFrame("DragShape");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}*/