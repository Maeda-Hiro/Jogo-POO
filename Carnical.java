import java.util.ArrayList;

public class Carnical extends Monstro{
    private String nome;
    private int saude;
    private int energia;
    private int forca;
    private int habilidade;
    private int defesa;
    private int x;
    private int y;
    // private int nivel;

    public Carnical(String nome, int saude, int energia, int forca, int habilidade, int defesa, int x, int y) {
        this.nome = nome;
        this.saude = saude;
        this.energia = energia;
        this.forca = forca;
        this.habilidade = habilidade;
        this.defesa = defesa;
        this.x = x;
        this.y = y;
        // this.nivel = nivel;
    }   

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getSaude() {
        return saude;
    }
    public void setSaude(int saude) {
        this.saude = saude;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public int getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void atacar(Personagem personagem){
        String ataque = "";
        int defesa = personagem.getDefesa();
        int habilidade = (int) (Math.random() * 2) + 1;
        int danoSofrido = 0;
        int forca = 0;

        switch (habilidade) {
            case 1:
                ataque = "Investida";
                forca = this.habilidade * 3;
                danoSofrido = forca;

                if(danoSofrido >= 0){
                    personagem.setSaude(personagem.getSaude() - danoSofrido);
                }
                personagem.setMeuTurno(true);
                break;
            case 2:
                if(this.energia - 20 >= 0){
                    ataque = "Mordida";
                    forca = this.forca * 2;
                    danoSofrido = forca - defesa;
                    
                    if(danoSofrido > 0){
                        personagem.setSaude(personagem.getSaude() - danoSofrido);
                    }
                    this.energia -= 20;
                    personagem.setMeuTurno(true);
                    break;
                }else {
                    ataque = "Investida";
                    forca = this.habilidade * 3;
                    danoSofrido = forca;
    
                    if(danoSofrido >= 0){
                        personagem.setSaude(personagem.getSaude() - danoSofrido);
                    }
                    personagem.setMeuTurno(true);
                    break;
                }
        }

        if (danoSofrido > 0){
            System.out.println("\n*** " + this.getNome() + " realizou o ataque " + ataque + " ***");
            System.out.println("Status do Personagem: " + personagem.getNome());
            System.out.println("--Saude.....: " + personagem.getSaude());
            System.out.println("--Energia...: " + personagem.getEnergia());
            System.out.println("--Forca.....: " + personagem.getForca());
            System.out.println("--Habilidade: " + personagem.getHabilidade());
            System.out.println("--Defesa....: " + personagem.getDefesa());
        }
    }

    public void drop(Personagem personagem){
        ArrayList <Item> itensDrop = new ArrayList<>();
        Pocao elixirCarnical = new Pocao(4, "Elixir de Carnical", "Aumenta sua forca em 4 pontos", 3, 3, 4);
        Pocao pocaoCura1 = new Pocao(5, "Pocao de cura", "Restaura sua saude em 60 pts", 3, 1, 60);
        Pocao pocaoEnergia = new Pocao(6, "Pocao de Energia", "Restaura sua energia em 30 pts", 3, 2, 30);
        itensDrop.add(elixirCarnical);
        itensDrop.add(pocaoCura1);
        itensDrop.add(pocaoEnergia);
        
        for (int i = 0; i < itensDrop.size(); i++){
            System.out.println("*** " + itensDrop.get(i).getNome() + " adicionado ao seu inventario ***");   
        }
        itensDrop.addAll(personagem.getListaDeItens());
        personagem.setListaDeItens(itensDrop);
    }
}