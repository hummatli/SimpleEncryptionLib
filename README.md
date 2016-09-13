# MAHEncryptorLibrary - <a href="https://play.google.com/store/apps/developer?id=MobAppHome">MobAppHome</a>  encryptor library

Library for encryption and decryption strings on android apps and pc java applications.  
Library has build on IDE `Android Studio` and binaries have added to `jcenter()`  `maven` repository.
<br>You can check  <a href="https://bintray.com/hummatli/maven/mah-encryptor-lib#statistics">jCenter() download statistics</a> on this link - https://bintray.com/hummatli/maven/mah-encryptor-lib#statistics

#PlayStore
<a href="https://play.google.com/store/apps/details?id=com.mobapphome.mahencryptorlib">MAHEncryptorLibrary - Sample</a> app has published on Google PlayStore. You can easly test library functionality with downloading it.
<br><a href="https://play.google.com/store/apps/details?id=com.mobapphome.mahencryptorlib"><img src="https://github.com/hummatli/MAHEncryptorLib/blob/master/imgs/google-play-badge.png" width="200px"/></a> 

#Images
<img src="https://github.com/hummatli/MAHEncryptorLib/blob/master/imgs/main_activity.png" width="200px"/>


#Library structure and sample
Library has `MAHEncryptor` class. It has three main static methods:
* `MAHEncryptor.newInstance("key")`
* `MAHEncryptor.encode("str for encrytion")`
* `MAHEncryptor.decode("str for decrytion")`

Look following sample how to use library:
* For encrytion
```
	MAHEncryptor mahEncryptor = MAHEncryptor.newInstance("This is sample SecretKeyPhrase");
	String encrypted = mahEncryptor.encode("This is MAHEncryptorLib java sample");
```
* For decrytion
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
Sattar Hummatli - settarxan@gmail.com


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
