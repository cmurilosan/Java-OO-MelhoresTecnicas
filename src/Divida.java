import java.util.ArrayList;
import java.util.Calendar;

public class Divida {

    private double total;
    private double valorPago;
    private String credor;
    private String cnpjCredor;
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();

    public boolean cnpjValido() {
        return primeiroDigitoVerificadorDoCnpj() == primeiroDigitoCorretoParaCnpj()
                && segundoDigitoVerificadorDoCnpj() == segundoDigitoCorretoParaCnpj();
    }

    private void paga(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor invalido para pagamento");
        }
        if (valor > 100) {
            valor = valor - 8;
        }
        this.valorPago += valor;
    }

    public void registra(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
        this.paga(pagamento.getValor());
    }

    public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getData().before(data)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getValor() > valorMinimo) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    private int primeiroDigitoCorretoParaCnpj() {
        // Extrai o primeiro dígito verificador do CNPJ armazenado
        // no atributo cnpj
    }
    private int primeiroDigitoVerificadorDoCnpj() {
        // Extrai o segundo dígito verificador do CNPJ armazenado
        // no atributo cnpj
    }

    private int segundoDigitoCorretoParaCnpj() {
        // Calcula o primeiro dígito verificador correto para
        // o CNPJ armazenado no atributo cnpj
    }
    private int segundoDigitoVerificadorDoCnpj() {
        // Calcula o primeiro dígito verificador correto para
        // o CNPJ armazenado no atributo cnpj
    }

    public double valorAPagar() {
        return this.total - this.valorPago;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getCnpjCredor() {
        return cnpjCredor;
    }

    public void setCnpjCredor(String cnpjCredor) {
        this.cnpjCredor = cnpjCredor;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

}

/*Repare também na quantidade de responsabilidades distintas da classe Divida:
registrar pagamentos, aplicar descontos em pagamentos quando aplicáveis, filtrar os pagamentos já realizados,
validar CNPJ, dentre outras. Quando uma classe tem muitas responsabilidades com pouca ou nenhuma relação entre si,
dizemos que ela não é coesa.
 */
