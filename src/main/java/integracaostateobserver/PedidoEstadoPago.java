package integracaostateobserver;

public class PedidoEstadoPago extends PedidoEstado {

    public void enviar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEstadoEnviado());
    }

    public void cancelar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEstadoCancelado());
    }

    public String getNome() {
        return "Pago";
    }
}
