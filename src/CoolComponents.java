import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class CoolComponents {

    static class RoundedPanel extends JPanel
    {
        /** Stroke size. it is recommended to set it to 1 for better view */
        protected int strokeSize = 1;
        /** Color of shadow */
        protected Color shadowColor = Color.black;
        /** Sets if it drops shadow */
        protected boolean shady = true;
        /** Sets if it has an High Quality view */
        protected boolean highQuality = true;
        /** Double values for Horizontal and Vertical radius of corner arcs */
        protected Dimension arcs = new Dimension(20, 20);
        /** Distance between shadow border and opaque panel border */
        protected int shadowGap = 5;
        /** The offset of shadow.  */
        protected int shadowOffset = 4;
        /** The transparency value of shadow. ( 0 - 255) */
        protected int shadowAlpha = 150;
        RoundedPanel(int roundAmount){
            setOpaque(false);
            arcs.height = roundAmount;
            arcs.width = roundAmount;
        }

        //FOLLOWING CODES GOES HERE
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            int shadowGap = this.shadowGap;
            Color shadowColorA = new Color(shadowColor.getRed(),
                    shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
            Graphics2D graphics = (Graphics2D) g;

            //Sets antialiasing if HQ.
            if (highQuality) {
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
            }

            //Draws shadow borders if any.
            if (shady) {
                graphics.setColor(shadowColorA);
                graphics.fillRoundRect(
                        shadowOffset,// X position
                        shadowOffset,// Y position
                        width - strokeSize - shadowOffset, // width
                        height - strokeSize - shadowOffset, // height
                        arcs.width, arcs.height);// arc Dimension
            } else {
                shadowGap = 1;
            }

            //Draws the rounded opaque panel with borders.
            graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, width - shadowGap,
                    height - shadowGap, arcs.width, arcs.height);
            graphics.setColor(getForeground());
            graphics.setStroke(new BasicStroke(strokeSize));
            graphics.drawRoundRect(0, 0, width - shadowGap,
                    height - shadowGap, arcs.width, arcs.height);

            //Sets strokes to default, is better.
            graphics.setStroke(new BasicStroke());
        }

        }




    public static class RoundJTextField extends JTextField {
        private Shape shape;
        private Color backgroundColor = new Color(0);
        private int cornerRadius;
        public RoundJTextField(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            setOpaque(false); // As suggested by @AVD in comment.
            backgroundColor = Color.WHITE;

        }
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;

            graphics.setColor(backgroundColor);

            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.

            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
            super.paintComponent(g);

        }
        protected void paintBorder(Graphics g) {
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    public static class RoundPasswordField extends JPasswordField {
        private Shape shape;
        private int cornerRadius;
        public RoundPasswordField(int cornerRadius) {
            setOpaque(false); // As suggested by @AVD in comment.
            this.cornerRadius = cornerRadius;
        }
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;

            graphics.setColor(getBackground());

            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.

            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            super.paintComponent(g);

        }
        protected void paintBorder(Graphics g) {
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    public static class RoundButton extends JButton {
        private Shape shape;
        private Color backgroundColor = new Color(0);
        private int cornerRadius;
        public RoundButton(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            setOpaque(false); // As suggested by @AVD in comment.
            backgroundColor = Color.WHITE;

        }
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;

            graphics.setColor(backgroundColor);

            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.

            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border

        }
        protected void paintBorder(Graphics g) {
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
}
