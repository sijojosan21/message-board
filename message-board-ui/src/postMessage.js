import React, {Component} from 'react';
import axios from 'axios';
import './App.css';

//axios.defaults.baseURL = 'http://localhost:4000';

class PostMessage extends Component {

    state = {
        user:null,
        header:null,
        body:null
    };
    
    activeComponent = 'PostMessage';

    request = {};

    componentDidMount() {
        document.title = "Post Messages";
    }

    myChangeHandler = (event) => {
        let nam = event.target.name;
        let val = event.target.value;
        this.setState({[nam]: val});
      }


    async postMessage() {
   
        this.request.message = this.state;

        const response = await axios.post('/message-board/api/message/add',this.request);
        if(response.data.responseCode==='COD001') {
            alert("Message was posted successfully.");
            document.getElementById("post1").value="";
            document.getElementById("post2").value="";
            document.getElementById("post3").value="";
        } else {
            alert("Ooops. Something went wrong.");
        }

        return false;
    }


    render() {
        return (
            <div className="centered">
                 <div className="borderGreen">
                     
                        <table>
                            <tbody>
                                <tr>
                                    <td>Your Name</td>
                                    <td>:</td>
                                    <td> <input type="text" id="post1" onChange={this.myChangeHandler} name="user" /></td>
                                </tr>
                                <tr>
                                    <td>Message Hedding</td>
                                    <td>:</td>
                                    <td> <input type="text" id="post2" onChange={this.myChangeHandler} name="header" /></td>
                                </tr>
                                <tr>
                                    <td>Message Details</td>
                                    <td>:</td>
                                    <td> <textarea id="post3"  onChange={this.myChangeHandler}  name="body" rows="12" cols="40" ></textarea></td>
                                </tr>
                                <tr>
                                    <td align="center" colSpan="3"><button onClick={() => this.postMessage()}>Post Message</button></td>
                                </tr>
                            </tbody>
                        </table>
                 
                    
                
                 </div>
            </div>
        );
    }

}

export default PostMessage;