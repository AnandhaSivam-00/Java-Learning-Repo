package Application.Repository;

import Application.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This class will navigate you through the process of writing your own custom queries in a JpaRepository, using
 * Spring's query language, JPQL. JPQL has the advantage of not only abstracting away boilerplate logic by directly
 * mapping queries to your ORM entities, but is also vendor-agnostic - meaning that your JPQL query does not change
 * between, for example, using an actual PostgresSQL, Oracle, or MySQL database.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    /**
     * This query is written in Spring Data's query language providing - JPQL, or Java Persistence Query Language.
     * You can notice here that the process of writing a query looks similar to a SQL statement, although the SELECT
     * keyword may be absent. When the SELECT keyword is absent, JPQL will convert rows of the ResultSet directly
     * into the model class that the Repository is built for, in this case, Pet. We've chosen to use List<Pet> as the
     * return type here to account for pets of the same name, but using the singular Pet return type will work as well.
     *
     * The Pet entity used will be found in the Model package. You should review the entity to know which fields
     * you will be querying.
     *
     * @param name the name of the pet.
     * @return All pets with the name provided as the parameter.
     */
    @Query("FROM Pet WHERE name = :nameVar")
    List<Pet> example1(@Param("nameVar") String name);

    /**
     * As you can see here, JPQL follows the same structure as you've already seen in SQL clauses, including where
     * and/or, order by, group by, limit, as well as subqueries.
     *
     * @param name the name of the pet.
     * @return All pets with the name provided as the parameter.
     */
    @Query("FROM Pet WHERE name = :nameVar AND species = :speciesVar")
    List<Pet> example2(@Param("nameVar") String name, @Param("speciesVar") String species);

    /**
     * If we include the SELECT statement, we can directly retrieve specific data from the table, which is in this
     * case useful for retrieving an aggregate value.
     */
    @Query("SELECT MAX(age) FROM Pet")
    int example3();

    /**
     * TODO: Retrieve all pets by their species.
     * Replace 'FROM Pet' with the necessary query and add Param annotations. 'FROM Pet' is present to allow the app
     * to initially compile.
     * @param species
     */
    @Query(value = "SELECT * FROM Pet WHERE species = :species", nativeQuery = true)
    List<Pet> lab1(@Param("species") String species);

    /**
     * TODO: Retrieve all pets by either their name OR their age.
     * Replace 'FROM Pet' with the necessary query and add Param annotations. 'FROM Pet' is present to allow the app
     * to initially compile.
     */
    @Query(value = "SELECT * FROM Pet WHERE name = :name OR age = :age", nativeQuery = true)
    List<Pet> lab2(@Param("name") String name, @Param("age") int age);

    /**
     * TODO: Retrieve the AVERAGE age of all pets.
     * Replace 'FROM Pet' with the necessary query and add Param annotations. 'FROM Pet' is present to allow the app
     * to initially compile.
     */
    @Query("SELECT AVG(age) FROM Pet")
    double lab3();

}
