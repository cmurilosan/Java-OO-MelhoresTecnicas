import java.io.File;

public class Arquivo implements ArmazenadorDeDivida{

    private File arquivo;

    @Override
    public void salva(Divida divida) {
        // grava no arquivo
    }

    @Override
    public Divida carrega(Documento documentoCredor) {
        // procura a divida no arquivo e a devolve
        return null;
    }
}
