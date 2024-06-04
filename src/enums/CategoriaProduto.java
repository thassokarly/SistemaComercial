package enums;

public enum CategoriaProduto {
    ALIMENTO("alimento"),
    TECNOLOGIA("tecnologia"),
    ROUPA("roupa");

    private String categoria;

    CategoriaProduto(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
