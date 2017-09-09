
package address.model;

import address.view.TextViewerController;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class FontSize {
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = image.createGraphics();
    FontMetrics fm = g.getFontMetrics(new Font("Arial", Font.PLAIN, 6));
    int width = fm.stringWidth("Product name");
    final int w = image.getWidth();
    final int h = image.getHeight();

    public FontSize() {
//        // CLEAR BACKGROUND
//        g.setColor(Color.DARK_GRAY);
//        g.fillRect(0, 0, w, h);
//
//// ACTIVATE ANTIALIASING AND FRACTIONAL METRICS
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//
//// PREPARE TEXT, COLOR
//        final String text = "The Higgs Boson is ...";
//        g.setColor(Color.ORANGE);
//
//// CREATE GLYPHVECTOR FROM TEXT, CREATE PRELIMINARY SHAPE FOR COORDINATE CALCULATION, CALC COORDINATES
//
//        final GlyphVector gv = font.createGlyphVector(g.getFontRenderContext(), text);
//        final Rectangle2D stringBoundsForPosition = gv.getOutline().getBounds2D();
//        final double xForShapeCreation = (w - stringBoundsForPosition.getWidth()) / 2d;
//        final double yForShapeCreation = (h - stringBoundsForPosition.getHeight()) / 2d;
//
//// DERIVE SHAPE AGAIN, THIS TIME IN THE RIGHT PLACE (IT'S NOT THE ONLY POSSIBLE METHOD.)
//        final Shape textShape = gv.getOutline((float) xForShapeCreation, (float) yForShapeCreation + g.getFontMetrics(yourFont).getAscent());
//        g.fill(textShape);
//
//// GET PRECISE SHAPE BOUNDS, TURN OFF ANTIALIASING FOR HIGHER VISUAL PRECISION OF THE LINES
//        final Rectangle2D stringBoundsForEverything = textShape.getBounds2D();// JavaDocs: "Returns a high precision [...] bounding box of the Shape [...] guarantee [...] that the Shape lies entirely within the indicated Rectangle2D."
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
//
//// DRAW RECTANGLE BORDER
//        final double borderDistance = 10d;
//        final Shape borderRect = new Rectangle2D.Double(stringBoundsForEverything.getX() - borderDistance * 2, stringBoundsForEverything.getY() - borderDistance, stringBoundsForEverything.getWidth() + borderDistance * 4, stringBoundsForEverything.getHeight() + borderDistance * 2);
//        g.setStroke(new BasicStroke(3f));
//        g.draw(borderRect);
//
//// DRAW THIN TIGHT RECTANGLE BORDER
//        final Shape borderRectTight = new Rectangle2D.Double(stringBoundsForEverything.getX(), stringBoundsForEverything.getY(), stringBoundsForEverything.getWidth(), stringBoundsForEverything.getHeight());
//        g.setStroke(new BasicStroke(1f));
//        g.setColor(Color.GRAY);
//        g.draw(borderRectTight);
    }


}

