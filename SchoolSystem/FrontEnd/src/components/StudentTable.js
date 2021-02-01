import React, { Component } from 'react'
import StudentService from './services/StudentService'

export default class StudentTable extends Component {

    constructor(props){
        super(props)

        this.state= {
            students: []
        }

        this.addStudent = this.addStudent.bind(this);
        this.editStudentById = this.editStudentById.bind(this);
        this.deleteStudentById = this.deleteStudentById.bind(this);
    }


    componentDidMount(){
        StudentService.getStudents().then((res) =>{
            this.setState({students: res.data });
        });
    }

    editStudentById(id){
        this.props.history.push(`./updatebyid/${id}`);
    }

    deleteStudentById(id){
        StudentService.deleteStudentById(id).then(res =>{
            this.setState({students: this.state.students.filter(student => student.id !== id)});
        });
    }

    addStudent(){
        this.props.history.push('./addstudent');
    }


    render() {
        return (
            <section className="table-container">
                 <h2>Student Lists</h2>
                <table className="studentTable">
                
                <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
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
                                <td>
                                    <button onClick={()=> this.editStudentById(students.id)}>Update</button>
                                    <button onClick={()=> this.deleteStudentById(students.id)}>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
                

            </table>
            <button onClick={(this.addStudent)}>Add Student</button>
            </section>
        )
    }
}
