public interface ArmazenadorDeDivida {

    void salva(Divida divida);
    Divida carrega(Documento documentoCredor);

}
