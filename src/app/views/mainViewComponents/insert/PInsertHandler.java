package app.views.mainViewComponents.insert;

import app.logic.PeopleCRUD;
import app.views.MainViewHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PInsertHandler implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private MainViewHandler mainViewHandler;
    private PInsertTemplate pInsertTemplate;

    private PeopleCRUD peopleCRUD;
    
    private JButton boton;

    public PInsertHandler(MainViewHandler mainViewHandler) {
        this.mainViewHandler = mainViewHandler;
        peopleCRUD = new PeopleCRUD();
        pInsertTemplate = new PInsertTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (loadData()) {
            JOptionPane.showMessageDialog(null, "Successful registration", "Advertencia", 1);
            clearData();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pInsertTemplate.getResourcesService().getBordeAzulClaro()
            );
            if (e.getSource() == pInsertTemplate.getTfName()
                    && textField.getText().equals("Name")) {
                pInsertTemplate.getTfName().setText("");
            }
            if (e.getSource() == pInsertTemplate.getTfLastName()
                    && textField.getText().equals("Last Name")) {
                pInsertTemplate.getTfLastName().setText("");
            }
            if (e.getSource() == pInsertTemplate.getTfID()
                    && textField.getText().equals("ID")) {
                pInsertTemplate.getTfID().setText("");
            }
            if (e.getSource() == pInsertTemplate.getTfEmail()
                    && textField.getText().equals("Email")) {
                pInsertTemplate.getTfEmail().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            JComboBox comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    pInsertTemplate.getResourcesService().getColorAzulClaro(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pInsertTemplate.getResourcesService().getBordeAzul()
            );
            if (e.getSource() == pInsertTemplate.getTfName()
                    && textField.getText().equals("")) {
                pInsertTemplate.getTfName().setText("Name");
            }
            if (e.getSource() == pInsertTemplate.getTfLastName()
                    && textField.getText().equals("")) {
                pInsertTemplate.getTfLastName().setText("Last Name");
            }
            if (e.getSource() == pInsertTemplate.getTfID()
                    && textField.getText().equals("")) {
                pInsertTemplate.getTfID().setText("ID");
            }
            if (e.getSource() == pInsertTemplate.getTfEmail()
                    && textField.getText().equals("")) {
                pInsertTemplate.getTfEmail().setText("Email");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            JComboBox comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    pInsertTemplate.getResourcesService().getColorAzul(), 2)
            );
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    pInsertTemplate.getResourcesService().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    pInsertTemplate.getResourcesService().getColorAzul()
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public PInsertTemplate getpInsertTemplate() {
        return pInsertTemplate;
    }

    public boolean loadData() {

        String name, lastName, id, email;
        String position = (String) pInsertTemplate.getCbPositionUD().getSelectedItem();        

        // NAME ------------------------------------------------------------        
        if (!pInsertTemplate.getTfName().getText().equals("Name")
                && !pInsertTemplate.getTfName().getText().equals("")) {
            name = pInsertTemplate.getTfName().getText().trim();
        } else {
            pInsertTemplate.getTfName().setBorder(
                    pInsertTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Name", "Advertencia", 1);
            return false;
        }

        // LAST NAME ------------------------------------------------------------        
        if (!pInsertTemplate.getTfLastName().getText().equals("Last Name")
                && !pInsertTemplate.getTfLastName().getText().equals("")) {
            lastName = pInsertTemplate.getTfLastName().getText().trim();
        } else {
            pInsertTemplate.getTfLastName().setBorder(
                    pInsertTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Last Name", "Advertencia", 1);
            return false;
        }

        // ID ------------------------------------------------------- 
        if (!pInsertTemplate.getTfID().getText().equals("ID")
                && !pInsertTemplate.getTfID().getText().equals("")) {
            id = pInsertTemplate.getTfID().getText().trim();
        } else {
            pInsertTemplate.getTfID().setBorder(
                    pInsertTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Documento", "Advertencia", 1);
            return false;
        }

        // Email ------------------------------------------------------- 
        if (!pInsertTemplate.getTfEmail().getText().equals("Email")
                && !pInsertTemplate.getTfEmail().getText().equals("")) {
            email = pInsertTemplate.getTfEmail().getText().trim();           
        } else {
            pInsertTemplate.getTfEmail().setBorder(
                    pInsertTemplate.getResourcesService().getBordeNaranja()
            );
            JOptionPane.showMessageDialog(null, "Invalid Email", "Advertencia", 1);
            return false;
        }

        peopleCRUD.createPerson(name, lastName, id, email, position);
        
        return true;
    }

    public void clearData() {
        pInsertTemplate.getTfName().setText(
                "Name"
        );
        pInsertTemplate.getTfLastName().setText(
                "Last Name"
        );
        pInsertTemplate.getTfID().setText(
                "ID"
        );
        pInsertTemplate.getTfEmail().setText(
                "Email"
        );
        pInsertTemplate.getCbPositionUD().setSelectedIndex(0);
    }

}
