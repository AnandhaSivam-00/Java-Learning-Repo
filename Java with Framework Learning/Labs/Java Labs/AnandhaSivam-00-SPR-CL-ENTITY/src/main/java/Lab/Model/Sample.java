package Lab.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is an example of what a valid ORM Entity would look like. The @Entity annotation informs Spring to relate this
 * class to a database table. The @Id annotation establishes the primary key of the database table.
 *
 * No changes need to be made in this example. Product.java will need to modified to be an entity similar to this one.
 */
@Entity
public class Sample {
    @Id
    private long sampleID;
    private String text;

    public Sample(long sampleID, String text) {
        this.sampleID = sampleID;
        this.text = text;
    }

    public Sample(){

    }

    public long getSampleID() {
        return sampleID;
    }

    public void setSampleID(long sampleID) {
        this.sampleID = sampleID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
