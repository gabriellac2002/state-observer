package integracaostateobserver;

// State: cada estado libera apenas as operacoes validas para aquele momento do pedido.
public abstract class PedidoEstado {

    public void aprovarPagamento(Pedido pedido) {
        throw acaoInvalida("aprovar pagamento", pedido);
    }

    public void enviar(Pedido pedido) {
        throw acaoInvalida("enviar", pedido);
    }

    public void entregar(Pedido pedido) {
        throw acaoInvalida("entregar", pedido);
    }

    public void cancelar(Pedido pedido) {
        throw acaoInvalida("cancelar", pedido);
    }

    public abstract String getNome();

    protected IllegalStateException acaoInvalida(String acao, Pedido pedido) {
        return new IllegalStateException(
                "Nao e possivel " + acao + " o pedido " + pedido.getCodigo()
                        + " quando ele esta " + getNome()
        );
    }
}
