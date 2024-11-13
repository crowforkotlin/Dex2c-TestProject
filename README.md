- Gradle Version : 8.9
- Android Gradle Version : 8.7.2
- MinSdk : 23
- CompileSdk : 35
- targetSdk : 34
- JDKVersion : 17
- NDK Version : 26.1.10909125
- ApkConfigs 
```kotlin
buildTypes {
    release {
        isMinifyEnabled = true
        // ...
    }
}
signingConfigs {
    register("release") {
        enableV1Signing = true
        enableV2Signing = true
        enableV3Signing = true
    }
}
```
- apk file in app/release/app-release.apk