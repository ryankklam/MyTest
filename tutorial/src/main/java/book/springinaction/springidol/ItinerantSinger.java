package book.springinaction.springidol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class ItinerantSinger implements Performer {

	ArrayList<ISong> knowSongs;// 歌曲list
	Map<ISong, String> albumnMap; // 歌曲 专辑名 map
	Properties authorPros; // 歌名 歌手 mapping

	public void perform() {
		Iterator<ISong> it = knowSongs.iterator();
		while (it.hasNext()) {
			ISong song = it.next();

			System.out.println(song.getTitle());
			System.out.println(authorPros.getProperty(song.getTitle()));
			System.out.println(albumnMap.get(song));

			song.sing();
		}

	}
	
	public ISong selectBestSong(){
		Random r = new Random();
		int index = r.nextInt(knowSongs.size());
		return knowSongs.get(index);
	}

	public ItinerantSinger() {
		super();
	}

	public ItinerantSinger(ArrayList<ISong> knowSongs) {
		super();
		this.knowSongs = knowSongs;
	}

	public ArrayList<ISong> getKnowSongs() {
		return knowSongs;
	}

	public void setKnowSongs(ArrayList<ISong> knowSongs) {
		this.knowSongs = knowSongs;
	}

	public void setAlbumnMap(Map<ISong, String> albumnMap) {
		this.albumnMap = albumnMap;
	}

	public void setAuthorPros(Properties authorPros) {
		this.authorPros = authorPros;
	}

}
