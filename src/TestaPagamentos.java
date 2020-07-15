import java.util.ArrayList;

public class TestaPagamentos {

    public static void main(String[] args) {

        Pagamentos pagamentos = new Pagamentos();
        Pagamento pagamento1 = new Pagamento();
        Pagamento pagamento2 = new Pagamento();
        pagamento1.setValor(105);
        pagamento2.setValor(25);

        pagamentos.add(pagamento1);
        pagamentos.add(pagamento2);

        System.out.println("Valor total pago: " + pagamentos.getValorPago());

        Pagamentos pagamentos2 = new Pagamentos();
        ArrayList<Pagamento> colecaoDePagamentos = new ArrayList<>();
        colecaoDePagamentos.add(pagamento1);
        colecaoDePagamentos.add(pagamento2);
        pagamentos2.addAll(colecaoDePagamentos);

        System.out.println("Valor total pago: " + pagamentos2.getValorPago());
    }
}
