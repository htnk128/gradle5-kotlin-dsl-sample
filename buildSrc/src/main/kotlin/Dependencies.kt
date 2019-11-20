import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

fun DependencyHandler.runtimeOnly(dependency: Any) {
    add("runtimeOnly", dependency)
}

fun DependencyHandler.testRuntimeOnly(dependency: Any) {
    add("testRuntimeOnly", dependency)
}

fun DependencyHandler.allModuleDependencies() {
    // Kotlin
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    // Test
    testImplementation("org.junit.jupiter:junit-jupiter:${Versions.junit}")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}")
}

fun DependencyHandler.springDependencies() {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

fun DependencyHandler.jacksonDependencies() {
    implementation("com.fasterxml.jackson.module:jackson-modules-java8:${Versions.jackson}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:${Versions.jackson}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jackson}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jackson}")
}

fun DependencyHandler.sqlDependencies() {
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:${Versions.mybatisSpringBootStarter}")
    runtimeOnly("mysql:mysql-connector-java:${Versions.mysqlDriver}")
    testRuntimeOnly("com.h2database:h2:${Versions.h2}")
}

fun DependencyHandler.flywayDependencies() {
    implementation("org.flywaydb:flyway-core:${Versions.flyway}")
}

fun DependencyHandler.swaggerDependencies() {
    implementation("io.springfox:springfox-swagger2:${Versions.swagger}")
    implementation("io.springfox:springfox-swagger-ui:${Versions.swagger}")
}
