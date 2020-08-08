import React, {Component} from 'react';
import axios from 'axios';
import './App.css';


class Welcome extends Component {


    componentDidMount() {
        document.title = "Message Board";
    }

    render() {
        return (
            <div className="centered">
                 <div className="borderGreen">
                    <div className="centered"><h2>Welcome to Message Board.</h2></div>
                    <p>To test automated deployment, feel free to change this text at <b>message-board-ui/src/welcome.js</b></p>
                
                 </div>
            </div>
        );
    }

}

export default Welcome;
