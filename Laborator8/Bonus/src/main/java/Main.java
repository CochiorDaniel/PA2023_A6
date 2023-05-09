import DataAcces.*;
import ObjModel.Album;
import ObjModel.Playlists;
import com.github.javafaker.Faker;
import org.graph4j.*;
import org.graph4j.alg.clique.BronKerboschCliqueIterator;
import org.graph4j.util.Clique;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
     public static AlbumDAO albums = new AlbumDAO();
     public static Faker faker = new Faker();


    public static void main(String[] args) throws SQLException {

        List<Album> albumsList = albums.findAll();

        Graph<Album, Edge<Album>> graph = GraphBuilder.labeledVertices(albumsList).buildGraph();

        List<Playlists> playlistsList = new ArrayList<>();

        for(Album a1: albumsList){
            for(Album a2: albumsList){
                if(!graph.containsEdge(graph.findVertex(a1), graph.findVertex(a2)) && !a1.equals(a2))
                    if(compatibil(a1,a2)){
                        graph.addEdge(a1, a2);
                    }
            }
        }

        BronKerboschCliqueIterator playList = new BronKerboschCliqueIterator(graph);

        System.out.println(playList.next());

        while (playList.hasNext()){
            Clique k = playList.next();
            int [] vertices = k.vertices();
            System.out.println();
            System.out.println("Playlist :");
            List<Album> albumsss = new ArrayList<>();
            for(int i=0; i<vertices.length; i++){
                System.out.println(graph.getVertexLabel(vertices[i]).getName());
                albumsss.add(graph.getVertexLabel(vertices[i]));
            }
            playlistsList.add(new Playlists(faker.book().title(),new Timestamp(new Date().getTime()), albumsss));
        }

        //System.out.println(graph.edges().length);
    }

    public static boolean compatibil(Album a, Album b){
        if(a.getRelease_year() == b.getRelease_year())
            return false;
        if(a.getArtist().equals(b.getArtist()))
            return false;
        if(a.getGenre().equals(b.getGenre()))
            return false;
        return true;
    }
}
