import java.util.ArrayList;
import java.util.Scanner;

public abstract class Personagem{
    public abstract String getNome();

    public abstract int getSaude();

    public abstract void setSaude(int saude);
   
    public abstract int getEnergia();
   
    public abstract void setEnergia(int energia);
   
    public abstract int getForca();
   
    public abstract void setForca(int forca);

    public abstract int getHabilidade();
    
    public abstract void setHabilidade(int habilidade);
   
    public abstract int getDefesa();
   
    public abstract void setDefesa(int defesa);

    public abstract void setDefesaAux(int defesa);
   
    public abstract int getX();
   
    public abstract int getY();
   
    public abstract void setMeuTurno(boolean meuTurno);
   
    public abstract ArrayList<Item> getListaDeItens();
   
    public abstract void setListaDeItens(ArrayList<Item> listaDeItens);
   
    public abstract ArrayList<Item> getItensEquipados();
   
    public abstract void setItensEquipados(ArrayList<Item> itensEquipados);

    public abstract int mostraItens(Scanner sc);

    public abstract void criacaoDePersonagem(Scanner sc);

    public abstract void salvarPersonagem(String nome, int saude, int energia, int forca, int habilidade, int defesa, Scanner sc);

    public abstract void atacar(Monstro monstro);
    
    public abstract void acoesDeCombate(Monstro monstro, Scanner sc);

    public abstract boolean combate(Monstro monstro, Scanner sc);

    public abstract void movimentar(Scanner sc);
}