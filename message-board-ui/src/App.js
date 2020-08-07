import React, {Component} from 'react';

import './App.css';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

import ViewMessages from './viewMessages';
import ViewMessagesVowels from './viewMessagesVowels';
import DeleteMessage from './deleteMessage';
import PostMessage from './postMessage';
import Welcome from './welcome';




function App() {

  return (
    <Router>
        
      <div className="App">
        <div className ="centered">
          
          <ul id="horizontal-list">
              <li><Link to="/postMessage"  className="menu">Post Message</Link></li>
              <li><Link to="/viewMessages" className="menu">View Messages</Link></li>
              <li><Link to="/viewMessagesVowels" className="menu">Messages With Vowels</Link></li>
              <li><Link to="/deleteMessage" className="menu">Delete Message</Link></li>
             
          </ul>
        </div>
        <hr/>
        <div>
         <Route exact path="/" component={Welcome}/>
          <Route  path="/viewMessages" component={ViewMessages}/>
          <Route  path="/viewMessagesVowels" component={ViewMessagesVowels}/>
          <Route  path="/deleteMessage" component={DeleteMessage}/>
          <Route  path="/postMessage" component={PostMessage}/>
        </div>
      </div>
    </Router>
  );
}

export default App;
