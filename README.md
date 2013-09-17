# AndroidSkinService

**Skin your Android application in a beautiful way**

## Features

* Define your skin both in XML layout file and programmatically created views. _the second way will be included soon._
* Skin switch on the fly (No need to restart the activity or application if we use the provided theme system by Android).
* Not only changing the background color, text color or drawable, even the visibility, paddings, text content can be changed between different skin. You can implement your own code to change every specific view's properties.
* Load external apk resources as a skin.

## To be done

* Integrate with Android's style system

## Requirements

* Build on the new Android build system which is based on Gradle.
* For convenience Android Studio IDE is recommended.

## Sub projects

### AndroidSkinService

The main library project to provide skin switch functionality.

### AndroidSkinServiceSample

A sample project to demostrate the usage.


### ExternalSkin

A library project contains only resources as an extarnal skin. Using Gradle to build and produce a ExternalSkin.ap\_ file which can be load by the AndroidSkinService. Of cause it should be placed in the target Android device and make sure your application has the right permission to access it.

## Licences

    AndroidSkinService
    Copyright (C) 2013 Simon Yu
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
