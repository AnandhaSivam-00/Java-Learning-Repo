package Lab.Model;

public class Sample {
    Long id;
    String text;
    public Sample(Long id, String text){
        this.id = id;
        this.text = text;
    }
    public Sample(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
