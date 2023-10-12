package app.views;

import app.views.mainViewComponents.delete.PDeleteHandler;
import app.views.mainViewComponents.insert.PInsertHandler;
import app.views.mainViewComponents.modify.PModifyHandler;
import app.views.mainViewComponents.show.PShowHandler;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainViewHandler implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private MainViewTemplate mainViewTemplate;
    private PDeleteHandler pDeleteHandler;
    private PInsertHandler pInsertHandler;
    private PModifyHandler pModifyHandler;
    private PShowHandler pShowHandler;
    private int startpositionX, startpositionY;
    private String command;
    private JButton selectedbutton;

    public MainViewHandler() {
        command = "";
        mainViewTemplate = new MainViewTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainViewTemplate.getbClose()) {
            System.exit(0);
        } else if (e.getSource() == mainViewTemplate.getbMinimize()) {
            minimize();
        } else {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    mainViewTemplate.getResourcesService().getColorAzulClaro()
            );
            if (!command.equals(e.getActionCommand().trim())) {
                command = e.getActionCommand().trim();
                selectedbutton = boton;
                this.showComponent(e.getActionCommand().trim());
            } else {
                command = "";
                selectedbutton = null;
                this.showComponent("");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
        removeSelection();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startpositionX = e.getX();
        startpositionY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    mainViewTemplate.getResourcesService().getColorAzulClaro()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        removeSelection();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        moveWindow(
                e.getXOnScreen() - startpositionX, e.getYOnScreen() - startpositionY
        );
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void minimize() {
        this.mainViewTemplate.setExtendedState(Frame.ICONIFIED);
    }

    public void moveWindow(int posicionX, int posicionY) {
        this.mainViewTemplate.setLocation(posicionX, posicionY);
    }

    public MainViewTemplate getMainViewTemplate() {
        return mainViewTemplate;
    }

    public void removeSelection() {
        if (mainViewTemplate.getbCreate()!= selectedbutton) {
            mainViewTemplate.getbCreate().setBackground(
                    mainViewTemplate.getResourcesService().getColorAzul()
            );
        }
        if (mainViewTemplate.getbModify()!= selectedbutton) {
            mainViewTemplate.getbModify().setBackground(
                    mainViewTemplate.getResourcesService().getColorAzul()
            );
        }
        if (mainViewTemplate.getbDelete()!= selectedbutton) {
            mainViewTemplate.getbDelete().setBackground(
                    mainViewTemplate.getResourcesService().getColorAzul()
            );
        }
        if (mainViewTemplate.getbShow()!= selectedbutton) {
            mainViewTemplate.getbShow().setBackground(
                    mainViewTemplate.getResourcesService().getColorAzul()
            );
        }
    }
    
    public void showComponent(String botonSeleccionado) {
        mainViewTemplate.getpMain().removeAll();
        switch (botonSeleccionado) {
            case "Insert":
                if (pInsertHandler == null){
                    pInsertHandler = new PInsertHandler(this);
                } 
                mainViewTemplate.createScrollpane(
                        pInsertHandler.getpInsertTemplate()
                );
                break;
            case "Modify":
                if (pModifyHandler == null){
                    pModifyHandler = new PModifyHandler(this);
                } 
                mainViewTemplate.createScrollpane(
                        pModifyHandler.getpModifyTemplate()
                );
                break;
            case "Delete":
                if (pDeleteHandler == null){
                    pDeleteHandler = new PDeleteHandler(this);
                } 
                mainViewTemplate.createScrollpane(
                        pDeleteHandler.getpDeleteTemplate()
                );
                break;
            case "Show":
                if (pShowHandler == null){
                    pShowHandler = new PShowHandler(this);
                } 
                pShowHandler.showPeopleTable();
                mainViewTemplate.createScrollpane(
                        pShowHandler.getpShowTemplate()
                );                
                break;
            default:
                mainViewTemplate.createJLabels();
                break;
        }
        mainViewTemplate.repaint();
    }

}
