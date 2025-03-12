package com.github.quytm.likec4

import com.intellij.openapi.diagnostic.Logger
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider
import java.io.File
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import kotlin.io.path.Path

class LikeC4TextMateBundleProvider : TextMateBundleProvider {
    private val logger = Logger.getInstance(LikeC4TextMateBundleProvider::class.java)

    override fun getBundles(): MutableList<TextMateBundleProvider.PluginBundle> {
        val bundles = mutableListOf<TextMateBundleProvider.PluginBundle>()

        val bundlePath = this::class.java.classLoader.getResource("textmate/likec4.tmLanguage")

        if (bundlePath != null) {
            val decodedPath = URLDecoder.decode(bundlePath.path, StandardCharsets.UTF_8)
            val bundleFile = File(decodedPath)

            val path = Path(bundleFile.absolutePath)
            if (bundleFile.exists()) {
                val reader = TextMateBundleProvider.PluginBundle("Likec4", path)
                bundles.add(reader)

                TextMateService.getInstance().readBundle(Path(bundleFile.absolutePath))

                logger.info("✅ LikeC4 TextMate Bundle registered: ${bundleFile.absolutePath}")
            } else {
                logger.warn("⚠️ LikeC4 TextMate Bundle file does not exist at: $decodedPath")
            }
        } else {
            logger.warn("⚠️ LikeC4 TextMate Bundle NOT found in resources/textmate/")
        }

        return bundles
    }
}
