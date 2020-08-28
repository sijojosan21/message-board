import React, {Component} from 'react';

import './App.css';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

import ViewMessages from './viewMessages';
import ViewMessagesVowels from './viewMessagesVowels';
import DeleteMessage from './deleteMessage';
import PostMessage from './postMessage';
import Welcome from './welcome';
import SearchMessages from './searchMessages';




function App() {

  return (
    <Router>
        
      <div className="App">
        <div className ="centered">
          
          <ul id="horizontal-list">
              <li id="menu_post"><Link to="/postMessage"  className="menu">Post Message</Link></li>
              <li id="menu_view"><Link to="/viewMessages" className="menu">View Messages</Link></li>
              <li id="menu_vowel"><Link to="/viewMessagesVowels" className="menu">Messages With Vowels</Link></li>
              <li id="menu_delete"><Link to="/deleteMessage" className="menu">Delete Message</Link></li>
              <li id="menu_search"><Link to="/searchMessages" className="menu">Search Messages</Link></li>
             
          </ul>
        </div>
        <hr/>
        <div>
         <Route exact path="/" component={Welcome}/>
          <Route  path="/viewMessages" component={ViewMessages}/>
          <Route  path="/viewMessagesVowels" component={ViewMessagesVowels}/>
          <Route  path="/deleteMessage" component={DeleteMessage}/>
          <Route  path="/postMessage" component={PostMessage}/>
          <Route  path="/searchMessages" component={SearchMessages}/>
        </div>
      </div>
    </Router>
  );
}

export default App;
