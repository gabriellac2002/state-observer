package integracaostateobserver;

public class PedidoEstadoEnviado extends PedidoEstado {

    public void entregar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEstadoEntregue());
    }

    public String getNome() {
        return "Enviado";
    }
}
