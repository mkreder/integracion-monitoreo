package com.monitor.webServiceInterface;

import vos.VoCarrito;
import vos.VoVenta;

public interface IWSProcVenta {

	String procesarVenta(VoVenta venta);

	String procesarCarrito(VoCarrito carrito);

}
