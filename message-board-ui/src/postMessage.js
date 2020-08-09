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


    postMessage() {
   
        this.request.message = this.state;
     
        axios.post('/message-board/api/message/add',this.request)
         .then((response) => {
            //console.log(response);  
             //if(response.satus==201) {
                alert("Message was posted successfully.");
                document.getElementById("post1").value="";
                document.getElementById("post2").value="";
                document.getElementById("post3").value="";            
            // }
         })
        .catch(function (error) {
            if (error.response) {
                if(error.response.status===400) {
                    alert(error.response.data.additionalErrors[0]);
                } else {
                    alert("Ooops. Something went wrong.");
                }
            }
          });
        
         this.state = {
            user:null,
            header:null,
            body:null
        };
             
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
                                    <td align="center" colSpan="3"><button id="post_sum" onClick={() => this.postMessage()}>Post Message</button></td>
                                </tr>
                            </tbody>
                        </table>
                 
                    
                
                 </div>
            </div>
        );
    }

}

export default PostMessage;