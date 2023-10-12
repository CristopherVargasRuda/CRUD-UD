package app.views.mainViewComponents.insert;

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

public class PInsertTemplate extends JPanel {

    private PInsertHandler pInsertHandler;
    private GraphicObjService graphicObjService;
    private ResourcesService resourcesService;

    private JLabel lTitle;
    private JTextField tfName, tfLastName, tfID, tfEmail;
    private JComboBox cbPosition;
    private JButton bConfirm;

    public PInsertTemplate(PInsertHandler pInsertHandler) {
        this.pInsertHandler = pInsertHandler;
        graphicObjService = GraphicObjService.getService();
        resourcesService = ResourcesService.getService();

        createJLabels();
        createJTextFields();
        createJComboBox();
        createJButtons();

        this.setBackground(resourcesService.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void createJLabels() {
        lTitle = graphicObjService.buildJLabel(
                "INSERT", 0, 20, 1200, 80, null, Color.BLACK, null,
                resourcesService.getFontTituloPanel(), "c"
        );
        this.add(lTitle);
    }

    public void createJTextFields() {
        tfName = graphicObjService.buildJTextField(
                "Name", 50, 150, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfName.addFocusListener(pInsertHandler);
        this.add(tfName);

        tfLastName = graphicObjService.buildJTextField(
                "Last Name", 650, 150, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfLastName.addFocusListener(pInsertHandler);
        this.add(tfLastName);

        tfID = graphicObjService.buildJTextField(
                "ID", 50, 250, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfID.addFocusListener(pInsertHandler);
        this.add(tfID);

        tfEmail = graphicObjService.buildJTextField(
                "Email", 650, 250, 500, 40, null, Color.BLACK,
                resourcesService.getColorAzul(), resourcesService.getFontText(),
                resourcesService.getBordeAzul(), "c"
        );
        tfEmail.addFocusListener(pInsertHandler);
        this.add(tfEmail);
    }

    public void createJComboBox() {
        cbPosition = graphicObjService.buildJComboBox(
                "Student_Teacher_Operator", 50, 360, 500, 40,
                resourcesService.getColorGris(), Color.BLACK, "c"
        );
        cbPosition.setFont(resourcesService.getFontText());
        cbPosition.setBorder(BorderFactory.createLineBorder(resourcesService.getColorAzul(), 1));
        cbPosition.addFocusListener(pInsertHandler);
        this.add(cbPosition);
    }

    public void createJButtons() {
        bConfirm = graphicObjService.buildJButton(
                "Confirm", 650, 350, 500, 60,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null,
                "C", true
        );
        bConfirm.addMouseListener(pInsertHandler);
        bConfirm.addActionListener(pInsertHandler);
        this.add(bConfirm);
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

    public JComboBox getCbPositionUD() {
        return cbPosition;
    }

    public JButton getbConfirm() {
        return bConfirm;
    }
    
    

}
