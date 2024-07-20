public class Armadura extends Item {
    private int defesa;
    
    public Armadura(int id, String nome, String descricao, int categoria, int defesa) {
        super(id, nome, descricao, categoria);
        this.defesa = defesa;
    }
    public int getDefesa() {
        return defesa;
    }

    @Override
    public void usarItem(Personagem personagem){
        int defesa= 0;

        for (int i = 0; i < personagem.getItensEquipados().size(); i ++){

            if(personagem.getItensEquipados().get(i).getCategoria() == 2){
                Item itemSelecionado = personagem.getListaDeItens().get(i);
                if (itemSelecionado.getCategoria() == 2) { 
                    Armadura armaduraSelecionada = (Armadura) itemSelecionado;
                    defesa = armaduraSelecionada.getDefesa();  
                    personagem.setDefesa(personagem.getDefesa() - defesa);
                    personagem.getListaDeItens().add(personagem.getItensEquipados().get(i));
                    personagem.getItensEquipados().remove(personagem.getItensEquipados().get(i));
                }
                break;
            }
        }
        personagem.getListaDeItens().remove(this);
        personagem.getItensEquipados().add(this);
        System.out.println("*** " + super.getNome() + " foi equipado ***");
        personagem.setDefesa(personagem.getDefesa() + this.getDefesa());
        personagem.setDefesaAux(personagem.getDefesa());
    }

    
}