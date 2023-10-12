package app.views.mainViewComponents.modify;

import app.logic.PeopleCRUD;
import app.views.MainViewHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PModifyHandler implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private MainViewHandler mainViewHandler;
    private PModifyTemplate pModifyTemplate;
    private PeopleCRUD peopleCRUD;
    private String idSelected;

    public PModifyHandler(MainViewHandler mainViewHandler) {
        this.mainViewHandler = mainViewHandler;
        peopleCRUD = new PeopleCRUD();
        pModifyTemplate = new PModifyTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pModifyTemplate.getbSearch()) {
            idSelected = pModifyTemplate.getTfID().getText();
            ArrayList<String> personData = peopleCRUD.getPersonByID(idSelected);
            if (personData != null) {
                showPersonData(personData);
            } else {
                JOptionPane.showMessageDialog(null, "No user is registered with this id", "Advertencia", 1);
            }
        }
        if (e.getSource() == pModifyTemplate.getbConfirm()) {
            if (loadData()) {
                JOptionPane.showMessageDialog(null, "Changes made successfully", "Advertencia", 1);
                clearData();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pModifyTemplate.getResourcesService().getBordeAzulClaro()
            );
            if (e.getSource() == pModifyTemplate.getTfName()
                    && textField.getText().equals("Name")) {
                pModifyTemplate.getTfName().setText("");
            }
            if (e.getSource() == pModifyTemplate.getTfLastName()
                    && textField.getText().equals("Last Name")) {
                pModifyTemplate.getTfLastName().setText("");
            }
            if (e.getSource() == pModifyTemplate.getTfID()
                    && textField.getText().equals("ID")) {
                pModifyTemplate.getTfID().setText("");
            }
            if (e.getSource() == pModifyTemplate.getTfEmail()
                    && textField.getText().equals("Email")) {
                pModifyTemplate.getTfEmail().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            JComboBox comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    pModifyTemplate.getResourcesService().getColorAzulClaro(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pModifyTemplate.getResourcesService().getBordeAzul()
            );
            if (e.getSource() == pModifyTemplate.getTfName()
                    && textField.getText().equals("")) {
                pModifyTemplate.getTfName().setText("Name");
            }
            if (e.getSource() == pModifyTemplate.getTfLastName()
                    && textField.getText().equals("")) {
                pModifyTemplate.getTfLastName().setText("Last Name");
            }
            if (e.getSource() == pModifyTemplate.getTfID()
                    && textField.getText().equals("")) {
                pModifyTemplate.getTfID().setText("ID");
            }
            if (e.getSource() == pModifyTemplate.getTfEmail()
                    && textField.getText().equals("")) {
                pModifyTemplate.getTfEmail().setText("Email");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            JComboBox comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    pModifyTemplate.getResourcesService().getColorAzul(), 2)
            );
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            if (boton.isEnabled()) {
                boton.setBackground(
                        pModifyTemplate.getResourcesService().getColorAzulClaro()
                );                
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    pModifyTemplate.getResourcesService().getColorAzul()
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    public PModifyTemplate getpModifyTemplate() {
        return pModifyTemplate;
    }

    public void showPersonData(ArrayList<String> personData){
        pModifyTemplate.getTfName().setText(personData.get(0));
        pModifyTemplate.getTfLastName().setText(personData.get(1));
        pModifyTemplate.getTfEmail().setText(personData.get(2));
        pModifyTemplate.getCbPosition().setSelectedIndex(Integer.parseInt(personData.get(3)) - 1);
        pModifyTemplate.getTfName().setEnabled(true);
        pModifyTemplate.getTfLastName().setEnabled(true);
        pModifyTemplate.getTfEmail().setEnabled(true);        
        pModifyTemplate.getCbPosition().setEnabled(true);    
        pModifyTemplate.getbConfirm().setEnabled(true);    
    }
    
    public boolean loadData() {

        String name, lastName, email;
        String position = (String) pModifyTemplate.getCbPosition().getSelectedItem();        

        // NAME ------------------------------------------------------------        
        if (!pModifyTemplate.getTfName().getText().equals("Name")
                && !pModifyTemplate.getTfName().getText().equals("")) {
            name = pModifyTemplate.getTfName().getText().trim();
        } else {
            pModifyTemplate.getTfName().setBorder(
                    pModifyTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Name", "Advertencia", 1);
            return false;
        }

        // LAST NAME ------------------------------------------------------------        
        if (!pModifyTemplate.getTfLastName().getText().equals("Last Name")
                && !pModifyTemplate.getTfLastName().getText().equals("")) {
            lastName = pModifyTemplate.getTfLastName().getText().trim();
        } else {
            pModifyTemplate.getTfLastName().setBorder(
                    pModifyTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Last Name", "Advertencia", 1);
            return false;
        }

        // Email ------------------------------------------------------- 
        if (!pModifyTemplate.getTfEmail().getText().equals("Email")
                && !pModifyTemplate.getTfEmail().getText().equals("")) {
            email = pModifyTemplate.getTfEmail().getText().trim();           
        } else {
            pModifyTemplate.getTfEmail().setBorder(
                    pModifyTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Email", "Advertencia", 1);
            return false;
        }
        
        peopleCRUD.modifyPerson(name, lastName, idSelected, email, position);
        
        return true;
    }

    public void clearData() {
        pModifyTemplate.getTfName().setText(
                "Name"
        );
        pModifyTemplate.getTfLastName().setText(
                "Last Name"
        );
        pModifyTemplate.getTfID().setText(
                "ID"
        );
        pModifyTemplate.getTfEmail().setText(
                "Email"
        );        
        pModifyTemplate.getCbPosition().setSelectedIndex(0);
        pModifyTemplate.getTfName().setEnabled(false);
        pModifyTemplate.getTfLastName().setEnabled(false);
        pModifyTemplate.getTfEmail().setEnabled(false);        
        pModifyTemplate.getCbPosition().setEnabled(false);
        pModifyTemplate.getbConfirm().setEnabled(false);
    }

    
}
