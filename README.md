# HexOhm Calculator

Calculates HexOhm wattage output based on coil resistance and potentiometer setting. A second project in this repo, the 
`cli` project, will output a wattage table to the command line for a given resistance.

## But Why?

Because I love my HexOhm v3 but never know exactly how many watts it's putting out, and because I need more Java, Gradle, 
and Spock practice.

## Usage

### Calculator

Create a new `Hexohm`, providing coil resistance, then ask for wattage by passing a potentiometer setting.

```java
Resistance resistance = Resistance.of(0.22);
int potentiometerSetting = 30;

Hexohm hexohm = new Hexohm(resistance);
Wattage wattage = hexohm.getPowerOutput(potentiometerSetting); // wattage == 63.0
System.out.println(wattage.toString); // Wattage(watts=63.0)
```

### CLI

Build the project and run on the command line or simply run the `HexohmOutputApplication` in your IDE.

```bash
$ ./gradlew clean build
$ java -jar cli/build/libs/cli-0.0.1-SNAPSHOT.jar

. . .

shell:>wattage-table --resistance 0.23
+-------------+-------+
|Potentiometer|Wattage|
+-------------+-------+
|            0|   46.0|
+-------------+-------+
|           10|   50.0|
+-------------+-------+
|           20|   54.0|
+-------------+-------+
|           30|   60.0|
+-------------+-------+
|           40|   66.0|
+-------------+-------+
|           50|   75.0|
+-------------+-------+
|           60|   85.0|
+-------------+-------+
|           70|  100.0|
+-------------+-------+
|           80|  115.0|
+-------------+-------+
|           90|  133.0|
+-------------+-------+
|          100|  157.0|
+-------------+-------+

```

## Gotcha

Since it's a pain to calculate the output voltage of the potentiometer, the only valid pot settings are 0 - 100, counting 
by 10s.

## As a Dependency

No idea why you'd want to, but if you want to add the `hexohm-calculator` to your own app you can do so using 
[JitPack](https://jitpack.io/).

Add JitPack to repositories

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the dependency

```
dependencies {
    implementation 'com.github.jeremykendall:hexohm-calculator:0.0.4-SNAPSHOT'
}
```

The list of versions is available here: https://github.com/jeremykendall/hexohm-calculator/releases