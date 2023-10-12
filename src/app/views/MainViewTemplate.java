package app.views;

import app.views.services.AdvancedGraphicsService;
import app.views.services.GraphicObjService;
import app.views.services.ResourcesService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainViewTemplate extends JFrame {

    private GraphicObjService graphicObjService;
    private ResourcesService resourcesService;
    private AdvancedGraphicsService advancedGraphicsService;

    private JPanel pMainBar, pNavegationBar, pMain;
    private ImageIcon iDimAux, iLogo, iBackground, iClose, iMinimize;
    private JLabel lLogo, lBackground;
    private JScrollPane scrollpane;
    private JButton bClose, bMinimize, bCreate, bModify, bDelete, bShow;

    private MainViewHandler mainViewHandler;

    public MainViewTemplate(MainViewHandler mainViewHandler) {
        this.mainViewHandler = mainViewHandler;

        graphicObjService = GraphicObjService.getService();
        resourcesService = ResourcesService.getService();
        advancedGraphicsService = AdvancedGraphicsService.getService();

        this.createDecoratorObjects();
        this.createJPanels();
        this.createJButtons();
        this.createJLabels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 650);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void createDecoratorObjects() {
        iLogo = new ImageIcon("resources/img/logo.png");
        iBackground = new ImageIcon("resources/img/fondo.png");
        iClose = new ImageIcon("resources/img/cerrar.png");
        iMinimize = new ImageIcon("resources/img/minimizar.png");
    }

    public void createJPanels() {
        pMainBar = graphicObjService.buildJPanel(0, 0, 1200, 120,
                resourcesService.getColorGris(), null);
        this.add(pMainBar);
        pMainBar.addMouseListener(mainViewHandler);
        pMainBar.addMouseMotionListener(mainViewHandler);

        pNavegationBar = graphicObjService.buildJPanel(0, 120, 1200, 50,
                Color.CYAN, null);
        this.add(pNavegationBar);

        pMain = graphicObjService.buildJPanel(0, 170, 1200, 480,
                resourcesService.getColorGris(), null);
        this.add(pMain);
    }

    public void createJButtons() {
        iDimAux = new ImageIcon(
                iClose.getImage().getScaledInstance(
                        50, 50, Image.SCALE_AREA_AVERAGING
                )
        );
        bClose = graphicObjService.buildJButton(
                null, 1140, 10, 50, 50, resourcesService.getcMano(), iDimAux, null,
                null, null, null, "c", false
        );
        pMainBar.add(bClose);
        bClose.addActionListener(mainViewHandler);

        iDimAux = new ImageIcon(
                iMinimize.getImage().getScaledInstance(
                        50, 50, Image.SCALE_AREA_AVERAGING
                )
        );
        bMinimize = graphicObjService.buildJButton(
                null, 1080, 10, 50, 50, resourcesService.getcMano(), iDimAux, null,
                null, null, null, "c", false
        );
        pMainBar.add(bMinimize);
        bMinimize.addActionListener(mainViewHandler);

        bCreate = graphicObjService.buildJButton(
                "Insert", 0, 0, 300, 50,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null, "C", true
        );
        bCreate.addActionListener(mainViewHandler);
        bCreate.addMouseListener(mainViewHandler);
        pNavegationBar.add(bCreate);

        // BOTÓN MODIFICAR ------------------------------------------
        bModify = graphicObjService.buildJButton(
                "Modify", 300, 0, 300, 50,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null, "C", true
        );
        bModify.addActionListener(mainViewHandler);
        bModify.addMouseListener(mainViewHandler);
        pNavegationBar.add(bModify);

        bDelete = graphicObjService.buildJButton(
                "Delete", 600, 0, 300, 50,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null, "C", true
        );
        bDelete.addActionListener(mainViewHandler);
        bDelete.addMouseListener(mainViewHandler);
        pNavegationBar.add(bDelete);

        bShow = graphicObjService.buildJButton(
                "Show", 900, 0, 300, 50,
                resourcesService.getcMano(), null, resourcesService.getFontBoton(),
                resourcesService.getColorAzul(), Color.white, null, "C", true
        );
        bShow.addActionListener(mainViewHandler);
        bShow.addMouseListener(mainViewHandler);
        pNavegationBar.add(bShow);
    }

    public void createJLabels() {
        iDimAux = new ImageIcon(
                iLogo.getImage().getScaledInstance(
                        350, 110, Image.SCALE_AREA_AVERAGING
                )
        );
        lLogo = graphicObjService.buildJLabel(
                null, (pMainBar.getWidth() - 350) / 2, 0, 350, 110, iDimAux,
                null, null, null, "c"
        );
        pMainBar.add(lLogo);

        iDimAux = new ImageIcon(
                iBackground.getImage().getScaledInstance(
                        500, 400, Image.SCALE_AREA_AVERAGING
                )
        );
        lBackground = graphicObjService.buildJLabel(
                null, 350, 40, 500, 400, iDimAux, null, null,
                null, "c"
        );
        pMain.add(lBackground);
    }

    public void createScrollpane(JPanel panel) {
        this.scrollpane = graphicObjService.buildPanelBar(panel, 0, 0, 1200, 480, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(advancedGraphicsService.getCustomScroll(
                7, 10, Color.WHITE, resourcesService.getColorAzul(), resourcesService.getColorAzulClaro())
        );
        this.scrollpane.getHorizontalScrollBar().setUI(advancedGraphicsService.getCustomScroll(
                7, 10, Color.WHITE, resourcesService.getColorAzul(), resourcesService.getColorAzulClaro())
        );
        this.pMain.add(scrollpane);
        this.scrollpane.revalidate();
    }

    public JButton getbClose() {
        return bClose;
    }

    public JButton getbMinimize() {
        return bMinimize;
    }

    public JButton getbCreate() {
        return bCreate;
    }

    public JButton getbModify() {
        return bModify;
    }

    public JButton getbDelete() {
        return bDelete;
    }

    public JButton getbShow() {
        return bShow;
    }

    public JPanel getpMainBar() {
        return pMainBar;
    }

    public JPanel getpNavegationBar() {
        return pNavegationBar;
    }

    public JPanel getpMain() {
        return pMain;
    }

    public GraphicObjService getGraphicObjService() {
        return graphicObjService;
    }

    public ResourcesService getResourcesService() {
        return resourcesService;
    }

    public AdvancedGraphicsService getAdvancedGraphicsService() {
        return advancedGraphicsService;
    }
    
    
    
}
