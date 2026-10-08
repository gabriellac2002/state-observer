package integracaostateobserver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PedidoTest {

    @Test
    void deveAlterarEstadoENotificarOsObservadores() {
        Pedido pedido = new Pedido("PED-500");
        Cliente cliente = new Cliente("Ana");
        PainelPedidos painel = new PainelPedidos();
        pedido.adicionarObservador(cliente);
        pedido.adicionarObservador(painel);

        pedido.aprovarPagamento();

        assertEquals("Pago", pedido.getEstado());
        assertEquals("Ola, Ana: pedido PED-500 mudou de Novo para Pago",
                cliente.getUltimaNotificacao());
        assertEquals("PED-500", painel.getCodigoPedido());
        assertEquals("Pago", painel.getUltimoEstado());
    }

    @Test
    void deveNotificarComONovoEstadoEmCadaTransicao() {
        Pedido pedido = new Pedido("PED-501");
        PainelPedidos painel = new PainelPedidos();
        pedido.adicionarObservador(painel);

        pedido.aprovarPagamento();
        pedido.enviar();
        pedido.entregar();

        assertEquals("Entregue", pedido.getEstado());
        assertEquals("Entregue", painel.getUltimoEstado());
    }

    @Test
    void naoDeveNotificarObservadorRemovido() {
        Pedido pedido = new Pedido("PED-502");
        Cliente cliente = new Cliente("Bruno");
        pedido.adicionarObservador(cliente);
        pedido.removerObservador(cliente);

        pedido.aprovarPagamento();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void naoDevePermitirTransicaoInvalida() {
        Pedido pedido = new Pedido("PED-503");

        assertThrows(IllegalStateException.class, pedido::enviar);
        assertEquals("Novo", pedido.getEstado());
    }
}
