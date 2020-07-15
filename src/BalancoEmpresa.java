import java.util.HashMap;

public class BalancoEmpresa {

    private HashMap<String, Divida> dividas = new HashMap<>();

    public void registraDivida(String credor, String cnpjCredor, double valor) {
        Divida divida = new Divida();
        divida.setTotal(valor);
        divida.setCredor(credor);
        divida.getCnpjCredor().setValor(cnpjCredor);    // agora usamos o getter e depois o setter
        dividas.put(cnpjCredor, divida);
    }

    public void pagaDivida(String cnpjCredor, double valor, String nomePagador, String cnpjPagador) {
        Divida divida = dividas.get(cnpjCredor);
        if (divida != null) {
            Pagamento pagamento = new Pagamento();
            pagamento.setCnpjPagador(cnpjPagador);
            pagamento.setPagador(nomePagador);
            pagamento.setValor(valor);
            divida.getPagamentos().registra(pagamento);
        }
    }
}
