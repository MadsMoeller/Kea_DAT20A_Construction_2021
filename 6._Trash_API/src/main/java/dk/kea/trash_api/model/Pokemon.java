package dk.kea.trash_api.model;

public class Pokemon {

    private String name;
    private int kantoPokedexNumber;

    public Pokemon() {
    }

    public Pokemon(String name, int kantoPokedexNumber) {
        this.name = name;
        this.kantoPokedexNumber = kantoPokedexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKantoPokedexNumber() {
        return kantoPokedexNumber;
    }

    public void setKantoPokedexNumber(int kantoPokedexNumber) {
        this.kantoPokedexNumber = kantoPokedexNumber;
    }

    @Override
    public String toString(){
        return "Pokemon: " + name + ", Kanto pokedex: " + kantoPokedexNumber;
    }
}
