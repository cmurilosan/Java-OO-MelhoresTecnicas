import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioDeDivida {

    private Divida divida;

    public RelatorioDeDivida(Divida divida) {
        this.divida = divida;
    }

    public void geraRelatorio(NumberFormat formatador) {
        System.out.println("Cnpj credor: " + divida.getDocumentoCredor());
        System.out.println("Credor: " + divida.getCredor());

        // agora utilizamos o formatadorDeNumero recebido como parâmetro do método
        System.out.println("Valor da dívida: " + formatador.format(divida.getTotal()));
        System.out.println("Valor pago: " + formatador.format(divida.getValorPago()));
    }

    public static void main(String[] args) {

        Divida divida = new Divida();
        divida.setCredor("Uma empresa");
        divida.setTotal(100);
        divida.setDocumentoCredor(new Cnpj("00.000.001/0001-01"));

        Pagamento pagamento = new Pagamento();
        pagamento.setCnpjPagador("00.000.002/0002-02");
        pagamento.setPagador("Outra empresa");
        pagamento.setValor(20);
        divida.registra(pagamento);

        RelatorioDeDivida relatorio = new RelatorioDeDivida(divida);
        // temos uma formatação que usa os padrões brasileiros
        NumberFormat formatadorBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        // geramos o relatório com o formatador brasileiro
        relatorio.geraRelatorio(formatadorBrasileiro);

        System.out.println("------------------------------------------------------");

        // temos agora uma formatação que usa os padrões dos Estados Unidos
        NumberFormat formatadorAmericano = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        // e agora com o formatador americano na mesma instância de RelatorioDeDivida
        relatorio.geraRelatorio(formatadorAmericano);
    }
}
