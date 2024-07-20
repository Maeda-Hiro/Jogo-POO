public abstract class Monstro{
    private String nome;
    private int saude;
    private int energia;
    private int forca;
    private int habilidade;
    private int defesa;
    private int x;
    private int y;

    public abstract String getNome();

    public abstract void setNome(String nome);

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

    public abstract int getX();

    public abstract int getY();

    public abstract void atacar(Personagem personagem);
    
    public abstract void drop(Personagem personagem);
    
}
  