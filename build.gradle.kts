plugins {
	id("java")
}

group = "aero.geosystems"
version = "19.0124"

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	mavenCentral()
}
dependencies {
	compile(group = "org.jetbrains", name = "annotations", version = "13.0")
	testCompile(group = "junit", name = "junit", version = "4.8")
}
