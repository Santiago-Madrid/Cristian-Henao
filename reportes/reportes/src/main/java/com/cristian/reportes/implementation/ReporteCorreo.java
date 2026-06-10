package com.cristian.reportes.implementation;

import com.cristian.reportes.interfaces.Reporte;

public class ReporteCorreo implements Reporte {
    
    @Override
    public String generarReporte() {
        return "Generando reporte en formato Correo";
    }
    
}
