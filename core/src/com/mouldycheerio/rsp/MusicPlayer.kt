package com.mouldycheerio.rsp

import java.io.FilenameFilter
import java.util.HashMap
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.files.FileHandle
import java.io.File
import com.badlogic.gdx.assets.AssetManager

class MusicPlayer {
	private val list = HashMap<String, Sound>()

	fun init() {
		list.put("audio", Gdx.audio.newSound( Gdx.files.internal("music/audio.mp3")));
		
//		var dir = Gdx.files.internal("/assets/music/");
//		System.out.println("Listing " + dir)
//		for (fileHandle in dir.list()) {
//			val sound = Gdx.audio.newSound(fileHandle)
//			val name = fileHandle!!.file().getName().split(".")[0]
//			if (name.endsWith(".mp3") || name.endsWith(".wav")) {
//				list.put(name, sound)
//			}
//			System.out.println("found " + name)
//		}
	}

	fun play(name: String?) {
		if (list.containsKey(name)) {
			list.get(name)!!.play()
		}
	}

	fun dispose() {
		list.forEach({ _, s -> s.dispose() })
	}
}