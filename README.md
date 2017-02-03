# MAHEncryptorLibrary - <a href="https://play.google.com/store/apps/developer?id=Sattar+Hummatli+-+MobAppHome">MobAppHome</a>  encryptor library  
<img src="https://raw.githubusercontent.com/hummatli/MAHEncryptorLib/master/imgs/green_star.png" width="20px"/>  _**Don't forget to start the protect to support us**_

[ ![Download](https://api.bintray.com/packages/hummatli/maven/mah-encryptor-lib/images/download.svg) ](https://bintray.com/hummatli/maven/mah-encryptor-lib/_latestVersion) 
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15) [![Hex.pm](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)](http://www.apache.org/licenses/LICENSE-2.0) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MAHEncryptorLibrary-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4497)

Library for encryption and decryption strings on Android apps and pc Java applications.
Library has build on IDE `Android Studio` and binaries have added to `jcenter()`  `maven` repository.
<br>You can check  <a href="https://bintray.com/hummatli/maven/mah-encryptor-lib#statistics">jCenter() download statistics</a> on this link - https://bintray.com/hummatli/maven/mah-encryptor-lib#statistics

#PlayStore
<a href="https://play.google.com/store/apps/details?id=com.mobapphome.mahencryptorlib">MAHEncryptorLibrary - Sample</a> app has published on Google PlayStore. You can easly test library functionality with downloading it.
<br><a href="https://play.google.com/store/apps/details?id=com.mobapphome.mahencryptorlib"><img src="https://raw.githubusercontent.com/hummatli/MAHEncryptorLib/master/imgs/google-play-badge.png" width="200px"/></a> 

#Images
<img src="https://raw.githubusercontent.com/hummatli/MAHEncryptorLib/master/imgs/main_activity.png" width="200px"/>


#Library structure and sample
Library has `MAHEncryptor` class. It has three main static methods:
* `MAHEncryptor.newInstance("key")`
* `MAHEncryptor.encode("str for encrytion")`
* `MAHEncryptor.decode("str for decrytion")`

Look following sample how to use library:
* For encryption
```
	MAHEncryptor mahEncryptor = MAHEncryptor.newInstance("This is sample SecretKeyPhrase");
	String encrypted = mahEncryptor.encode("This is MAHEncryptorLib java sample");
```
* For decryption
```
	MAHEncryptor mahEncryptor = MAHEncryptor.newInstance("This is sample SecretKeyPhrase");
	String decrypted = mahEncryptor.decode("4Vi86K/JL9gKclQahacrKLrEZL6/0vOpS4yPVm1hSLhhDsCMJTyd4A==");
```


#Installation manual
To import library to you project add following lines to project's `build.gradle` file. The last stable version is `1.0.0`

```
	dependencies {
    		compile 'com.mobapphome.library:mah-encryptor-lib:1.0.1'
	}
```


#End
Thats all. If you have any probelm with setting library please let me know. Write to settarxan@gmail.com. I will help.


#Contribution
* Fork it
* Create your feature branch (git checkout -b my-new-feature)
* Commit your changes (git commit -am 'Added some feature')
* Push to the branch (git push origin my-new-feature)
* Create new Pull Request
* Star it


#Developed By
[Sattar Hummatli](https://www.linkedin.com/in/hummatli) - settarxan@gmail.com

#Other libraries by developer
* [![MAHAndroidUpdater](https://img.shields.io/badge/GitHUB-MAHAndroidUpdater-green.svg)](https://github.com/hummatli/MAHAndroidUpdater) - Android update checker library. Library for notifing update information to installed android apps on android device.  
* [![MAHAds](https://img.shields.io/badge/GitHUB-MAHAds-green.svg)](https://github.com/hummatli/MAHAds) - Library for advertisement own apps through your other apps.

#License
Copyright 2015  - <a href="https://www.linkedin.com/in/hummatli">Sattar Hummatli</a>   

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
