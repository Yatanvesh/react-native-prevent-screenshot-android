# react-native-prevent-screenshot-android

A simple wrapper for enabling and disabling screenshots on android

## Getting started

`$ npm install react-native-prevent-screenshot-android --save`

### Mostly automatic installation

`$ react-native link react-native-prevent-screenshot-android`

Implemented using the instructions from https://www.netguru.com/codestories/prevent-screenshots-react-native

## Usage
```javascript
import PreventScreenshotAndroid from 'react-native-prevent-screenshot-android';


// Disable taking screenshot, asnc method
PreventScreenshotAndroid.forbidScreenshot();

// Enable taking screenshot, asnc method
PreventScreenshotAndroid.enableScreenshot();
```
