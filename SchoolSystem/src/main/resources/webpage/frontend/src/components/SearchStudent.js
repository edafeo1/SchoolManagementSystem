import React, { Component } from 'react'
import StudentService from './services/StudentService';

export default class SearchStudent extends Component {

    constructor(props){
        super(props)

        this.state={
            idToGet: '',
            students: []
        }
       
        this.changeidToGet = this.changeidToGet.bind(this);
    
    }

    changeidToGet= (e) =>{
        this.setState({idToGet: e.target.value});

    }

    submit= (e) =>{
        e.preventDefault();
        this.setState({idToGet: e.target.value});

        console.log(this.state.idToGet);

        StudentService.getStudentById(this.state.idToGet).then((res)=>{
            
            console.log(res.data);
            this.setState({
                students:res.data
            });
            
        });
      

    }

 


    render() {
        return (
            <section>
        

                  <div>
						   <label htmlFor="contactName"> Enter Id to Search Student <span className="required">*</span></label>
						   <input value={this.state.idToGet} type="text"  size="35" id="contactName" name="contactName" onChange={this.changeidToGet}/>
                  </div>
                  
                  <div>
                  <button type='submit' onClick={this.submit} className="submit">Submit</button>
                  </div>


                

                  <h2>Selected Student By id</h2>
                <table className="studentTable">
                
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                </thead>


                <tbody>
                    
                        
                            <tr key={this.state.students.id}>
                                <td>{this.state.students.id}</td>
                                <td>{this.state.students.firstName}</td>
                                <td>{this.state.students.lastName}</td>
                                <td>{this.state.students.email}</td>
                            </tr>
                      
                </tbody>
                

            </table>

        </section>
        )
    }
}
