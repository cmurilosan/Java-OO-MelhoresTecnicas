public class GerenciadorDeDividas {

    public void efetuaPagamento(Divida divida, double valor, String nomePagador, String cnpjPagador) {
        Pagamento pagamento = new Pagamento();
        pagamento.setCnpjPagador(cnpjPagador);
        pagamento.setPagador(nomePagador);
        pagamento.setValor(valor);
        divida.paga(valor);
        divida.registra(pagamento);
    }
}
