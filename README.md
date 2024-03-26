# Dream InHouse - Rede Social Imobiliária
## Building
Firstly, install necessary dependencies with:
```bash
mvn dependency:resolve
```

Then, build the package:
```bash
mvn package
```

Lastly execute it with:
```bash
java -jar ./target/DreamInHouse*jar
```

or
```bash
mvn -q exec:java
```
