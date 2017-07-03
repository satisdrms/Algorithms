package com.github.satisdrms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Design a musical juke box using object oriented principles

class Song {
	String songName;

	public String getSong() {
		return songName;
	}
}

class CDPlayer {
	PlayList p;
	CD cd;

	CDPlayer(PlayList p, CD cd) {
		this.p = p;
		this.cd = cd;
	}

	void playSong(Song s) {
		p.getNextsong();
	}

	void rePlaySong(Song s) {
		p.getCurSong();
	}
}

class PlayList {
	private Song currentSong;
	Queue<Song> queue = new LinkedList<Song>();

	public Song getCurSong() {
		return currentSong;
	}

	public Song getNextsong() {
		return queue.peek();
	}
	void queueUpSong(Song s){
		queue.add(s);
	}
}

class CD {
	Song song;

	Song readNextsong() {
		return song;
	}

	void loadNextSong(Song s) {
		song = s;
	}
}

class JukeBox {
	User u;
	CDPlayer cdpl;
	Set<CD> cdCollection;
	

}

class TrackSelector{
	Song cur;
	Song getCurSong(){
		return cur;
		
	}
}

class User {
	String Name;

	User(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

}

public class Topic_19_OOD_EX3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
