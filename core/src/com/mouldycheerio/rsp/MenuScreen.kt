package com.mouldycheerio.rsp

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.Texture
import com.mouldycheerio.rsp.screenobjects.ScreenObjectScreen
import com.badlogic.gdx.assets.AssetManager
import com.mouldycheerio.rsp.screenobjects.ClickableScreenObject

class MenuScreen(game: RSPGame?) : ScreenObjectScreen(game) {
	
	override fun start() {
		var rocktex = assetManager!!.get("rock.png", Texture::class.java)
		var rock = object : ClickableScreenObject(rocktex, 25, 25, 100, 100) {
			override fun onclick() {
				System.out.println("CLicked")
			}
		}
		objectmanager!!.add(rock);
	}

	override fun loadBackground(assetManager: AssetManager): Texture {
		return assetManager.get("bg.jpg", Texture::class.java);
	}

	override fun tick(delta: Float) {
	}
}