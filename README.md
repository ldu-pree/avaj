# Avaj

## Running Avaj:
### If You Have Make Installed Run:
#### To Build And Run It:
make
#### To Just Build It:
make build
#### To Run It (Requires you to build first):
make run
### If You Don't Have Make:
#### To Build:
javac -sourcepath -h ./avaj.java ./AvajConfig/lib.java ./AvajConfig/opts.java ./Flyables/Aircraft.java ./Flyables/Coords.java ./Flyables/Factory.java ./Weather/generator.java ./Weather/adjustor.java
#### To Run:
java avaj.java scenario.txt
