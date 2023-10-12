package app.views.services;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

public class AdvancedGraphicsService {

    static private AdvancedGraphicsService servicio;

    private AdvancedGraphicsService() {
    }

    public DefaultTableCellRenderer getCustomTable(
            Color colorPrincipal, Color colorSecundario, Color colorSeleccion, Color colorFuente, Font fuente
    ) {
        return new DefaultTableCellRenderer() {
            private static final long serialVersionUID = -8946942932242371111L;

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
            ) {
                JLabel celda = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                celda.setOpaque(true);
                celda.setFont(fuente);
                celda.setForeground(colorFuente);
                celda.setHorizontalAlignment(SwingConstants.CENTER);
                if (row % 2 != 0) {
                    celda.setBackground(colorPrincipal);
                } else {
                    celda.setBackground(colorSecundario);
                }
                if (isSelected) {
                    celda.setBackground(colorSeleccion);
                    celda.setForeground(Color.WHITE);
                }
                return celda;
            }
        };
    }

    public BasicScrollBarUI getCustomScroll(
            int grosor, int radio, Color colorFondo, Color colorBarraNormal, Color colorBarraArrastrada
    ) {
        return new BasicScrollBarUI() {
            private Dimension d = new Dimension();

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(colorFondo);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled()) {
                    return;
                } else if (isDragging) {
                    g2.setPaint(colorBarraArrastrada);
                } else if (isThumbRollover()) {
                    g2.setPaint(colorBarraNormal);
                } else {
                    g2.setPaint(colorBarraNormal);
                }

                if (r.width < r.height) {
                    g2.fillRoundRect((r.width - grosor) / 2, r.y, grosor, r.height, radio, radio);
                } else {
                    g2.fillRoundRect(r.x, (r.height - grosor) / 2, r.width, grosor, radio, radio);
                }
            }
        };
    }

    public static AdvancedGraphicsService getService() {
        if (servicio == null) {
            servicio = new AdvancedGraphicsService();
        }
        return servicio;
    }
}
