import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object DependencyVersions {
  const val KOTLIN = "1.3.50"
  const val SPRING_BOOT = "2.2.0.RC1"
  const val SPRING_DEPENDENCY_MANAGER = "1.0.8.RELEASE"
  const val DOMA_SPRING_BOOT = "1.1.1"
  const val DOMA = "2.19.3"
  const val FLYWAY = "5.2.3"
  const val MYSQL_CONNECTER = "5.1.48"
  const val H2 = "1.4.199"
}

plugins {
  id("org.springframework.boot") version "2.2.0.RC1"
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
  id("org.flywaydb.flyway") version "5.2.3"
  kotlin("jvm") version "1.3.50"
  kotlin("plugin.spring") version "1.3.50"
  id("org.jetbrains.kotlin.kapt") version "1.3.50"
}

apply {
  plugin("kotlin")
  plugin("kotlin-kapt")
  plugin("kotlin-spring")
  plugin("org.springframework.boot")
  plugin("io.spring.dependency-management")
}

group = "com.littlefeet"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val compileKotlin: KotlinCompile by tasks
kapt {
  arguments {
    arg("doma.resources.dir", compileKotlin.destinationDir)
  }
}

repositories {
  mavenCentral()
  maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
  /* spring */
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  /* flyway */
  implementation("org.flywaydb:flyway-core")

  /* kotlin */
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

  /* test */
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
  testImplementation("io.projectreactor:reactor-test")
  testCompile("com.h2database:h2:${DependencyVersions.H2}")
  testImplementation("org.assertj:assertj-core:3.12.2")
  /* mock */
  testImplementation("io.mockk:mockk:1.9")
  testImplementation("io.mockk:mockk-common:1.9")

  /* Doma2 */
  implementation("org.seasar.doma.boot:doma-spring-boot-starter:${DependencyVersions.DOMA_SPRING_BOOT}")
  implementation("org.seasar.doma:doma:${DependencyVersions.DOMA}")
  kapt("org.seasar.doma:doma:${DependencyVersions.DOMA}")

  compile("mysql:mysql-connector-java:${DependencyVersions.MYSQL_CONNECTER}")
}

tasks.register("copyDomaResources", Sync::class) {
  from("src/main/resources")
  into(compileKotlin.destinationDir)
  include("doma.compile.config")
  include("META-INF/**/*.sql")
  include("META-INF/**/*.script")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  this.dependsOn(tasks.getByName("copyDomaResources"))
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}

/* flyway db migration task */
flyway {
  url = "jdbc:mysql://localhost:3306/strings_history?allowPublicKeyRetrieval=true&useSSL=false"
  user = "root"
  password = "pass"
  locations = arrayOf("filesystem:src/main/resources/db/migration", "filesystem:src/main/resources/db/insert")
}

