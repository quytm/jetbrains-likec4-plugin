package com.github.quytm.likec4

import com.intellij.ide.ApplicationInitializedListener
import com.intellij.openapi.diagnostic.Logger
import org.jetbrains.plugins.textmate.TextMateService
import kotlin.io.path.Path

class LikeC4TextMateLoader : ApplicationInitializedListener {
    private val logger = Logger.getInstance(LikeC4TextMateLoader::class.java)

    override suspend fun execute() {
        logger.info("✅ LikeC4 TextMate Bundle loaded....")
    }

    override fun componentsInitialized() {
        val bundlePath = this::class.java.classLoader.getResource("textmate/likec4.tmLanguage")

        if (bundlePath != null) {
            val textMateService = TextMateService.getInstance()
            textMateService.readBundle(Path(bundlePath.path))

            logger.info("✅ LikeC4 TextMate Bundle loaded successfully from: ${bundlePath.path}")
        } else {
            logger.warn("⚠️ LikeC4 TextMate Bundle NOT found in resources/textmate/")
        }
    }
}
