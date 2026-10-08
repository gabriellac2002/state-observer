package integracaostateobserver;

public interface PedidoObservado {

    void adicionarObservador(ObservadorPedido observador);

    void removerObservador(ObservadorPedido observador);

    void notificarObservadores(EventoPedido evento);
}
