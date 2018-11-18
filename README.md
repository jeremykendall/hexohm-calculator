# HexOhm Calculator

Calculates HexOhm wattage output based on coil resistance and potentiometer setting.

## But Why?

Because I love my HexOhm v3 but never know exactly how many watts it's putting out, and because I need more Java + Gradle + Spock practice.

## Usage

Create a new `Hexohm`, providing coil resistance, then ask for wattage by passing a potentiometer setting.

```java
Resistance resistance = Resistance.of(0.22);
int potentiometer = 30;

Hexohm hexohm = new Hexohm(resistance);
Wattage wattage = hexohm.getWattage(potentiometer); // wattage == 63.0
System.out.println(wattage.toString); // Wattage(watts=63.0)
```

## Gotcha

Since it's a pain to calculate the output voltage of the potentiometer, the only valid pot settings are 0 - 100, counting by 10s.

## As a Dependency

No idea why you'd want to, but if you want to add the `hexohm-calculator` to your own app you can do so using [JitPack](https://jitpack.io/).

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