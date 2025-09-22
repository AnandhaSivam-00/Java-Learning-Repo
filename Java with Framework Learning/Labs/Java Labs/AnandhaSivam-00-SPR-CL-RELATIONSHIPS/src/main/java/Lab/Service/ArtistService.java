package Lab.Service;

import Lab.Model.Album;
import Lab.Model.Artist;
import Lab.Model.Song;
import Lab.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class used to demonstrate ORM functionality for related entities.
 * This leverages the stereotype annotation @Service, which is functionally the same as @Component.
 * There is no need to modify anything in this class.
 */
@Service
@Transactional
public class ArtistService {

    ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(Artist artist){
        return artistRepository.save(artist);
    }
    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    public Artist addAlbumToArtist(long artistId, Album album){
        Artist artist = artistRepository.findById(artistId).get();
        artist.getAlbums().add(album);
        artistRepository.save(artist);
        return artist;
    }

}
