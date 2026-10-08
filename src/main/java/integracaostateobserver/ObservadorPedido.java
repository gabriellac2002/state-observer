package integracaostateobserver;

// Observer: recebe cada transicao de estado concluida pelo pedido.
public interface ObservadorPedido {

    void atualizar(EventoPedido evento);
}
