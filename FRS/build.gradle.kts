plugins {
    id("java")
    kotlin("jvm") // Kotlin JVM 插件
    application // 添加 application 插件
}

group = "net.xingtuan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    jar {
        manifest {
            attributes(
                "Main-Class" to "net.xingtuan.Main"  // 指定主类
            )
        }
    }

    // 自定义任务，使用 jpackage 打包成可执行安装包
    register<Exec>("packageApp") {
        commandLine = listOf(
            "jpackage",
            "--input", "build/libs",          // 输入目录，包含 JAR 文件
            "--name", "FRSApp",               // 应用程序名称
            "--main-jar", "FRS-1.0-SNAPSHOT.jar", // 主 JAR 文件名称
            "--main-class", "net.xingtuan.Main",  // 主类
            "--type", "exe",                  // 输出的安装包类型
            "--runtime-image", "C:\\Program Files\\Java\\jdk-17.0.11" // 使用当前 JDK 作为运行时
        )
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)  // 使用 JDK 17
}

// application 配置，指定 main class
application {
    mainClass.set("net.xingtuan.Main")
}
