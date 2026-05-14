import java.util.ArrayList;
import java.util.Arrays;

class Producto {

    public String nombPrd;
    public double precio;
    public int cantidad;

    public Producto(String nombPrd, double precio, int cantidad) {
        this.nombPrd = nombPrd;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String nombPrd, int cantidad) {
        this.nombPrd = nombPrd;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

    public String getNombPrd() {
        return nombPrd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombPrd=" + nombPrd + ", precio=" + precio + ", cantidad=" + cantidad + "}\n";
    }
}
class Carrito {

    public ArrayList<Producto> productosStop;
    public ArrayList<Producto> productosCarrito;
    public double descuento, total;

    public Carrito(ArrayList<Producto> productosStop, double descuento) {
        this.productosStop = productosStop;
        this.descuento = descuento;
        productosCarrito = new ArrayList();
    }

    public String agregarProducto(Producto producto) {
        boolean existeProd = false;
        boolean cantSufi = false;
        String msj = producto.nombPrd + " no se agregó porque no existe!!!";
        for (int i = 0; i < productosStop.size(); i++) {
            if (this.productosStop.get(i).getNombPrd().equals(producto.nombPrd)) {
                existeProd = true;
                int stock = this.productosStop.get(i).getCantidad();
                if (stock >= producto.cantidad) {
                    cantSufi = true;
                } else {
                    cantSufi = false;
                }
                break;
            }
        }
        if (existeProd && cantSufi) {
            productosCarrito.add(producto);
            msj = producto.nombPrd + " se agregó al carrito!!!";
        } else if (existeProd && !cantSufi) {
            msj = "No hay suficiente stock de: "
                    + producto.nombPrd;
        }
        return msj;
    }
    public double calcularTotal() {
        for (int i = 0; i < productosCarrito.size(); i++) {
            this.total += (this.productosStop.get(i).getPrecio() * this.productosCarrito.get(i).getCantidad());
        }
        return this.total;
    }
    public String realizarPago(double dinero) {
        String msj = "Compra exitosa. ";
        if (dinero >= this.total) {
            for (int i = 0; i < productosCarrito.size(); i++) {
                for (int j = 0; j < productosStop.size(); j++) {
                    if (this.productosStop.get(j).getNombPrd().equals(this.productosCarrito.get(i).getNombPrd())) {
                        this.productosStop.get(j).setCantidad(this.productosStop.get(j).getCantidad() - this.productosCarrito.get(i).getCantidad());
                        break;
                    }
                }
            }
            if (this.total > 1000) {
            double desc = this.total * (this.descuento / 100);
            msj += "Descuento: " + desc;
            total -= desc;
        }
        msj += ". Factura total: " + total;
    } else {
        double falta = this.total - dinero;
        msj = "Dinero insuficiente!!! "
                + "Te faltan: " + falta;
    }
    return msj;
}
    @Override
    public String toString() {
        return "Carrito{" + "productosStop=" + productosStop + ", productosCarrito=" + productosCarrito + ", descuento=" + descuento + ", total=" + total + '}';
    }
}
public class Problema1_Carrito_Arieltorres844 {
    public static void main(String[] args) {
        ArrayList<Producto> productosStop = new ArrayList<>(Arrays.asList(
                new Producto("iPhone18", 1500, 5),
                new Producto("iPad", 1200, 5),
                new Producto("Audifono", 200, 14)
        ));
        Carrito carrito1 = new Carrito(productosStop, 10);
        System.out.println("************ STOP ************");
        System.out.println(carrito1.productosStop);

        System.out.println("************ CARRITO CON PRODUCTOS ************");
        System.out.println("Agregar producto: " + carrito1.agregarProducto(new Producto("iPhone18", 6)));
        System.out.println(carrito1.productosCarrito);
        System.out.println("Agregar producto: " + carrito1.agregarProducto(new Producto("Lapiz", 2)));
        System.out.println("Total compra: " + carrito1.calcularTotal());
        System.out.println(carrito1.realizarPago(1000));
    }
}
