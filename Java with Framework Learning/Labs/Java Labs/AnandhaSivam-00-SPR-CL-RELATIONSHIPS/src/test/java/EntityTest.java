
import Lab.Model.Album;

import Lab.Model.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class EntityTest {
    /**
     * This test will pass when the Album entity has the proper relationship with the Artist entity.
     */
    @Test
    public void ManyToOneRelationshipTest() {
        Class<Album> albumClass = Album.class;
        Field[] fields = albumClass.getDeclaredFields();
        boolean annotationFound = false;
        for(Field f : fields) {
            if (f.getName().equals("artist") && f.getType().equals(Artist.class)) {
                Annotation[] annotations = f.getAnnotations();
                for (Annotation a : annotations) {
                    if (a.annotationType() == ManyToOne.class) {
                        annotationFound = true;
                    }
                }
            }
        }

        Assertions.assertTrue(annotationFound);
    }

    /**
     * This test will pass when the Album entity has the proper relationship with the Song entity.
     */
    @Test
    public void OneToManyRelationshipTest() {
        Class<Album> albumClass = Album.class;
        Field[] fields = albumClass.getDeclaredFields();
        boolean annotationFound = false;
        for(Field f : fields) {
            if (f.getName().equals("songs") && f.getType().equals(List.class)) {
                Annotation[] annotations = f.getAnnotations();
                for (Annotation a : annotations) {
                    if (a.annotationType() == OneToMany.class) {
                        annotationFound = true;
                    }
                }
            }
        }

        Assertions.assertTrue(annotationFound);
    }
}
