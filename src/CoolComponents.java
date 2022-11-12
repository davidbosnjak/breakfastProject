import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class CoolComponents {

    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
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
