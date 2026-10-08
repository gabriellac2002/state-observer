package integracaostateobserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Context do State e Subject do Observer.
public class Pedido implements PedidoObservado {

    private final String codigo;
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private PedidoEstado estado = new PedidoEstadoNovo();

    public Pedido(String codigo) {
        this.codigo = Objects.requireNonNull(codigo, "O codigo do pedido e obrigatorio");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado.getNome();
    }

    void alterarEstado(PedidoEstado novoEstado) {
        String estadoAnterior = estado.getNome();
        this.estado = Objects.requireNonNull(novoEstado, "O novo estado e obrigatorio");
        notificarObservadores(new EventoPedido(codigo, estadoAnterior, estado.getNome()));
    }

    public void aprovarPagamento() {
        estado.aprovarPagamento(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(Objects.requireNonNull(observador, "O observador e obrigatorio"));
    }

    public void removerObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(EventoPedido evento) {
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(evento);
        }
    }
}
