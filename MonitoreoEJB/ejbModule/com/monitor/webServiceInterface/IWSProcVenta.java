package com.monitor.webServiceInterface;

import vos.ResultadoDTO;
import vos.VentaDTO;

public interface IWSProcVenta {

	


	String notificarCarrito(String notificacion);



	ResultadoDTO notificarVenta(VentaDTO venta);

}
