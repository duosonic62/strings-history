import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val domaVersion = "2.19.3"
val domaGenVersion = "2.19.3"
val domaSpringVersion = "1.1.1"

val compileKotlin: KotlinCompile by tasks


plugins {
	id("org.springframework.boot") version "2.2.0.M6"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("org.flywaydb.flyway") version "5.2.3"
	id("org.jetbrains.kotlin.kapt") version "1.2.71"
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
}

group = "com.littlefeet"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	/* spring boot */
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	/* kotlin */
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	/* doma */
	compile("org.seasar.doma.boot:doma-spring-boot-starter:$domaSpringVersion")
	kapt("org.seasar.doma:doma:$domaVersion")
	implementation("org.seasar.doma:doma:$domaVersion")

	/* db connector */
	compile("mysql:mysql-connector-java:5.1.38")
	/* flyway migration */
	implementation("org.flywaydb:flyway-core")

	/* test */
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

/* doma */
kapt {
	arguments {
		arg("doma.resources.dir", compileKotlin.destinationDir)
	}
}

tasks.register("copyDomaResources", Sync::class) {
	from("src/main/resources")
	into(compileKotlin.destinationDir)
	include("doma.compile.config")
	include("META-INF/**/*.sql")
	include("META-INF/**/*.script")
}

compileKotlin.dependsOn(tasks.getByName("copyDomaResources"))


/* flyway db migration task */
flyway {
	url = "jdbc:mysql://localhost:3306/strings_history?useSSL=false"
	user = "root"
	password = "pass"
	locations = arrayOf("filesystem:src/main/resources/db/migration", "filesystem:src/main/resources/db/insert")
}

/* annotation processing configure */
configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}
