package app.views.mainViewComponents.modify;

import app.views.services.AdvancedGraphicsService;
import app.views.services.GraphicObjService;
import app.views.services.ResourcesService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PModifyTemplate extends JPanel {

    private PModifyHandler pModifyHandler;
    private GraphicObjService graphicObjService;
    private ResourcesService resourcesService;

    private JLabel lTitle, lName, lLastName, lEmail, lPosition;
    private JTextField tfName, tfLastName, tfID, tfEmail;
    private JComboBox cbPosition;
    private JButton bConfirm, bSearch;

    public PModifyTemplate(PModifyHandler pModifyHandler) {
        this.pModifyHandler = pModifyHandler;
        graphicObjService = GraphicObjService.getService();
        resourcesService = ResourcesService.getService();

        this.createJTextFields();
        this.createJButtons();
        this.createJComboBox();
        this.createJLabels();

        this.setBackground(resourcesService.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1180, 900));
        this.setVisible(true);
    }

    public void createJTextFields() {        
        // ID ----------------------------------------------
        tfID = graphicObjService.buildJTextField(
                "ID", 50, 150, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfID.addFocusListener(pModifyHandler);
        this.add(tfID);
        
        // NAME ----------------------------------------------
        tfName = graphicObjService.buildJTextField(
                "Name", 530, 350, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfName.setEnabled(false);
        tfName.addFocusListener(pModifyHandler);
        this.add(tfName);

        // LAST NAME ----------------------------------------------
        tfLastName = graphicObjService.buildJTextField(
                "Last Name", 530, 450, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfLastName.setEnabled(false);
        tfLastName.addFocusListener(pModifyHandler);
        this.add(tfLastName);


        // EMAIL ----------------------------------------------
        tfEmail = graphicObjService.buildJTextField(
                "Email", 530, 550, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfEmail.setEnabled(false);
        tfEmail.addFocusListener(pModifyHandler);
        this.add(tfEmail);
    }

    public void createJButtons() {
        // BUTTON SEARCH ---------------------------------------
        bSearch = graphicObjService.buildJButton(
                "Search", 750, 150, 300, 60, resourcesService.getcMano(), null,
                resourcesService.getFontBoton(), resourcesService.getColorAzul(),
                Color.white, null, "C", true
        );
        bSearch.addMouseListener(pModifyHandler);
        bSearch.addActionListener(pModifyHandler);
        this.add(bSearch);

        // BUTTON CONFIRM ---------------------------------------
        bConfirm = graphicObjService.buildJButton(
                "Confirm", (1200 - 400) / 2, 800, 400, 60,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null,
                "C", true
        );
        bConfirm.setEnabled(false);
        bConfirm.addMouseListener(pModifyHandler);
        bConfirm.addActionListener(pModifyHandler);
        this.add(bConfirm);
    }

    public void createJComboBox() {
        // POSITION -------------------------------------------------------
        cbPosition = graphicObjService.buildJComboBox(
                "Student_Teacher_Operator", 530, 650, 500, 40, 
                resourcesService.getColorGris(), Color.BLACK, "c"
        );
        cbPosition.setFont(resourcesService.getFontText());
        cbPosition.setEnabled(false);
        cbPosition.setBorder(BorderFactory.createLineBorder(resourcesService.getColorAzul(), 1));
        cbPosition.addFocusListener(pModifyHandler);
        this.add(cbPosition);
    }

    public void createJLabels() {
        // TITULO COMPONENTE ------------------------------------------------
        lTitle = graphicObjService.buildJLabel(
                "MODIFY", 0, 20, 1180, 80, null, Color.BLACK, null,
                resourcesService.getFontTituloPanel(), "c"
        );
        this.add(lTitle);

        // NOMBRE ------------------------------------------------
        lName = graphicObjService.buildJLabel(
                "Name: ", 180, 350, 400, 40, null, Color.BLACK, null,
                resourcesService.getFontText(), "l"
        );
        this.add(lName);

        // APELLIDO ------------------------------------------------
        lLastName = graphicObjService.buildJLabel(
                "Last Name: ", 180, 450, 400, 40, null, Color.BLACK, null,
                resourcesService.getFontText(), "l"
        );
        this.add(lLastName);

        // Email ------------------------------------------------
        lEmail = graphicObjService.buildJLabel(
                "Email: ", 180, 550, 400, 40, null, Color.BLACK, null,
                resourcesService.getFontText(), "l"
        );
        this.add(lEmail);

        // POSITION ------------------------------------------------
        lPosition = graphicObjService.buildJLabel(
                "Position: ", 180, 650, 400, 40, null, Color.BLACK, null,
                resourcesService.getFontText(), "l"
        );
        this.add(lPosition);
    }

    public GraphicObjService getGraphicObjService() {
        return graphicObjService;
    }

    public ResourcesService getResourcesService() {
        return resourcesService;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfLastName() {
        return tfLastName;
    }

    public JTextField getTfID() {
        return tfID;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JComboBox getCbPosition() {
        return cbPosition;
    }

    public JButton getbConfirm() {
        return bConfirm;
    }

    public JButton getbSearch() {
        return bSearch;
    }

}
