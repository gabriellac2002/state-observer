package integracaostateobserver;

public class ExemploIntegracao {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-500");
        Cliente cliente = new Cliente("Ana");
        PainelPedidos painel = new PainelPedidos();

        pedido.adicionarObservador(cliente);
        pedido.adicionarObservador(painel);

        pedido.aprovarPagamento();
        pedido.enviar();
        pedido.entregar();

        System.out.println(cliente.getUltimaNotificacao());
        System.out.println("Painel: pedido " + painel.getCodigoPedido()
                + " esta " + painel.getUltimoEstado());
    }
}
