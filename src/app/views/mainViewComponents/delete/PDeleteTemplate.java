package app.views.mainViewComponents.delete;

import app.views.services.AdvancedGraphicsService;
import app.views.services.GraphicObjService;
import app.views.services.ResourcesService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PDeleteTemplate extends JPanel {

    private PDeleteHandler pDeleteHandler;
    private GraphicObjService graphicObjService;
    private ResourcesService resourcesService;

    private JLabel lTitle;
    private JTextField tfID;
    private JButton bConfirm;

    public PDeleteTemplate(PDeleteHandler pDeleteHandler) {
        this.pDeleteHandler = pDeleteHandler;
        graphicObjService = GraphicObjService.getService();
        resourcesService = ResourcesService.getService();

        this.createJTextFields();
        this.createJButtons();
        this.createJLabels();

        this.setBackground(resourcesService.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void createJTextFields() {
        // ID ----------------------------------------------
        tfID = graphicObjService.buildJTextField(
                "ID", 350, 200, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfID.addFocusListener(pDeleteHandler);
        this.add(tfID);
    }

    public void createJButtons() {
        // Button CONFIRMAR ---------------------------------------
        bConfirm = graphicObjService.buildJButton(
                "Confirm", 400, 350, 400, 60, resourcesService.getcMano(), null,
                resourcesService.getFontBoton(), resourcesService.getColorAzul(),
                Color.white, null, "C", true
        );
        bConfirm.addMouseListener(pDeleteHandler);
        bConfirm.addActionListener(pDeleteHandler);
        this.add(bConfirm);
    }

    public void createJLabels() {
        // TITLE ------------------------------------------------
        lTitle = graphicObjService.buildJLabel(
                "DELETE", 0, 20, 1200, 80, null, Color.BLACK, null,
                resourcesService.getFontTituloPanel(), "c"
        );
        this.add(lTitle);
    }

    public ResourcesService getResourcesService() {
        return resourcesService;
    }

    public JTextField getTfID() {
        return tfID;
    }

    public JButton getbConfirm() {
        return bConfirm;
    }

}
