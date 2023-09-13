package com.irs.swingexamples.models.indicadores;

import java.util.Arrays;
import java.util.List;

/**
 * Representa un objeto con los datos (indicadores y tipos de indicadores).
 *
 * @author IRS
 * @version 1.0.0, 25/06/2007
 */
public class DAOIndicadores {
    static TipoIndicadorVO[] TIPOS_INDICADOR = {
            new TipoIndicadorVO(1, "Servicios Internos Tiempos de Respuesta"),
            new TipoIndicadorVO(2, "Servicios Internos Disponibilidad"),
            new TipoIndicadorVO(3, "Datos de Producción"),
            new TipoIndicadorVO(4, "Ratios Económicos"),
            new TipoIndicadorVO(5, "Indicadores de nivel de Servicio SLA"),
            new TipoIndicadorVO(6, "Indicadores para Consejo de Administración"),
            new TipoIndicadorVO(9, "Indicadores Sistemas")
    };

    static IndicadorVO[] INDICADORES = new IndicadorVO[] {
            new IndicadorVO(6, "Cifra de Negocio CERES 2003", 4),
            new IndicadorVO(8, "Facturación Realizada", 4),
            new IndicadorVO(11, "Tiempo medio de puesta a disposición de certificados", 6),
            new IndicadorVO(16, "Disponibilidad Registro SSL", 6),
            new IndicadorVO(17, "Disponibilidad Web Ceres", 6),
            new IndicadorVO(10, "Disponibilidad de los servicios", 6),
            new IndicadorVO(18, "Disponibilidad Web CGN", 6),
            new IndicadorVO(19, "Disponibilidad Web FNMT", 6),
            new IndicadorVO(26, "Tiempo de Respuesta Registro SSL", 2),
            new IndicadorVO(27, "Tiempo de Respuesta Web Ceres", 2)
    };

    public static List findTiposIndicador(){
        return Arrays.asList(TIPOS_INDICADOR);
    }

    public static List findIndicadores(){
        return Arrays.asList(INDICADORES);
    }
}
