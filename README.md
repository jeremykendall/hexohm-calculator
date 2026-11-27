👋I am looking for a long-term partner.  🌍I was previously working in Japan as a software engineer and AI trainer, but I have recently lost my position—a situation that would be too lengthy to explain in detail here.  Moving forward, I intend to pursue global-facing roles and continue with AI training.  ✅✅As you may know, budgets in Japan are quite limited; even if one secures a position with a global company, the expected monthly compensation is typically only around $2,000–$3,000.  Furthermor
# HexOhm Calculator

Calculates HexOhm wattage output based on coil resistance and potentiometer setting. A second project in this repo, the 
`cli` project, will output an amperage and wattage table to the command line for a given resistance.

## But Why?

Because I love my HexOhm v3 but never know exactly how many watts it's putting out, or how much current it's drawing, 
and because I need more Java, Gradle, and Spock practice.

## Usage

### Calculator

Create a new `Hexohm`, providing a coil resistance and potentiometer setting, then ask for wattage or amperage.

```java
Hexohm hexohm = new Hexohm(Resistance.of(0.23), Hexohm.Potentiometer.THIRTY);
Wattage wattage = hexohm.getPowerOutput();
Amperage amps = hexohm.getCurrent();
```

### CLI

Build the project and run on the command line or simply run the `HexohmCli` in your IDE.

```bash
$ ./gradlew clean build
$ java -jar cli/build/libs/cli-0.0.1-SNAPSHOT.jar

. . .

shell:>hexohm --resistance 0.23
+----------+----------+----------+
| Setting  |   Amps   |  Watts   |
+----------+----------+----------+
|         0|    14.22A|    46.49W|
+----------+----------+----------+
|        10|     14.7A|    49.67W|
+----------+----------+----------+
|        20|    15.35A|    54.18W|
+----------+----------+----------+
|        30|    16.17A|    60.17W|
+----------+----------+----------+
|        40|    16.96A|    66.13W|
+----------+----------+----------+
|        50|    18.09A|    75.24W|
+----------+----------+----------+
|        60|    19.22A|    84.94W|
+----------+----------+----------+
|        70|    20.83A|    99.76W|
+----------+----------+----------+
|        80|    22.35A|   114.87W|
+----------+----------+----------+
|        90|    24.09A|   133.44W|
+----------+----------+----------+
|       100|    26.09A|   156.52W|
+----------+----------+----------+

```

## Gotcha

The output voltage used to calculate wattage may not reflect reality. I have yet to find anyone who has actually measured 
the output voltage of a Hexohm v3 who has also posted that data anywhere, so I went with a table I found somewhere on the internet.
Because if it's on the internet it must be true.
