### TL;DR : It's not a bug! It's a feature - http://bugs.sun.com/view_bug.do?bug_id=4761949

Following project demonstrates a problem (?) with classloading in jcommander 1.72.

Invoking `classLoader.getResource("com/beust/jcommander")` returns `null`, but when using older version it returns URL to the jar file from classpath.

 * Use `mvn clean package` to run against jcommander 1.72 (test will fail)
 * Use `mvn clean package -Pjcommander-testng-bundled` to run against jcommander 1.66 (test will fail)
 * Use `mvn clean package -Pjcommander-old` to run against jcommander 1.27 (test will pass)
 * Use `mvn clean package -Pjcommander-patched` to run against locally stored jcommander 1.72 patched as described below (test will pass)

```
Apache Maven 3.3.9
Maven home: /usr/share/maven
Java version: 1.8.0_101, vendor: Oracle Corporation
Java home: /opt/jdk1.8.0_101/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.14.13-200.fc26.x86_64", arch: "amd64", family: "unix"
```

The same behaviour under JDK6 from Oracle.

If you use repackaged(`jar xvf` and then `jar cvf`) JAR included in this repository (i.e. by using `<systemPath>` for dependency in Maven) this test will pass.
