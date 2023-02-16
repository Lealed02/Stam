import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class CustomScrollBarUI extends BasicScrollBarUI {
    
      private final Dimension d = new Dimension();

      @Override
      protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
          
            private static final long serialVersionUID = -3592643796245558676L;

            @Override
              public Dimension getPreferredSize() {
                return d;
              }
            };
      }
      //a
      @Override
      protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
          
            private static final long serialVersionUID = 1L;

        @Override
          public Dimension getPreferredSize() {
            return d;
          }
        };
      }

      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    	  g.setColor(new Color(42,47,55));
    	  Graphics2D g2 = (Graphics2D) g.create();
    	  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	  g2.fillRect(0, 0, r.width, r.height);
    	  g2.dispose();
      }
      
    
      

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        
        if(isDragging) {
        	
        } else {
        	if (!sb.isEnabled() || r.width > r.height) {
         	   
                return;
              } 
        }
       
        
        color = Color.decode("#636474");
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, 5, r.height, 10, 10);
        g2.setPaint(Color.WHITE);
        
       // g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.dispose();
      }

      @Override
      protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
      }
    }