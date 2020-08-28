import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
import _ from 'lodash';

//axios.defaults.baseURL = 'https://reqres.in';

class SearchMessages extends Component {

    state = {
        rows: [],
        userInput: "",
    };

    onChange = e => {

        e.persist();

        if (!this.debouncedFn) {
            this.debouncedFn = _.debounce(() => {
                const userInput = e.target.value
                console.log("onChange-" + userInput);
                this.fetchMessages(userInput)
            }, 700);
        }

        this.debouncedFn();
    }


    firstLoad = true;

    componentDidMount() {
        document.title = "Search Messages";
    }


    msToTime(ms) {
        var dd = new Date(ms);
        return dd.toLocaleDateString() + " " + dd.toLocaleTimeString();
    }

    async fetchMessages(userInputValue) {

        if (userInputValue.length > 2) {
            console.log("fetchMessages-" + userInputValue);
            const response = await axios.get('/message-board/api/message/search?query='+userInputValue);
            this.firstLoad = false;
            this.setState({ rows: response.data.data, userInput: userInputValue });
        } else {
            this.setState({ rows: [], userInput: userInputValue });
        }
    }

    renderMessages() {



        let messageListComponent;

        if (this.state.rows.length > 0) {
            messageListComponent = (
                <div>
                    {this.state.rows.map((message, key) =>
                        <div className="borderGreen" key={message.messageID}>
                            <span className="colourChocolate"><b>From : {message.user}</b></span>
                            <h3>{message.header}</h3>
                            <p>{message.body}</p>
                            <span className="colourDarkorchid"><b>Posted at : {this.msToTime(message.messageTimeStamp)}</b></span><br /><br />
                        </div>
                    )};
                </div>
            );
        } else {
            messageListComponent = (
                <div className="centered" >
                    Start Searching.
                </div>
            );
        }

        return (
            <React.Fragment>
                <br /><br />
                <div className="centered">
                    <input type="search" onChange={this.onChange} className="search-box" />
                </div>
                <br /><br />
                {messageListComponent}
            </React.Fragment>
        );

    }

    render() {

        return (
            <div className="ViewMessage">
                {this.renderMessages()}
            </div>
        );
    }

}

export default SearchMessages;