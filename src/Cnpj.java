import java.util.Objects;

public class Cnpj implements Documento{

    private String valor;

    public Cnpj(String valor) {
        this.valor = valor;
    }

    public boolean ehValido() {
        return primeiroDigitoVerificador() == primeiroDigitoCorreto()
                && segundoDigitoVerificador() == segundoDigitoCorreto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cnpj cnpj = (Cnpj) o;
        return Objects.equals(valor, cnpj.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    private int primeiroDigitoCorreto() {
        // Extrai o primeiro dígito verificador do CNPJ armazenado
        // no atributo cnpj
        return 1;
    }
    private int primeiroDigitoVerificador() {
        // Extrai o segundo dígito verificador do CNPJ armazenado
        // no atributo cnpj
        return 1;
    }

    private int segundoDigitoCorreto() {
        // Calcula o primeiro dígito verificador correto para
        // o CNPJ armazenado no atributo cnpj
        return 2;
    }
    private int segundoDigitoVerificador() {
        // Calcula o primeiro dígito verificador correto para
        // o CNPJ armazenado no atributo cnpj
        return 2;
    }

    public String getValor() {

        return valor;
    }

    public void setValor(String novoValor) {

        this.valor = novoValor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
