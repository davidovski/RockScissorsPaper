package com.mouldycheerio.rsp

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.Game
import com.badlogic.gdx.assets.AssetManager

class RSPGame : Game() {
	internal var batch: SpriteBatch? = null
	internal var img: Texture? = null
	internal var shapeRenderer: ShapeRenderer? = null;
	internal var font: BitmapFont? = null;
	internal var assetManager: AssetManager? = null;

	public var musicPlayer = MusicPlayer();

	override fun create() {
		musicPlayer.init();
		batch = SpriteBatch();
		shapeRenderer = ShapeRenderer();
		assetManager = AssetManager();

		assetManager!!.load("bg.jpg", Texture::class.java);
		assetManager!!.load("rock.png", Texture::class.java);

		font = BitmapFont();
		while (!assetManager!!.update()) {
		}

		this.setScreen(MenuScreen(this));

	}

	override fun dispose() {
		batch!!.dispose();
		shapeRenderer!!.dispose();
		font!!.dispose();
		assetManager!!.dispose();
		musicPlayer.dispose();
	}
}