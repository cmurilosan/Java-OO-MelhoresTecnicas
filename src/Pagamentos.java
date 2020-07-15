import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Pagamentos extends ArrayList<Pagamento> {

    private double valorPago;

    public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getData().before(data)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getValor() > valorMinimo) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this) {
            if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public double getValorPago() {

        return valorPago;
    }

    public void registra(Pagamento pagamento) {
        this.add(pagamento);
        this.paga(pagamento.getValor());
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

    @Override
    public boolean add(Pagamento e) {
        this.paga(e.getValor());
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends Pagamento> c) {
        for(Pagamento pagamento : c) {
            this.paga(pagamento.getValor());
        }
        return super.addAll(c);
    }
}
