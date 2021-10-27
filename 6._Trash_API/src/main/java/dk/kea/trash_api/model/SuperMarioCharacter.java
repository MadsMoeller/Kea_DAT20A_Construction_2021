package dk.kea.trash_api.model;

public class SuperMarioCharacter {

    private String name;

    public SuperMarioCharacter(){}

    public SuperMarioCharacter(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
