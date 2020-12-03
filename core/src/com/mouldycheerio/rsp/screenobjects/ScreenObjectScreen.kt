package com.mouldycheerio.rsp.screenobjects

import com.mouldycheerio.rsp.RSPGame
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.input.GestureDetector.GestureListener
import com.badlogic.gdx.graphics.GL20

abstract class ScreenObjectScreen(game: RSPGame?) : ScreenAdapter() {
	internal var game: RSPGame? = null
	internal var background: Texture? = null
	internal var objectmanager: ScreenObejectManager? = null
	internal var assetManager: AssetManager? = null

	init {
		this.game = game
		this.assetManager = game!!.assetManager!!
		objectmanager = ScreenObejectManager()
	}

	abstract fun start()
	abstract fun loadBackground(assetManager: AssetManager): Texture
	abstract fun tick(delta: Float)

	override fun show() {
		Gdx.input.setInputProcessor(objectmanager);
		background = loadBackground(game!!.assetManager!!)
		start()
	}


	override fun render(delta: Float) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		game!!.batch!!.begin()
		game!!.batch!!.draw(
			background!!,
			0f,
			0f,
			Gdx.graphics.getWidth().toFloat(),
			Gdx.graphics.getHeight().toFloat()
		);
		objectmanager!!.render(game!!.batch!!, game!!.font!!);
		game!!.batch!!.end()

		tick(delta)

	}

	override fun hide() {
		Gdx.input.setInputProcessor(null)
	}
}