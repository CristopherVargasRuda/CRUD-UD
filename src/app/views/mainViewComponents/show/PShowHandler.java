package app.views.mainViewComponents.show;

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

public class PShowHandler implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private MainViewHandler mainViewHandler;
    private PShowTemplate pShowTemplate;
    
    private PeopleCRUD peopleCRUD;

    public PShowHandler(MainViewHandler mainViewHandler) {
        this.mainViewHandler = mainViewHandler;
        peopleCRUD = new PeopleCRUD();
        pShowTemplate = new PShowTemplate(this);
    }
    
    public void showPeopleTable() {
        clearTable();
        for (ArrayList<String> person : peopleCRUD.getPeopleList()) {
            pShowTemplate.getModel().addRow(new Object[]{
                person.get(0), person.get(1), person.get(2), person.get(3), 
                person.get(4)
            });
        }
    }
    
    public void clearTable() {
        int a = pShowTemplate.getModel().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            pShowTemplate.getModel().removeRow(
                    pShowTemplate.getModel().getRowCount() - 1
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void focusGained(FocusEvent fe) {

    }

    @Override
    public void focusLost(FocusEvent fe) {

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
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    public PShowTemplate getpShowTemplate() {
        return pShowTemplate;
    }

}
