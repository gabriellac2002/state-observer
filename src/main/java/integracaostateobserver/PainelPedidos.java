package integracaostateobserver;

public class PainelPedidos implements ObservadorPedido {

    private String codigoPedido;
    private String ultimoEstado;

    public void atualizar(EventoPedido evento) {
        this.codigoPedido = evento.codigoPedido();
        this.ultimoEstado = evento.novoEstado();
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getUltimoEstado() {
        return ultimoEstado;
    }
}
