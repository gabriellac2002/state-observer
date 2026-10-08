package integracaostateobserver;

import java.util.Objects;

public class Cliente implements ObservadorPedido {

    private final String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = Objects.requireNonNull(nome, "O nome do cliente e obrigatorio");
    }

    public void atualizar(EventoPedido evento) {
        ultimaNotificacao = "Ola, " + nome + ": pedido " + evento.codigoPedido()
                + " mudou de " + evento.estadoAnterior() + " para " + evento.novoEstado();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
