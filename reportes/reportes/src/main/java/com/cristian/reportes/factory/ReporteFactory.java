package com.cristian.reportes.factory;

import com.cristian.reportes.implementation.ReporteCorreo;
import com.cristian.reportes.implementation.ReporteSMS;
import com.cristian.reportes.implementation.ReporteWhatsApp;
import com.cristian.reportes.interfaces.Reporte;

public class ReporteFactory {
    
    public static Reporte crearReporte(String tipo){
        
        if(tipo.equalsIgnoreCase("WHATSAPP")){
            return new ReporteWhatsApp();
        }
        if (tipo.equalsIgnoreCase("CORREO")){
            return new ReporteCorreo();
        }
        if (tipo.equalsIgnoreCase("SMS")) {
            return new ReporteSMS();
        }

        throw new  IllegalArgumentException("Tipo de reporte no valido");
    }
}
