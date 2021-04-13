package sample.Reportes;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import sample.Adaptador.adaptadorSql;

public class generarReporte {


    void abrirReporte() {
        adaptadorSql conector = new adaptadorSql();
        JasperPrint jasperPrintWindow;
        try {
            jasperPrintWindow = JasperFillManager.fillReport(
                    "Reportes/Reporte.jasper", null,conector.getConnection());
            JasperExportManager.exportReportToPdfFile(jasperPrintWindow, "Informe/informe.pdf");
            JasperViewer.viewReport(jasperPrintWindow, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
