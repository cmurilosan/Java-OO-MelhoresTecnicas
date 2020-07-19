public class Cpf implements Documento{

    private String valor;

    public Cpf(String valor) {
        this.valor = valor;
    }

    public boolean ehValido() {
        return primeiroDigitoVerificador() == primeiroDigitoCorreto()
                && segundoDigitoVerificador() == segundoDigitoCorreto();
    }
    public String getValor() {
        return this.valor;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Cpf)) {
            return false;
        }
        Cpf outro = (Cpf) o;
        return this.valor.equals(outro.valor);
    }

    public int hashCode() {
        return this.valor.hashCode();
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
}
