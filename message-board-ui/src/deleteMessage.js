import React, {Component} from 'react';
import axios from 'axios';
import './App.css';

//axios.defaults.baseURL = 'http://localhost:4000';

class DeleteMessage extends Component {

    state = {
        messages:[]
    };

    firstLoad = true;

    componentDidMount() {
        document.title = "Delete Message";
        this.fetchMessages();
    }

    msToTime(ms) {
        var dd = new Date(ms);
       return  dd.toLocaleDateString() + " " + dd.toLocaleTimeString();
    }

    async fetchMessages() {
        const response = await axios.get('/message-board/api/message/all');
        this.firstLoad = false;
        this.setState({messages: response.data.messages});
       
    }

    async deleteMessage(messageID) {
        const response = await axios.delete('/message-board/api/message/'+messageID);
        if(response.data.responseCode==='COD001') {
            this.fetchMessages();
            alert("Message was deleted.");
        }
    }

    renderMessages() {

        if(this.state.messages.length>0) {
            return this.state.messages.map((message, key) =>
                <div className="borderGreen" key={message.messageID}>
                    <span className="colourChocolate"><b>From : {message.user}</b></span>
                    <h3>{message.header}</h3>
                    <p>{message.body}</p>
                    <span className="colourDarkorchid"><b>Posted at : {this.msToTime(message.messageTimeStamp)}</b></span><br/><br/>
                    <button className="delete_but" onClick={() => this.deleteMessage(message.messageID)}>Delete</button>
                </div>         
            );
        } else if(this.firstLoad) {
            return(
                <div className="centered" >
                    Loading...
                </div>
            );
        } else {
            return(
                <div className="borderGreen" >
                    <h3>There are no messages to delete.</h3>
                </div>
            );
        }
    }


    render() {
        return (
            <div className="ViewMessage">
                {this.renderMessages()}
            </div>
        );
    }

}

export default DeleteMessage;