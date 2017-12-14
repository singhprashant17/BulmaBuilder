# BulmaBuilder

An java-annotation based java library to automatically generate Builder classes to the annotated 
class.

Gone are the days when you spend your precious time on writing boilerplate code.

This <b>JAVA</b> library generates the builder class for your class in the easiest 
imaginable way.

This is a Java library demonstrated in an  Android App

<b>Usage</b>

All you have to do is annotate your class with **@BulmaBuilder** and that is it.

Suppose you have a model class like this

```java
@BulmaBuilder // IMP : Annotate the class
public class ModelClass {
    
    private String title;
    private String type;
    private List<String> required;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<String> getRequired() {
        return required;
    }
    
    public void setRequired(List<String> required) {
        this.required = required;
    }
}
```
After this, just rebuild your project. The library will automatically generate the builder 
classes for you.

Output java class. This will be generated at the same package as your model class.

```java
public class ModelClassBuilder {
    
    private ModelClass object = new ModelClass();
	
    public ModelClass build() {
        return object;
    }
	
    public ModelClassBuilder setRequired(java.util.List<java.lang.String> value) {
        object.setRequired(value);
        return this;
    }
	
    public ModelClassBuilder setTitle(java.lang.String value) {
        object.setTitle(value);
        return this;
    }
	
    public ModelClassBuilder setType(java.lang.String value) {
        object.setType(value);
        return this;
    }
}
```

And use like this
```java
final ModelClass modelClassObj = new ModelClassBuilder()
                .setRequired(new ArrayList<String>())
                .setTitle("title")
                .setType("type")
                .build();

```

<b>Integration</b>

- For android apps, add it on your gradle build:

```groovy
dependencies {
        complie 'com.prashant.java:bulmabuilder:1.0.0'
        annotationProcessor 'com.prashant.java:bulmabuilder:1.0.0'
}
```
- As a gradle dependency
```groovy
complie 'com.prashant.java:bulmabuilder:1.0.0'
```
- As a maven dependency
```xml
<dependency>
    <groupId>com.prashant.java</groupId>
    <artifactId>bulmabuilder</artifactId>
    <version>1.0.0</version>
    <type>pom</type>
</dependency>
```

<b>Note</b>

There are few things you need to know.
- The library does not work as expected for inner class. Avoid this library in such case.
- The class for which the builder is generated i.e. the annotated class must contain setter 
methods such that the method name must start with "set" and contains exactly one parameter. Ex. 
void setName(String name){}; Basically name your setter methods conventionally.

<b>License</b>

Apache-2.0 