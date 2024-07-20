public abstract class Item{
    private int id;
    private String nome;
    private String descricao;
    private int categoria;

    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getCategoria() {
        return categoria;
    }
    public Item(int id, String nome, String descricao, int categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public abstract void usarItem(Personagem personagem);


    public void adicionaItem(Personagem personagem){
        personagem.getItensEquipados().add(this);        
    }
}
