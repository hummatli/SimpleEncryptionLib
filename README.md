<h1 align="center">SimpleEncryptorLib</h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://bintray.com/hummatli/maven/simple-encryptor-lib/_latestVersion"><img src="https://api.bintray.com/packages/hummatli/maven/simple-encryptor-lib/images/download.svg"></a>
  <a target="_blank" href="https://android-arsenal.com/api?level=16"><img src="https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat"></a>
  <a target="_blank" href="http://www.apache.org/licenses/LICENSE-2.0"><img src="https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000"></a>
  <a target="_blank" href="http://android-arsenal.com/details/1/4497"><img src="https://img.shields.io/badge/Android%20Arsenal-SimpleEncryptorLibrary-brightgreen.svg?style=flat" /></a>
</p>

<p align="center">Free, open source, third party Android library and PC library for encryption and decryption strings on Android apps and pc Java applications.  Library is 100% compatible with Kotlin and Java applications. Contains sample in both Kotlin and Java. Check out the <a href="https://github.com/hummatli/SimpleEncryptorLib/wiki">wiki</a>. To support, <a href="https://www.buymeacoffee.com/hummatli" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;" ></a></p>

<p align="left">
<img src="https://raw.githubusercontent.com/hummatli/SimpleEncryptorLib/master/imgs/main_activity.png" width="200px"/>
</p>
<!--[ ![Download](https://api.bintray.com/packages/hummatli/maven/simple-encryptor-lib/images/download.svg) ](https://bintray.com/hummatli/maven/simple-encryptor-lib/_latestVersion) 
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15) [![Hex.pm](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)](http://www.apache.org/licenses/LICENSE-2.0) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SimpleEncryptorLibrary-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4497)-->

Library for encryption and decryption strings on Android apps and pc Java applications. `Library is 100% compatible with Kotlin and Java applications`. Contains sample in both `Kotlin` and `Java`. Created by Java language in Android Studio.

Library has build on IDE `Android Studio` and binaries have added to `jcenter()`  `maven` repository.
<br>You can check  [jCenter() download statistics](https://bintray.com/hummatli/maven/simple-encryptor-lib#statistics) on this [link](https://bintray.com/hummatli/maven/simple-encryptor-lib#statistics)

* [jCenter() download statistics](https://bintray.com/hummatli/maven/simple-encryptor-lib#statistics)

<img src="https://raw.githubusercontent.com/hummatli/SimpleEncryptorLib/master/imgs/green_star.png" width="20px"/>  _**Don't forget to star the protect to support us**_

### Problem It Solves
I haven't used special algorithm here, 

There is a problem [(Look here)](https://stackoverflow.com/questions/32935783/java-different-results-when-decoding-base64-string-with-java-util-base64-vs-and) with Base64 class in Android and (Oracle)Java SDK. They have both this class but has some little differences in methods and different packages. 

I have taken Oracle's version and has created this lib. Buy the help of it you can use Oracle's Base64 in Android application. It eases your encryption and decryption process with the same function in Android application and in pure Java application.

#### Package differences  
* `In Oracle's SDK` - **java.util.Base64** 
* `In Android SDK` - **android.util.Base64**
* `In this Lib` - **com.mobapphome.simpleencryptorlib.Base64** - This is like Oracle's version but works in Android and in pure Java(Oracle SDK)

### Demo App
Download the demo app from this link - <a href="https://github.com/hummatli/SimpleEncryptionLib/releases/download/v.1.0.1/DemoApp-SimpleEncryptorLib.apk">Demo App</a>. You can easly test the lib's functionality.

### Library structure and sample
Library has `SimpleEncryptor` class. It has three main static methods:
* `SimpleEncryptor.newInstance("key")`
* `SimpleEncryptor.encode("str for encrytion")`
* `SimpleEncryptor.decode("str for decrytion")`

Look following sample how to use library:
> Encryption in Kotlin:
```kotlin
val simpleEncryptor = SimpleEncryptor.newInstanceOrRetunNull("Sample SecretKeyPhrase")
val encrypted = simpleEncryptor!!.encodeOrReturnNull("Text to encode")
```
> Encryption in Java:
```java
SimpleEncryptor simpleEncryptor = SimpleEncryptor.newInstance("Sample SecretKeyPhrase");
String encrypted = simpleEncryptor.encode("Text to encode");
```

> Decryption in Kotlin:
```kotlin
val simpleEncryptor = SimpleEncryptor.newInstanceOrRetunNull("Sample SecretKeyPhrase")
val decrypted = simpleEncryptor.decode("Vm1hSLhhDsCMJTyd4A==")
```
> Decryption in Java:
```java
SimpleEncryptor simpleEncryptor = SimpleEncryptor.newInstance("Sample SecretKeyPhrase");
String decrypted = simpleEncryptor.decode("Vm1hSLhhDsCMJTyd4A==");
```

### Installation manual
To import library to you project add following lines to project's `build.gradle` file. The last stable version is `1.1.3`

```gradle
repositories {
    maven { url 'https://dl.bintray.com/hummatli/maven/' }
}

dependencies {
    compile 'com.mobapphome.library:simple-encryptor-lib:1.1.3'
}
```


### End
Thats all. If you have any probelm with setting library please let me know. Write to settarxan@gmail.com. I will help.


### Contribution
* Fork it
* Create your feature branch (git checkout -b my-new-feature)
* Commit your changes (git commit -am 'Added some feature')
* Push to the branch (git push origin my-new-feature)
* Create new Pull Request
* Star it


### Developed By
[Sattar Hummatli](https://www.linkedin.com/in/hummatli) - settarxan@gmail.com

### Other libraries by developer
* [![AndroidAppUpdater](https://img.shields.io/badge/GitHUB-AndroidAppUpdater-green.svg)](https://github.com/hummatli/AndroidAppUpdater) - Android update checker library. Library for notifing update information to installed android apps on android device.  
* [![AppCrossPromoter](https://img.shields.io/badge/GitHUB-AppCrossPromoter-green.svg)](https://github.com/hummatli/AppCrossPromoter) - Library for advertisement own apps through your other apps.

### License
Copyright 2017  - <a href="https://www.linkedin.com/in/hummatli">Sattar Hummatli</a>   

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
