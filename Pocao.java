import java.util.ArrayList;
import java.util.Scanner;

public class Pocao extends Item {
    private int tipo;
    private int valorEfeito;
    public Pocao(int id, String nome, String descricao, int categoria, int tipo, int valorEfeito) {
        super(id, nome, descricao, categoria);
        this.tipo = tipo;
        this.valorEfeito = valorEfeito;
    }
    public int getTipo() {
        return tipo;
    }

    public void usarItem(Personagem personagem){
        
        if(this.tipo == 1){ // cura saude
            personagem.setSaude(personagem.getSaude() + this.valorEfeito);
            System.out.println("*** " + this.getNome() + " foi utilizado ***");
        
        }else if(this.tipo == 2){ //energia restaura energia
            personagem.setEnergia(personagem.getEnergia() + this.valorEfeito);
            System.out.println("*** " + this.getNome() + " foi utilizado ***");
        
        }else if(this.tipo == 3){ // aumenta dano
            personagem.setForca(personagem.getForca() + this.valorEfeito);
            System.out.println("*** " + this.getNome() + " foi utilizado ***");
       
        }else if(this.tipo == 4){ //aumenta defesa
            personagem.setDefesa(personagem.getDefesa() + this.valorEfeito);
            System.out.println("*** " + this.getNome() + " foi utilizado ***");
        }else if(this.tipo == 5){ //aumenta habilidade
            personagem.setHabilidade(personagem.getHabilidade() + this.valorEfeito);
            System.out.println("*** " + this.getNome() + " foi utilizado ***");
        }
        personagem.getListaDeItens().remove(this);
    }


}