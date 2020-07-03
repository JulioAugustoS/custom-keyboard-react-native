import React from 'react';
import { AppRegistry, View, Text } from 'react-native';
import App from './App';
import { name as appName } from './app.json';

const Keyboard = () => {
  return (
    <View
      style={{
        width: '100%',
        height: 320,
        backgroundColor: 'red',
        justifyContent: 'center',
        alignItems: 'center',
      }}>
      <Text style={{ color: '#FFFF' }}>Teste</Text>
    </View>
  );
};

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent('RNCustomKeyboard', () => Keyboard);
