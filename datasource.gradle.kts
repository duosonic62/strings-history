import org.yaml.snakeyaml.Yaml
import java.io.FileInputStream

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath(group="org.yaml", name="snakeyaml", version="1.19")
  }
}

val yml = Yaml().load(FileInputStream("src/main/resources/application.yml"))