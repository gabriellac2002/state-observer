package integracaostateobserver;

public record EventoPedido(String codigoPedido, String estadoAnterior, String novoEstado) {
}
