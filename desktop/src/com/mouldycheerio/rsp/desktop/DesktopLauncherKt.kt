package com.mouldycheerio.rsp.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mouldycheerio.rsp.RSPGame

class DesktopLauncherKt {
}

fun main() {
	val config = LwjglApplicationConfiguration()

	config.width = 1920
	config.height = 1080
	LwjglApplication(RSPGame(), config)
}
