package com.mouldycheerio.rsp.screenobjects

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.Gdx

class ScreenObejectManager : InputProcessor {
	internal var objects: MutableList<ScreenObject> = ArrayList<ScreenObject>();
	private var px: Int = 0;
	private var py: Int = 0;
	private var mousedown: Boolean = false;

	public fun add(obj: ScreenObject): ScreenObject {
		objects.add(obj);
		return obj;
	}

	override fun keyDown(keycode: Int): Boolean {
		return false;
	}

	override fun keyTyped(character: Char) = false;

	override fun keyUp(keycode: Int) = false;

	override fun scrolled(amountX: Float, amountY: Float) = false;

	override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
		px = screenX;
		py = screenY;
		return processMouseActions();
	}

	override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
		px = screenX;
		py = screenY;
		mousedown = true;
		return processMouseActions();
	}

	override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
		px = screenX;
		py = screenY;
		return processMouseActions();
	}

	override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
		px = screenX;
		py = screenY;
		mousedown = true;

		return processMouseActions();
	}

	public fun render(batch: SpriteBatch, font: BitmapFont) {
		objects.forEach {
			it.render(batch, font);
		}
	}

	private fun processMouseActions(): Boolean {
		System.out.println("processsing actions $px $py $mousedown")

		var executed = false;
		objects.forEach {
			if (it is Clickable && mousedown && it.isColliding(px, py)) {
				it.onclick();
				executed = true;
			}
			if (it is Hoverable && it.isColliding(px, py)) {
				it.onhover();
				executed = true;
			}
		}
		return executed;
	}


}