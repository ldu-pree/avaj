SRC = ./avaj.java \
	./AvajConfig/lib.java \
	./AvajConfig/opts.java \
	./Flyables/Aircraft.java \
	./Flyables/Coords.java \
	./Flyables/Factory.java \
	./Weather/generator.java \
	./Weather/adjustor.java


all: build run

build:
	@javac -sourcepath -h $(SRC)

run:
	@java avaj.java scenario.txt