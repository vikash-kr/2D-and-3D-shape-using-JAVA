import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

class Surface extends JPanel {
    
    private static final int PREF_W = 800;
    private static final int PREF_H = 700;
    Color SHAPE_COLOR = new Color(255, 100, 100);
    private Path2D myShape = new Path2D.Double();
    public Surface() {
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
   
   void ChangeColor(Color a)
   {
       SHAPE_COLOR = a;
       repaint();
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
    
}