package mx.edu.utng.recorridos.models;

/**
 * Created by Toshiba on 15/02/2018.
 */
public class Museum {
    public String name;
    public int image;

    public Museum() {

    }

    public Museum(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int poster) {
        this.image = poster;
    }
}
