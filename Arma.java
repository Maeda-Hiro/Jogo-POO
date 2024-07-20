public class Arma extends Item {
    private int dano;
    private int restricaDeClasse;
    
    public Arma(int id, String nome, String descricao, int categoria, int restricaDeClasse, int dano) {
        super(id, nome, descricao, categoria);
        this.restricaDeClasse = restricaDeClasse;
        this.dano = dano;
    }
    
    public int getDano() {
        return dano;
    }
    public int getRestricaDeClasse() {
        return restricaDeClasse;
    }

    @Override
    public void usarItem(Personagem personagem){
        int dano= 0;

        for (int i = 0; i < personagem.getItensEquipados().size(); i ++){
            if(personagem.getItensEquipados().get(i).getCategoria() == 1){
                
                Item itemSelecionado = personagem.getListaDeItens().get(i);
                if (itemSelecionado.getCategoria() == 1) { 
                    Arma armaSelecionada = (Arma) itemSelecionado;
                    dano = armaSelecionada.getDano();  
                    personagem.setForca(personagem.getForca() - dano);
                    personagem.getListaDeItens().add(personagem.getItensEquipados().get(i));
                    personagem.getItensEquipados().remove(personagem.getItensEquipados().get(i));
                }
                break;
            }
        }
        personagem.getListaDeItens().remove(this);
        personagem.getItensEquipados().add(this);
        System.out.println("*** " + super.getNome() + " foi equipado ***");
        personagem.setForca(personagem.getForca() + this.getDano());
    }

    
}