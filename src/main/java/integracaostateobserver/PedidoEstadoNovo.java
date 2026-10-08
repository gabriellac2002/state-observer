package integracaostateobserver;

public class PedidoEstadoNovo extends PedidoEstado {

    public void aprovarPagamento(Pedido pedido) {
        pedido.alterarEstado(new PedidoEstadoPago());
    }

    public void cancelar(Pedido pedido) {
        pedido.alterarEstado(new PedidoEstadoCancelado());
    }

    public String getNome() {
        return "Novo";
    }
}
