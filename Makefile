.PHONY: clean

build: clean
	@./gradlew shadowJar

clean:
	@./gradlew clean