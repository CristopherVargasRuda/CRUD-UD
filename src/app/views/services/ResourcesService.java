package app.views.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ResourcesService {

    private Color colorNaranja, colorAzul, colorGris, colorAzulClaro;
    private Font fontTituloPanel, fontNavegacion, fontText, fontBoton,
            fontLigera;
    private Border bordeAzul, bordeAzulClaro, bordeNaranja;
    private Cursor cMano;

    static private ResourcesService servicio;

    public static ResourcesService getService() {
        if (servicio == null) {
            servicio = new ResourcesService();
        }
        return servicio;
    }

    private ResourcesService() {

        colorNaranja = new Color(255, 123, 65);
        colorAzul = new Color(43, 78, 152);
        colorAzulClaro = new Color(52, 152, 219);
        colorGris = new Color(239, 239, 241);

        fontTituloPanel = new Font("Arial Rounded MT Bold", Font.PLAIN, 50);
        fontNavegacion = new Font("book antiqua", Font.PLAIN, 20);
        fontText = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        fontBoton = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        fontLigera = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);

        cMano = new Cursor(Cursor.HAND_CURSOR);

        bordeAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
        bordeAzulClaro = BorderFactory.createMatteBorder(0, 0, 3, 0, colorAzulClaro);
        bordeNaranja = BorderFactory.createMatteBorder(0, 0, 3, 0, colorNaranja);
    }

    public Color getColorNaranja() {
        return colorNaranja;
    }

    public Color getColorAzul() {
        return colorAzul;
    }

    public Color getColorGris() {
        return colorGris;
    }

    public Font getFontTituloPanel() {
        return fontTituloPanel;
    }

    public Font getFontNavegacion() {
        return fontNavegacion;
    }

    public Font getFontText() {
        return fontText;
    }

    public Font getFontBoton() {
        return fontBoton;
    }

    public Font getFontLigera() {
        return fontLigera;
    }

    public Border getBordeAzul() {
        return bordeAzul;
    }

    public Border getBordeAzulClaro() {
        return bordeAzulClaro;
    }

    public Border getBordeNaranja() {
        return bordeNaranja;
    }

    public Cursor getcMano() {
        return cMano;
    }

    public Color getColorAzulClaro() {
        return colorAzulClaro;
    }

}
