
Following project demonstrates a problem (?) with classloading in jcommander 1.73.

Invoking `classLoader.loadClass(ParameterException.class.getName())` throws `CNFE`, but when using older version it returns class from classpath.

 * Use `mvn clean package` to run against jcommander 1.73 (test will throw exception)
 * Use `mvn clean package -Pjcommander-old` to run against jcommander 1.27 (test will pass)
 * Use `mvn clean package -Pjcommander-patched` to run against locally stored jcommander 1.73 patched as described below (test will pass)

```
Apache Maven 3.3.9
Maven home: /usr/share/maven
Java version: 1.8.0_101, vendor: Oracle Corporation
Java home: /opt/jdk1.8.0_101/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.14.13-200.fc26.x86_64", arch: "amd64", family: "unix"
```

If you use repackaged JAR included in this repository (i.e. by using `<systemPath>` for dependency in Maven) this test will pass.

### Evaluation
There is duplication in `META-INF/MANIFEST.MF`. I extracted it using `tax -xvf`. Removed duplication from `META-INF/MANIFEST.MF` and then repackaged it using
modified `META-INF/MANIFEST.MF`, the test was passing. 
