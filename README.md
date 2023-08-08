# GoF_SpringBoot-4.Prototype_pattern

## How to setup Github actions

```ymal
name: Build and Deploy Spring Boot App

on:
  push:
    branches:
      - main

jobs:
  build:
    name: Build and Test
    runs-on: ubuntu-latest
    
    steps:
      - name: Checkout code
        uses: actions/checkout@v2
        
      - name: Set up Java
        uses: actions/setup-java@v2
        with:
          java-version: '20' # Make sure this is a string
          distribution: 'adopt' # Specify the Java distribution you want to use
      
      - name: Build with Maven
        run: mvn clean install
        
      - name: Run Tests
        run: mvn test
```
