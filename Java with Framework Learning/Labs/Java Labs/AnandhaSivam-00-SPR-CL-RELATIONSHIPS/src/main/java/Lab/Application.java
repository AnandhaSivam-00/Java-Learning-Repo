package Lab;

import Lab.Model.Album;
import Lab.Model.Artist;
import Lab.Model.Song;
import Lab.Service.AlbumService;
import Lab.Service.ArtistService;
import Lab.Service.SongService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);

        // get my beans
        AlbumService albumService = applicationContext.getBean(AlbumService.class);
        ArtistService artistService = applicationContext.getBean(ArtistService.class);
        SongService songService = applicationContext.getBean(SongService.class);

        // create some artists
        Artist ar1 = artistService.addArtist(new Artist("artist 1"));
        Artist ar2 = artistService.addArtist(new Artist("artist 2"));

        // create some albums
        Album al1 = albumService.addAlbum(new Album("album 1"));
        Album al2 = albumService.addAlbum(new Album("album 2"));

        // create some songs
        Song s1 = songService.addSong(new Song("song 1"));
        Song s2 = songService.addSong(new Song("song 2"));

        // attach the songs to an album
        albumService.addSongToAlbum(al1.getAlbumId(), s1);
        albumService.addSongToAlbum(al1.getAlbumId(), s2);
        System.out.println(songService.getAllSongs());
        System.out.println(albumService.getAllAlbums());
    }
}
