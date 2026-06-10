package com.cristian.reportes.service;

import org.springframework.stereotype.Service;

import com.cristian.reportes.factory.ReporteFactory;
import com.cristian.reportes.interfaces.Reporte;

@Service
public class ReporteService {
    
    public String generarReporte(String tipo){
        
        Reporte reporte = ReporteFactory.crearReporte(tipo);

        return reporte.generarReporte();
    }
}
