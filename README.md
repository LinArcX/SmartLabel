[![](https://jitpack.io/v/LinArcX/SmartLabel.svg)](https://jitpack.io/#LinArcX/SmartLabel)

# SmartLabel
A Composit Smart View

## Preview
!["smartLabel"](assets/SmartLabelGithub.png "tvdoon")

# Setup
## 1. Provide the gradle dependency

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Add the dependency:
```gradle
dependencies {
	compile 'com.github.LinArcX:SmartLabel:0.1.2'
}
```

## 2. How to use

Add the SmartLabel in your layout file and customize it the way you like it.
```xml
<ir.oveissi.threestateswitch.ThreeStateSwitch
    android:id="@+id/threeState"
    android:layout_width="200dp"
    android:layout_height="wrap_content"
    app:background_selected_color="#5bb434"
    app:background_normal_color="#bfbfbf"
    app:text_left="چپ"
    app:text_right="راست"
    app:text_selected_color="#5bb434"
    app:text_normal_color="#646464"
    app:text_normal_size="16sp"
    app:text_selected_size="20sp"/>
```

Documanation is Here:
https://jitpack.io/com/github/LinArcX/SmartLabel/0.1.0/javadoc/
