import React, { Component } from 'react'
import StudentService from './services/StudentService'

export default class StudentTable extends Component {

    constructor(props){
        super(props)

        this.state= {
            students: []
        }
    }


    componentDidMount(){
        StudentService.getStudents().then((res) =>{
            this.setState({students: res.data });
        });
    }


    render() {
        return (
            <section>
                 <h2>Student Lists</h2>
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
                    {
                        this.state.students.map(
                            students=>
                            <tr key={students.id}>
                                <td>{students.id}</td>
                                <td>{students.firstName}</td>
                                <td>{students.lastName}</td>
                                <td>{students.email}</td>
                            </tr>
                        )
                    }
                </tbody>
                

            </table>
            </section>
        )
    }
}
