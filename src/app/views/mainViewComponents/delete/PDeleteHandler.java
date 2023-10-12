package app.views.mainViewComponents.delete;

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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PDeleteHandler implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private MainViewHandler mainViewHandler;
    private PDeleteTemplate pDeleteTemplate;
    private PeopleCRUD peopleCRUD;

    public PDeleteHandler(MainViewHandler mainViewHandler) {
        this.mainViewHandler = mainViewHandler;
        peopleCRUD = new PeopleCRUD();
        pDeleteTemplate = new PDeleteTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pDeleteTemplate.getbConfirm()) {
            String id = pDeleteTemplate.getTfID().getText();
            ArrayList<String> personData = peopleCRUD.getPersonByID(id);
            if (personData != null) {
                peopleCRUD.deletePerson(id);
                JOptionPane.showMessageDialog(
                        null, "User with id " + id + " has been successfully "
                                + "deleted", "Advertencia", 1
                );
            } else {
                JOptionPane.showMessageDialog(
                        null, "No user is registered with this id",
                        "Advertencia", 1
                );
            }
        }
        clearData();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pDeleteTemplate.getResourcesService().getBordeAzulClaro()
            );
            if (e.getSource() == pDeleteTemplate.getTfID()
                    && textField.getText().equals("ID")) {
                pDeleteTemplate.getTfID().setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField textField = ((JTextField) e.getSource());
            textField.setBorder(
                    pDeleteTemplate.getResourcesService().getBordeAzul()
            );
            if (e.getSource() == pDeleteTemplate.getTfID()
                    && textField.getText().equals("")) {
                pDeleteTemplate.getTfID().setText("ID");
            }
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
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    pDeleteTemplate.getResourcesService().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    pDeleteTemplate.getResourcesService().getColorAzul()
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public PDeleteTemplate getpDeleteTemplate() {
        return pDeleteTemplate;
    }

    public void clearData() {
        pDeleteTemplate.getTfID().setText(
                "ID"
        );
    }

}
