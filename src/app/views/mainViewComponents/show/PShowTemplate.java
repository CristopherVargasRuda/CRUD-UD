package app.views.mainViewComponents.show;

import app.views.mainViewComponents.delete.PDeleteHandler;
import app.views.services.AdvancedGraphicsService;
import app.views.services.GraphicObjService;
import app.views.services.ResourcesService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PShowTemplate extends JPanel {

    private PShowHandler pShowHandler;
    private AdvancedGraphicsService advancedGraphicsService;
    private GraphicObjService graphicObjService;
    private ResourcesService resourcesService;

    private JScrollPane pTable;
    private JPanel pCorner;
    private JTable table;
    private JTableHeader header;
    private DefaultTableModel model;
    private String[] headerArray = {
        "ID", "Name", "Last Name", "Email", "Position"
    };

    public PShowTemplate(PShowHandler pShowHandler) {
        this.pShowHandler = pShowHandler;
        graphicObjService = GraphicObjService.getService();
        advancedGraphicsService = AdvancedGraphicsService.getService();
        resourcesService = ResourcesService.getService();

        this.crearJTable();

        this.setBackground(resourcesService.getColorGris());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 480));
        this.setVisible(true);
    }

    public void crearJTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(headerArray);

        table = new JTable();
        table.setModel(model);
        table.addMouseListener(pShowHandler);
        table.setRowHeight(40);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);

        header = table.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTable = graphicObjService.buildPanelBar(table, 50, 50, 1100, 380, resourcesService.getColorGris(), null);

        header.setDefaultRenderer(
                advancedGraphicsService.getCustomTable(
                        resourcesService.getColorAzulClaro(), null, null, Color.WHITE,
                        resourcesService.getFontLigera()
                )
        );

        table.setDefaultRenderer(
                Object.class,
                advancedGraphicsService.getCustomTable(
                        Color.WHITE, Color.LIGHT_GRAY,
                        resourcesService.getColorAzulClaro(),
                        Color.BLACK,
                        resourcesService.getFontLigera()
                )
        );

        pTable.getVerticalScrollBar().setUI(
                advancedGraphicsService.getCustomScroll(
                        7, 10, Color.WHITE, resourcesService.getColorAzul(),
                        resourcesService.getColorAzulClaro()
                )
        );

        pCorner = new JPanel();
        pCorner.setBackground(resourcesService.getColorNaranja());
        pTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        this.add(pTable);
    }

    public JScrollPane getpTable() {
        return pTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }

}
