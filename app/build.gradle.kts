apply plugin: 'com.android.application'
apply plugin: 'io.objectbox'
apply plugin: 'realm-android'

android {
    namespace 'io.objectbox.performanceapp'
    compileSdkVersion 30 // Android 11

    buildFeatures {
        viewBinding true
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    defaultConfig {
        applicationId "io.objectbox.performanceapp"
        minSdkVersion 19 // Android 4.4
        targetSdkVersion 30 // Android 11
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = ["room.schemaLocation": "$projectDir/schemas".toString()]
            }
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.debug
        }
        releaseDebugCert {
            initWith release
            // Just to use without checkjni
            signingConfig signingConfigs.debug
        }
        debugJniNoDebug {
            initWith debug
            // Just to use without checkjni
            jniDebuggable false
        }
    }
}

// Print deprecation warnings like Kotlin
tasks.withType(JavaCompile).configureEach {
    options.deprecation = true
}

dependencies {
    implementation "androidx.room:room-runtime:2.3.0"
    annotationProcessor "androidx.room:room-compiler:2.3.0"
    implementation 'org.greenrobot:greendao:3.3.0'
    implementation 'org.greenrobot:essentials:3.1.0'
}
