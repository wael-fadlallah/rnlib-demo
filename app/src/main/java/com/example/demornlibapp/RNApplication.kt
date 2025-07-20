package com.example.demornlibapp

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader
import com.facebook.react.soloader.OpenSourceMergedSoMapping

class RNApplication : Application(), ReactApplication {

    // Define the ReactNativeHost (this manages the shared ReactInstanceManager)
    private val mReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean = false

        override fun getPackages(): List<ReactPackage> {
            // Add MainReactPackage and any custom packages from your library
            return listOf(MainReactPackage())
        }

        // Configure bundle loading (adjust to match your RN setup)
        override fun getJSBundleFile(): String? {
            // Return a file path if loading from file/server; null for assets
            return null
        }

        override fun getBundleAssetName(): String {
            return "index.android.bundle"  // Matches your original config
        }

        override fun getJSMainModuleName(): String = "index"  // Matches your original config
    }

    // Required override for ReactApplication interface (as a PROPERTY in Kotlin)
    override val reactNativeHost: ReactNativeHost = mReactNativeHost  // Fix: Use property override

    override fun onCreate() {
        super.onCreate()
        // Initialize SoLoader here (once per app) to load native libraries like libhermes.so
        SoLoader.init(this, /* native exopackage */ OpenSourceMergedSoMapping)
    }
}